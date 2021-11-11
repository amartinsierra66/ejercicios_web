package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import service.LibrosService;
import service.LibrosServiceFactory;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String textoBusqueda=request.getParameter("texto");
		String opcion=request.getParameter("opcion");
		LibrosService service=LibrosServiceFactory.getLibrosService();
		RequestDispatcher dispatcher;
		if(opcion.equals("tema")){
			List<Libro> libros=service.librosPorTematica(textoBusqueda);
			if(libros!=null&&libros.size()>0) {
				//guardamos los libros en un atributo de petición para que los vea la JSP
				request.setAttribute("libros",libros );
				dispatcher=request.getRequestDispatcher("libros.jsp");
			}else {
				dispatcher=request.getRequestDispatcher("sinresultados.jsp");
			}
		}else {
			Libro libro=service.libroPorIsbn(Integer.parseInt(textoBusqueda));
			if(libro!=null) {
				//guardamos el libro encontrado en un atributo de petición para que lo vea la JSP
				request.setAttribute("libro",libro );
				dispatcher=request.getRequestDispatcher("libro.jsp");
			}else {
				dispatcher=request.getRequestDispatcher("error.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

}
