package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		//obtenemos el carrito que está almacenado en la sesión
		List<Producto> productos=(List<Producto>)s.getAttribute("carrito");
		//eliminamos el producto que ocupa la posición recibida como parámetro
		//pero solo si el carrito sigue existiendo
		if(productos!=null) {
			int pos=Integer.parseInt(request.getParameter("posicion"));
			//eliminamos el producto
			productos.remove(pos);
			request.getRequestDispatcher("carrito.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("sincarrito.jsp").forward(request, response);
		}
	}

}
