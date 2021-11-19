package controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.Libro;
import service.VentasService;

/**
 * Servlet implementation class ProcesarCompraAction
 */
@WebServlet("/ProcesarCompraAction")
public class ProcesarCompraAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	VentasService ventasService;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion= request.getSession();
		List<Libro> carrito=(List<Libro>)sesion.getAttribute("carrito");
		ventasService.nuevaVenta((Cliente)sesion.getAttribute("cliente"), 
				carrito);
		carrito.clear();//vaciar el carrito
		
	}

}
