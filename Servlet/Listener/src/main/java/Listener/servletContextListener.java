package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class servletContextListener implements ServletContextListener {
    @Override
    //监听ServletContext初始化的时候执行
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext has been initialized");
    }
    //监听ServletContext销毁的时候执行
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext has been destroyed");
    }
}
