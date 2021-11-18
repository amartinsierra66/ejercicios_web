package intercepting;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Cliente;


@WebFilter("/*")
public class FiltroLogin implements Filter {

    

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//comprobamos atributo de sesión "cliente", si no existe se le manda a la página de login
		//para que se autentique
		HttpSession sesion=((HttpServletRequest)request).getSession();
		Cliente cliente=(Cliente)sesion.getAttribute("cliente");
		String path=((HttpServletRequest)request).getServletPath(); //dirección solicitada por el usuario
		String param=((HttpServletRequest)request).getParameter("option");
		Stream<String> valores=Stream.of("doLogin","doRegistrar","toRegistro");
		if(cliente!=null) {
			chain.doFilter(request, response);
		}else {
			if(path.equals("/")||(path.equals("/Controller")&&valores.anyMatch(s->s.equals(param)))) {
				chain.doFilter(request, response);
			}else {
				request.getRequestDispatcher("login.html").forward(request, response);
			}
		}
				
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
