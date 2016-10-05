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
			String url="jdbc:mysql://us-cdbr-azure-east-c.cloudapp.net/bd_pago_tarjeta";
			conexion = DriverManager.getConnection(url,"b9e27a08f2fd40","0f2ce75c");
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
