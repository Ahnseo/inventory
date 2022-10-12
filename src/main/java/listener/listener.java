package listener;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class listener
 *
 */
@WebListener
public class listener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         //초기 마리아db 연결
    	//1. JDBC 드라이버 로딩 +exception 처리
    	try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        ServletContext application = sce.getServletContext();
        
        //jdbc 접속 정보 application 영역에 넣기
        String propFile ="/WEB-INF/props/jdbc.properties";
        
        try(InputStream is = application.getResourceAsStream(propFile); ) {
        	Properties props = new Properties();
        	props.load(is);
        	
        	application.setAttribute("jdbc.url", props.getProperty("jdbc.url"));
        	application.setAttribute("jdbc.username", props.getProperty("jdbc.username"));
        	application.setAttribute("jdbc.password", props.getProperty("jdbc.password"));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스너 문제 생김");
		}
    	
    }
	
}
