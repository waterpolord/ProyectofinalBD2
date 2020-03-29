package Logic;

import java.util.ArrayList;

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
	
}
