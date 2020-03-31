package DAO;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Logic.Usuario;
import jaco.mp3.a.A;

public interface DAO<tipo,id> {
	void insertar(tipo x) throws DAOException;
	
	void modificar(tipo x) throws DAOException;
	
	void eliminar(tipo x) throws DAOException;
	
	ArrayList<?> obtenerTodos() throws DAOException;
	
	tipo obtener(id clave) throws DAOException;
}
