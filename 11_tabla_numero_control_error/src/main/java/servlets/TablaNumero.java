package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TablaMultiplicarServlet
 */
@WebServlet("/TablaNumero")
public class TablaNumero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			int numero=Integer.parseInt(request.getParameter("numero"));
			out.println("<html><body><center>");
			out.println("<h1>Tabla del "+numero+"</h1>");
			out.println("<table border='1'>");
			for(int fila=1;fila<=10;fila++) {
				out.println("<tr>");
				out.println("<td>"+numero+"X"+fila+"</td><td>"+numero*fila+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<a href='datos.html'>Volver</a>");
			
			out.println("</center></body></html>");
		}catch(NumberFormatException ex) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("Error");
			dispatcher.forward(request, response);
		}
	}

}
