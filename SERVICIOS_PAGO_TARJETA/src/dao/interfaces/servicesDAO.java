package dao.interfaces;

import java.util.ArrayList;

import beans.TarjetaBean;

public interface servicesDAO {

	public boolean buscarTarjeta(TarjetaBean tarjeta);
	public boolean realizarTransaccion(TarjetaBean tarjeta);
	
	
}
