package DAO;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Logic.Usuario;

public interface DAO<tipo,id> {
	void insertar(tipo x);
	
	void modificar(tipo x);
	
	void eliminar(tipo x);
	
	List obtenerTodos();
	
	tipo obtener(id clave);
}
