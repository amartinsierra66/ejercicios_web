package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		if(option==null) {
			option="doContinentes";
		}
		String url="paises.jsp";
		switch(option) {
			case "doContinentes":
				request.getRequestDispatcher("ContinentesAction").include(request, response);
				break;
			case "doPaises":
				request.getRequestDispatcher("PaisesAction").include(request, response);
				request.getRequestDispatcher("ContinentesAction").include(request, response);
				break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
