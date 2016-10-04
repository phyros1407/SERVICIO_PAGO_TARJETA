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
	public boolean buscarTarjeta(TarjetaBean tarjeta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean realizarTransaccion(TarjetaBean tarjeta) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}