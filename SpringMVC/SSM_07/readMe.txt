SSM整合开发
SpringMVC + Spring+ Mybatis 对应三层
界面层       业务层   永久层DAO
界面层调用service处理请求，service调用DAO访问数据库
流程： 用户发起请求-》 springMVC接收请求和参数-》调用spring中生成的service对象-》
service对象使用mybatis调用数据库

SSM整合中有容器： springmvc容器，管理Controller对象； spring容器，管理service，dao
集那个要使用的对象交给合适的容器创建，管理。
因此，把Controller对象写在springmvc配置文件中
        Service和Dao对象写在spring配置文件中
重点： springmvc的对象如何访问spring的对象？
    他们之间存在已经确定的关系： springmvc是spring的子容器，类似于继承关系，子可以访问父类内容
    因此可以实现Controller使用service对象。


本次实验： 通过网页对后端数据库的CRUD

实现步骤：
0.  数据库中使用student库中的info表
1。 新建maven web项目
2。加入依赖 ： springmvc，spring，mybatis，jackson，mysql，druid链接池
            jsp，servlet

3.  写web.xml
    1）注册DispatcherServlet。 目的： 1、创建springmvc容器对象； 2、 作为Servlet接收请求
    2）注册spring监听器ContextLoaderListener。
        目的： 在Tomcat启动的时候创建spring的容器对象，才能创建service，dao对象
    3) 注册字符集过滤器 ： 解决post乱码问题
4。 创建包，
5。写springmvc,spring,mybatis配置文件
6。写dao接口和mapper文件，service和实现类
7。写jsp