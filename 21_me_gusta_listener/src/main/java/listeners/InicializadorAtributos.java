package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class InicializadorAtributos implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         //crear el atributo de aplicación "contador" e inicializarlo a 0
    	ServletContext context=sce.getServletContext();
    	context.setAttribute("contador", 0);
    }
	
}
