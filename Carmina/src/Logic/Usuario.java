package Logic;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;

public class Usuario {
	private Long id;
	private String Nombre;
	private String Apellido;
	private String Username;
	private String Clave;
	private String Nacimiento;
	private ArrayList<Playlist> MisPlayList;
	
	public Usuario(String nombre, String apellido, String username, String clave, String nacimiento) {
		Nombre = nombre;
		Apellido = apellido;
		Username = username;
		Clave = clave;
		Nacimiento = nacimiento;
	}
	
	public void setPlayList(Playlist Nueva) {
		MisPlayList.add(Nueva);
	}
	
	public void setPlayListFromDB(ArrayList<Playlist> playlist) {
		MisPlayList.addAll(playlist);
	}
	
	public BasicDBObject toBDBObjectUsuario() {
		BasicDBObject dbbo = new BasicDBObject();
		 dbbo.append("id_usuario",this.id);
		 dbbo.append("Nombre",this.Nombre);
	     dbbo.append("Apellido",this.Apellido);
	     dbbo.append("Username",this.Username);
	     dbbo.append("Clave",this.Clave);
	     dbbo.append("Nacimiento",this.Nacimiento);
	     if(MisPlayList.size() > 0) {
	    	 dbbo.append("Playlist",this.MisPlayList);
	    }
		return dbbo;
	}
	
}
