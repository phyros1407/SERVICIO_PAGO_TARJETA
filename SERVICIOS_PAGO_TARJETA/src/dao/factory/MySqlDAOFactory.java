package dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.interfaces.servicesDAO;
import dao.mysql.servicesMySqlDAO;

public class MySqlDAOFactory extends DAOFactory{

	

	
	public static Connection obtenerConexion(){
		Connection conexion=null;
		
		 try {
			 
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://mysql19602-servicios2.j.facilcloud.com/bd_pago_tarjeta";
			conexion = DriverManager.getConnection(url,"root","TDPdrx21005");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		 
		return conexion;
	}

	@Override
	public servicesDAO getServiceDAO() {
		// TODO Auto-generated method stub
		return new servicesMySqlDAO();
	}

	
	
}
