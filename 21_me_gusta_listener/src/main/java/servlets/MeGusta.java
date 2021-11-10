package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MeGusta
 */
@WebServlet("/MeGusta")
public class MeGusta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoge el atributo de aplicación que contiene el contador global
		//lo incrementa en uno y lo actualiza
		ServletContext context=request.getServletContext();
		Integer contador=(Integer)context.getAttribute("contador");
		contador++;
		context.setAttribute("contador", contador);
		request.getRequestDispatcher("megusta.jsp").forward(request, response);
	}

}
