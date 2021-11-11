package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;
import service.ContactosServiceFactory;

/**
 * Servlet implementation class AltaContacto
 */
@WebServlet("/AltaContacto")
public class AltaContacto extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contacto contacto=new Contacto(0, 
				request.getParameter("nombre"), 
				request.getParameter("email"), 
				Integer.parseInt(request.getParameter("edad")));
		ContactosService service=ContactosServiceFactory.getContactosService();
		service.altaContacto(contacto);
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
