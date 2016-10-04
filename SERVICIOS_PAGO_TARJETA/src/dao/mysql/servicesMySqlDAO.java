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
		
		double saldoActual = 0;
		
		try{

			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = " SELECT SALDO "
						+  " FROM T_TARJETA "
						+  " WHERE NUM_TAR = '"+tarjeta.getNum_tar()+"' AND CVC = '"+tarjeta.getCvc()+"' AND ANO_CAD = "+tarjeta.getAno_cad()+" AND MES_CAD = "+tarjeta.getMes_cad()+" ";
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(!(rs.isFirst())){
				saldoActual = -1;
			}else{
				while(rs.next()){
					saldoActual = rs.getDouble("1");
				}
			}
			
		}catch(Exception e){
			e.getMessage();
		}
		
		return saldoActual;
	}

	@Override
	public boolean realizarTransaccion(TarjetaBean tarjeta) {
		// TODO Auto-generated method stub
		
		try{
			
			Connection con = MySqlDAOFactory.obtenerConexion();
			Statement stmt = con.createStatement();
			
			String query = " UPDATE T_TARJETA "
						+  " SET SALDO = "+tarjeta.getSaldo()+" "
						+  " WHERE NUM_TAR = '"+tarjeta.getNum_tar()+"'";
			
		}catch(Exception e){
			e.getMessage();
		}
		return false;
	}
	
	
}