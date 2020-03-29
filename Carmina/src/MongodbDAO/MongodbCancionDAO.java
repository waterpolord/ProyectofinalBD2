package MongodbDAO;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import DAO.CancionDAO;
import Logic.Cancion;

public class MongodbCancionDAO implements CancionDAO{
	
	private MongoClient mc;
	private DB DataBase;
	private MongoCollection collection;
	
	public MongodbCancionDAO(MongoClient mc, DB dataBase, MongoCollection collection) {
		super();
		this.mc = mc;
		DataBase = dataBase;
		this.collection = collection;
	}
	
	@Override
	public void insertar(Cancion x) {
		// TODO Auto-generated method stub
		
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
	public List obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cancion obtener(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

}
