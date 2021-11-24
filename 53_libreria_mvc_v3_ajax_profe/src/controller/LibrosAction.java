package controller;

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
import service.TemasService;


/**
 * Servlet implementation class LibrosAction
 */
@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	@Inject
	LibrosService glibros;
	@Inject
	TemasService gtemas;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema=Integer.parseInt(request.getParameter("idTema"));
	
		
		List<Libro> libros;
		//si idTema es 0 es que ha elegido todos
		if(idTema==0){
			libros=glibros.recuperarLibros();
		}
		else{
			libros=glibros.recuperarLibros(idTema);
		}
		Gson gson=new Gson();
		String json=gson.toJson(libros);
		//response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		try(PrintWriter out=response.getWriter();){
			out.println(json);
		}
	}

}
