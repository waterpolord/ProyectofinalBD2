package Logic;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;

public class Cancion {
	
	private String Nombre;
	private ArrayList<String> Artistas;
	private String Genero;
	private String Duracion;
	private String Album;
	private String url;
	
	public Cancion(String nombre, ArrayList<String> artistas, String genero, String duracion, String album,
			String url) {
		   
			Nombre = nombre;
			Artistas = artistas;
			Genero = genero;
			Duracion = duracion;
			Album = album;
			this.url = url;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public ArrayList<String> getArtistas() {
		return Artistas;
	}

	public void setArtistas(ArrayList<String> artistas) {
		Artistas = artistas;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getDuracion() {
		return Duracion;
	}

	public void setDuracion(String duracion) {
		Duracion = duracion;
	}

	public String getAlbum() {
		return Album;
	}

	public void setAlbum(String album) {
		Album = album;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public BasicDBObject toBDBObjectCancion() {
		BasicDBObject dbbo = new BasicDBObject();
		 
		 dbbo.append("Nombre",this.getNombre());
	     dbbo.append("Artistas",this.getArtistas());
	     dbbo.append("Genero",this.getGenero());
	     dbbo.append("Duracion",this.getDuracion());
	     dbbo.append("Album",this.getAlbum());
	     dbbo.append("url",this.getUrl());
	    
		return dbbo;
	}
	
}
