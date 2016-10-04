package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.TarjetaBean;
import dao.factory.MySqlDAOFactory;
import dao.interfaces.servicesDAO;

public class servicesMySqlDAO extends MySqlDAOFactory implements servicesDAO{

	@Override
	public double buscarTarjeta(TarjetaBean tarjeta) {
		// TODO Auto-generated method stub
		
		
		
		try{

			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = " SELECT * "
						+  " FROM T_TARJETA "
						+  " WHERE NUM_TAR = '"+tarjeta.getNum_tar()+"' AND CVC = '"+tarjeta.getCvc()+"' AND ANO_CAD = "+tarjeta.getAno_cad()+" AND MES_CAD = "+tarjeta.getMes_cad()+" ";
			
			System.out.println("QUERY EJECUTADO ----> "+query);
			
			ResultSet rs = stmt.executeQuery(query);
			

			if((rs.isFirst())){
				return -1;
			}else{
			
				return rs.getDouble("saldo");
				
			}
			
		}catch(Exception e){
			e.getMessage();
		}
		
		return 0;
	}

	@Override
	public boolean realizarTransaccion(TarjetaBean tarjeta) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		
		try{
			
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = " UPDATE T_TARJETA "
						+  " SET SALDO = "+tarjeta.getSaldo()+" "
						+  " WHERE NUM_TAR = '"+tarjeta.getNum_tar()+"'";
			
			System.out.println(query);
			
			int filas = stmt.executeUpdate(query);
			
			if(filas == 1){
				flag = true;
			}
			
			
		}catch(Exception e){
			e.getMessage();
		}
		return flag;
	}
	
	
}