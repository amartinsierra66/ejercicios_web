package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class UsuariosActivos implements ServletContextListener, HttpSessionListener {

    
    public void sessionCreated(HttpSessionEvent se)  { 
         ServletContext context=se.getSession().getServletContext();
         int activos=(Integer)context.getAttribute("activos");
         activos++;
         context.setAttribute("activos", activos);
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	ServletContext context=se.getSession().getServletContext();
        int activos=(Integer)context.getAttribute("activos");
        activos--;
        context.setAttribute("activos", activos);
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext context=sce.getServletContext();
         context.setAttribute("activos", 0);
    }
	
}
