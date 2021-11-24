package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Libro;

/**
 * Servlet implementation class EliminarCarritoAction
 */
@WebServlet("/EliminarCarritoAction")
public class EliminarCarritoAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		//recuperamos carrito que tenemos en un atributo de sesión
		List<Libro> carrito=(List<Libro>)s.getAttribute("carrito");
		//si la sesión no ha caducado y hay carrito
		if(carrito.size()>0) {
			//recogemos el parametro con la posición del libro
			int pos=Integer.parseInt(request.getParameter("pos"));
			
			carrito.remove(pos);
		}
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
