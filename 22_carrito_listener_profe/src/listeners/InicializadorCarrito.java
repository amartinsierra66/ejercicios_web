package listeners;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.Producto;

/**
 * Application Lifecycle Listener implementation class InicializadorCarrito
 *
 */
@WebListener
public class InicializadorCarrito implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession sesion=se.getSession();
         //creamos carrito vacío
         sesion.setAttribute("carrito", new ArrayList<Producto>());
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
