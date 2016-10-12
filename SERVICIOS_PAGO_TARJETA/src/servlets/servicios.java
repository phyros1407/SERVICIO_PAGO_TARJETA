package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.TarjetaBean;
import dao.factory.DAOFactory;
import dao.interfaces.servicesDAO;
import util.ResponseObject;

/**
 * Servlet implementation class servicios
 */
@WebServlet("/servicios")
public class servicios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servicios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		servicesDAO serv = dao.getServiceDAO();
		
		String action = request.getParameter("action");
		System.out.println("imprimir action --->"+action);
		
		if(action.equalsIgnoreCase("pagos")){
			
			String tip_tar = request.getParameter("tip_tar");
			String mar_tar = request.getParameter("mar_tar");
			String num_tar = request.getParameter("numero");
			String cvc = request.getParameter("cvc");
			int mes = Integer.parseInt(request.getParameter("mes"));
			int anio = Integer.parseInt(request.getParameter("anio"));
			double monto = Double.parseDouble(request.getParameter("monto"));
			
			TarjetaBean tarjeta = new TarjetaBean();
			tarjeta.setTip_tar(tip_tar);
			tarjeta.setMar_tar(mar_tar);
			tarjeta.setNum_tar(num_tar);
			tarjeta.setCvc(cvc);
			tarjeta.setMes_cad(mes);
			tarjeta.setAno_cad(anio);
			
			
			System.out.println("hasta aca llego la webada");
			
			double saldo = serv.buscarTarjeta(tarjeta);
			System.out.println("SALDO ACTUAL ---->"+saldo);
			
			System.out.println("salio de la webada");
			
			ResponseObject responseobj=null;
			
			if(saldo!=-1.0){
				
				System.out.println(saldo-monto);
				
				if(saldo-monto<0){
					
					responseobj=new ResponseObject();
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					responseobj.setSuccess(true);
					responseobj.setObject("NO APROBADO");

					
				}else{

					tarjeta.setSaldo(saldo-monto);

					if(serv.realizarTransaccion(tarjeta)){
						
						responseobj=new ResponseObject();
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						responseobj.setSuccess(true);
						responseobj.setObject("APROBADO");
						
					}else{
						
						responseobj=new ResponseObject();
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						responseobj.setSuccess(true);
						responseobj.setObject("NO APROBADO");
							
					}
				
				}
				
				response.getWriter().write(new Gson().toJson(responseobj));
				System.out.println("json" + new Gson().toJson(responseobj));
				
				
			}else{
				

				responseobj=new ResponseObject();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				responseobj.setSuccess(true);
				responseobj.setObject("NO TARJETA");
				
				
				response.getWriter().write(new Gson().toJson(responseobj));
				System.out.println("json" + new Gson().toJson(responseobj));
				
				
			}
			
			
		}
		
		
	}


		
}
