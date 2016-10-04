package dao.interfaces;

import beans.TarjetaBean;

public interface servicesDAO {

	public double buscarTarjeta(TarjetaBean tarjeta);
	public boolean realizarTransaccion(TarjetaBean tarjeta);
	
	
}
