package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		//creamos la cookie con la fecha actual
		LocalDateTime fechaHora=LocalDateTime.now();
		Cookie cookie=new Cookie("fecha",fechaHora.toString());
		cookie.setMaxAge(1_000_000);
		response.addCookie(cookie);
		
		
		//le pasamos a la página JSP la lista de páginas
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("buscador.jsp").forward(request, response);
	}

}
