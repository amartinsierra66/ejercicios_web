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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Libro;
import service.LibrosService;

@WebServlet("/AgregarCarritoAction")
public class AgregarCarritoAction extends HttpServlet {
	@Inject
	LibrosService glibros;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		
		//recuperamos carrito que tenemos en un atributo de sesión
		List<Libro> carrito=(List<Libro>)s.getAttribute("carrito");
		
		//recogemos el parametro con el isbn del libro a añadir
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		
		//Añadimos libro obtenido al carrito
		carrito.add(glibros.recuperarLibroPorIsbn(isbn));
		Gson gson=new Gson();
		String json=gson.toJson(carrito);
		//response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		try(PrintWriter out=response.getWriter();){
			out.println(json);
		}
		
	}

}
