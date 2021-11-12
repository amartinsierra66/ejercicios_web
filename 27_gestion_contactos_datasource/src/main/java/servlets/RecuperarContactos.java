package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;
import service.ContactosServiceFactory;

/**
 * Servlet implementation class RecuperarContactos
 */
@WebServlet("/RecuperarContactos")
public class RecuperarContactos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactosService service=ContactosServiceFactory.getContactosService();
		List<Contacto> contactos=service.recuperarContactos();
		if(contactos!=null&&contactos.size()>0) {
			//guardamos los contactos en un atributo de petición para que los pueda
			//recuperar la página jsp
			request.setAttribute("contactos", contactos);
			request.getRequestDispatcher("contactos.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("sincontactos.html").forward(request, response);
		}
	}

}
