package Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HttpServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map listenerMap = new HashMap();
        for(int i=0;i<20;i++){
            try {
                Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/STUDENTUSERINFO?serverTimezone=UTC",
                            "root",
                        "zhang123");
                System.out.println("Conn"+conn+"已创建");
                listenerMap.put(conn,true);//true 代表当前conn空闲，false代表当前conn被占用
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        ServletContext sc=sce.getServletContext();
        sc.setAttribute("connections",listenerMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext=sce.getServletContext();
        Map map = (Map)servletContext.getAttribute("connections");
        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            if(iterator.next()!=null){
                System.out.println("Conn"+iterator.next()+"已被销毁");
            }
        }
    }
}
