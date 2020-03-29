package Logic;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;

import DAO.CancionDAO;
import DAO.DAOManager;
import DAO.UsuarioDAO;
import MongodbDAO.MongodbCancionDAO;
import MongodbDAO.MongodbUsuarioDAO;

public class Principal implements DAOManager {
	private MongoClient mc;
	private DB DataBase;
	
	private CancionDAO Canciones = null;
	private UsuarioDAO Usuarios = null;
	
	public static void main(String[] args) {
		new Principal("mongodb://bd2mongo:Pml8V8QUQUVyw5yzSlIjUfkYTdmArlCiUyW7PC20wc4ZvucC0Zx4XAdckoqNw2IRpjOlYh33cXczqfoS44Pqkg==@bd2mongo.documents.azure.com:10255/?ssl=true&replicaSet=globaldb");
	}
	
	
	public Principal(String url) {
		mc = new MongoClient( new MongoClientURI(url));
		DataBase = mc.getDB("Carmina");
		
	}

	@Override
	public CancionDAO getCancionDAO() {
		
		if(Canciones == null) {
			Canciones = new MongodbCancionDAO(mc,DataBase, (MongoCollection) DataBase.getCollection("Cancion"));
		}
		
		return Canciones;
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		if(Usuarios == null) {
			Usuarios = new MongodbUsuarioDAO(mc,DataBase, (MongoCollection) DataBase.getCollection("Usuario"));
		}
		
		return Usuarios;
	}
	
}
