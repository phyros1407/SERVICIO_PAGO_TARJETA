package dao.factory;

import dao.interfaces.servicesDAO;

public abstract class DAOFactory {

	public static final int MYSQL=1;
	public static final int SQLSERVER=2;
	public static final int ORACLE=3;
	
	public abstract servicesDAO getServiceDAO(); 
	
public static DAOFactory getDAOFactory(int factory){
		
		switch (factory) {
		case MYSQL:
			return new MySqlDAOFactory();
		

		default:
			return null;
		}
		
	}

			
	
	
}
