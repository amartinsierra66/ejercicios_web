package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ContactosService;
import service.ContactosServiceFactory;

/**
 * Servlet implementation class EliminarContacto
 */
@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idContacto=Integer.parseInt(request.getParameter("idContacto"));
		ContactosService service=ContactosServiceFactory.getContactosService();
		service.eliminarContacto(idContacto);
		//volvemos a llamar al servlet que recupera los contactos de la base de datos
		//y transfiere el control a la página JSP que los muestra
		//request.getRequestDispatcher("RecuperarContactos").forward(request, response);
	}

}
