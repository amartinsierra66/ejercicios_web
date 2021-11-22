package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Libro;
import service.LibrosService;

/**
 * Servlet implementation class Buscador
 */
@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	@Inject
	//@Named("librosService") solo es necesaria si hay más de una implementación de la interfaz
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> libros=service.librosTotales();
		Gson gson=new Gson();
		String librosJson=gson.toJson(libros);
		//response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		try(PrintWriter out=response.getWriter();){
			out.println(librosJson);
		}
		
	}

}
