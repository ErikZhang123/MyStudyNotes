package comm.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ServletContextAttribute implements ServletContextListener {
    String url="jdbc:mysql://localhost:3306/STUDENTUSERINFO";
    String username="root";
    String upassword="zhang123";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        Connection c = null;
        Map<Connection,Boolean> connections = new HashMap<>();

        try {
            for (int i = 0; i < 10; i++) {
                c = DriverManager.getConnection(url, username, upassword);
                connections.put(c,true);
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        sc.setAttribute("connections",connections);
        System.out.println("Connections已创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
