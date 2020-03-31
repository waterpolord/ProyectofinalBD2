package Logic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;

import DAO.CancionDAO;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.UsuarioDAO;
import MongodbDAO.MongodbCancionDAO;
import MongodbDAO.MongodbUsuarioDAO;
import jaco.mp3.player.MP3Player;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import sun.applet.Main;
import visual.Inicio;

public class Principal implements DAOManager {
	private MongoClient mc;
	private DB DataBase;
	
	private CancionDAO Canciones = null;
	private UsuarioDAO Usuarios = null;
	private ArrayList<Cancion> MisCanciones;
	
	


	public static void main(String[] args) {
		new Principal("mongodb://bd2mongo:Pml8V8QUQUVyw5yzSlIjUfkYTdmArlCiUyW7PC20wc4ZvucC0Zx4XAdckoqNw2IRpjOlYh33cXczqfoS44Pqkg==@bd2mongo.documents.azure.com:10255/?ssl=true&replicaSet=globaldb");
		new Inicio().setVisible(true);
	}
	
	
	
	
	
	public Principal(String url) {
		mc = new MongoClient( new MongoClientURI(url));
		DataBase = mc.getDB("Carmina");
		MisCanciones = new ArrayList<Cancion>();
		getCancionDAO();
		getUsuarioDAO();
		try {
			setMisCancionesFromDB();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public CancionDAO getCancionDAO() {
		
		if(Canciones == null) {
			Canciones = new MongodbCancionDAO(mc,DataBase, (DBCollection) DataBase.getCollection("Cancion"));
		}
		
		return Canciones;
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		if(Usuarios == null) {
			Usuarios = new MongodbUsuarioDAO(mc,DataBase, (DBCollection) DataBase.getCollection("Usuario"));
		}
		
		return Usuarios;
	}
	
	public ArrayList<Cancion> getMisCanciones() {
		return MisCanciones;
	}


	public void setMisCancionesFromDB() throws DAOException {
		MisCanciones = (ArrayList<Cancion>) Canciones.obtenerTodos();
		
	}
	
	public void addCancion(Cancion Nuevo) {
		MisCanciones.add(Nuevo);
	}
	
}
