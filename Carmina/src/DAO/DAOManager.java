package DAO;

public interface DAOManager {
	
	CancionDAO getCancionDAO() throws DAOException;
	UsuarioDAO getUsuarioDAO();

}
