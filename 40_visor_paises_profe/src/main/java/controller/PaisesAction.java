package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PaisesService;

/**
 * Servlet implementation class PaisesAction
 */
@WebServlet("/PaisesAction")
public class PaisesAction extends HttpServlet {
	@Inject
	PaisesService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String continente =request.getParameter("continente");
		request.setAttribute("paises",service.paisesPorContinente(continente));
		request.setAttribute("habitantes", service.poblacionContinente(continente));
		
	}

}
