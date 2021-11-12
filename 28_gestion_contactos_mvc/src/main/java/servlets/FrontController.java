package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="inicio.html"; //dirección de la vista final
		String option=request.getParameter("op");
		switch(option) {
			case "doAlta":
				//utilizamos include para que devuelva el control de nuevo al FrontController
				request.getRequestDispatcher("AltaAction").include(request, response);
				url="inicio.html";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarAction").include(request, response);
				//no ponemos el break para que entre a realizar también las operaciones
				// de doRecuperar
			case "doRecuperar":
				request.getRequestDispatcher("RecuperarAction").include(request, response);
				url=(Boolean)request.getAttribute("resultado")?"contactos.jsp":"sincontactos.html";
				break;
			case "toInicio":
				url="inicio.html";
				break;
			case "toNuevo":
				url="nuevo.html";
				break;
		}
		//dirigir la petición a la vista
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
