package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClientesService;
import service.LibreriaFactory;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		ClientesService clientesService=LibreriaFactory.getClientesService();
		Cliente cliente=clientesService.validarCliente(request.getParameter("user"),request.getParameter("pwd"));
		if(cliente!=null) {            
			request.setAttribute("resultado", true);
		}
		else{
			
			request.setAttribute("resultado", false);
		}
       
        
	}
	

}
