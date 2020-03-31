package MongodbDAO;

import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import DAO.CancionDAO;
import Logic.Cancion;

public class MongodbCancionDAO implements CancionDAO{
	
	private MongoClient mc;
	private DB DataBase;
	private DBCollection collection;
	
	public MongodbCancionDAO(MongoClient mc, DB dataBase, DBCollection dbCollection) {
		super();
		this.mc = mc;
		DataBase = dataBase;
		this.collection = dbCollection;
	}
	
	@Override
	public void insertar(Cancion x) {
		// TODO Auto-generated method stub
		collection.insert(x.toBDBObjectCancion());
	}

	@Override
	public void modificar(Cancion x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Cancion x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Cancion> obtenerTodos(){
		
			ArrayList<Cancion> canciones = new ArrayList<Cancion>();
			com.mongodb.Cursor cursor = collection.find();
			while(cursor.hasNext()) {
				DBObject obj = cursor.next();
				String Nombre = (String) obj.get("Nombre");
				ArrayList<String> Artistas = (ArrayList<String>) obj.get("Artistas");
				String Genero = (String) obj.get("Genero");
				String Duracion = (String) obj.get("Duracion");
				String Album = (String) obj.get("Album");
				String url = (String) obj.get("url");
				
				Cancion cancion = new Cancion(Nombre, Artistas, Genero, Duracion, Album, url);
				canciones.add(cancion);
			}
		
		return canciones;
	}

	@Override
	public Cancion obtener(String clave) {
		// TODO Auto-generated method stub
		
	
		com.mongodb.Cursor cursor = collection.find();
	
		while(cursor.hasNext()) {
			
		}
		return null;
	}

}
