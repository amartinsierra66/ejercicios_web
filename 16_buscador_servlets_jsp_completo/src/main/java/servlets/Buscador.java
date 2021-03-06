package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagina;
import service.BuscadorServiceFactory;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clave=request.getParameter("clave");
		List<Pagina> lista=BuscadorServiceFactory.getBuscadorService().buscar(clave);
		//le pasamos a la p?gina JSP la lista de p?ginas
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("buscador.jsp").forward(request, response);
	}

}
