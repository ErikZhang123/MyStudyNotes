主要步骤
1。创建web项目
对web.xml文件进行修改，在Project structure中重新创建一个版本为4.0的web
2。在 web.xml文件中声明springmvc中央调度器对象，并且指定springmvc的配置文件
3。创建springmvc配置文件，其实就是spring配置文件，使用扫描器扫描base-package下的注解以创建对象
并将对象放在mvc容器中
3。 指定springmvc的mapping，即指定哪个中央调度器处理哪些请求
4。 创建controller对象，使用@RequestMapper(?) 注解，指定某方法处理哪个请求，？是请求的url
6。 controller中的方法需要返回 ModelAndViel 类的对象，这个对象在方法中被创建。
    可以使用其 setViewName指定需要转发的视图的位置。
    可以使用其 addObject("key" , Object) 向request作用域里添加数据
7。最后方法return mv对象，框架会自动处理 执行转发和添加

