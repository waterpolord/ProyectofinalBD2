package MongodbDAO;

import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import DAO.UsuarioDAO;
import Logic.Cancion;
import Logic.Playlist;
import Logic.Usuario;

public class MongodbUsuarioDAO implements UsuarioDAO {
	
	// MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://bd2mongo:Pml8V8QUQUVyw5yzSlIjUfkYTdmArlCiUyW7PC20wc4ZvucC0Zx4XAdckoqNw2IRpjOlYh33cXczqfoS44Pqkg==@bd2mongo.documents.azure.com:10255/?ssl=true&replicaSet=globaldb"));
	private MongoClient mc;
	private DB DataBase;
	private DBCollection collection;
	
	public MongodbUsuarioDAO(MongoClient mc, DB dataBase, DBCollection collection) {
		super();
		this.mc = mc;
		DataBase = dataBase;
		this.collection = collection;
	}

	@Override
	public void insertar(Usuario x) {
		// TODO Auto-generated method stub
		collection.insert(x.toBDBObjectUsuario());
	}

	@Override
	public void modificar(Usuario x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Usuario x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Usuario> obtenerTodos() {
		// TODO Auto-generated method stub
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		com.mongodb.Cursor cursor = collection.find();
		while(cursor.hasNext()) {
			DBObject obj = cursor.next();
			String Nombre = (String) obj.get("Nombre");
			String Apellido = (String)obj.get("Apellido");
			String username = (String) obj.get("Username");
			String Clave = (String) obj.get("Clave");
			String Nacimiento = (String) obj.get("Nacimiento");
			ArrayList<Playlist> playlist = (ArrayList<Playlist>) obj.get("Playlist");
			
			Usuario user = new Usuario(Nombre,Apellido,username,Clave,Nacimiento);
			if(playlist.size() > -1) {
				user.setPlayListFromDB(playlist);
			}
			usuarios.add(user);
		}
	
	return usuarios;
		
	}

	@Override
	public Usuario obtener(Long clave) {
		// TODO Auto-generated method stub
		return null;
	}

}
