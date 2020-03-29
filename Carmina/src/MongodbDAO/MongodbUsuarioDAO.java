package MongodbDAO;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import DAO.UsuarioDAO;
import Logic.Usuario;

public class MongodbUsuarioDAO implements UsuarioDAO {
	
	// MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://bd2mongo:Pml8V8QUQUVyw5yzSlIjUfkYTdmArlCiUyW7PC20wc4ZvucC0Zx4XAdckoqNw2IRpjOlYh33cXczqfoS44Pqkg==@bd2mongo.documents.azure.com:10255/?ssl=true&replicaSet=globaldb"));
	private MongoClient mc;
	private DB DataBase;
	private MongoCollection collection;
	
	public MongodbUsuarioDAO(MongoClient mc, DB dataBase, MongoCollection collection) {
		super();
		this.mc = mc;
		DataBase = dataBase;
		this.collection = collection;
	}

	@Override
	public void insertar(Usuario x) {
		// TODO Auto-generated method stub
		
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
	public List obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtener(Long clave) {
		// TODO Auto-generated method stub
		return null;
	}

}
