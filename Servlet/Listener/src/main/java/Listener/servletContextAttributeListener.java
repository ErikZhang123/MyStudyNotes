package Listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class servletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("全剧作用域发生添加");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("全剧作用域发生删除");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("全剧作用域发生修改");
    }
}
