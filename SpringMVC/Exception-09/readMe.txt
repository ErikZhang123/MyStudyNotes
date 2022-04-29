对异常的集中处理：
在框架中只保留业务逻辑，而可能抛出的所有异常都在一个集中的地方进行处理
这其实就是利用的AOP的思想，把业务逻辑和异常处理代码分开，解耦合

主要有两个注解：
@ExceptionHandler
@ControllerAdvice

异常处理步骤：

1.新建自定义异常类
2.在Controller中抛出我们自定义的异常类
3.创建一个普通类作为全局异常处理累
    1。在类上加入@ControllerAdvice
    2。在类的方法定义上面加上@ExceptionHandler
4. 在Controller中抛出我们自定义的异常类
5. 创建处理异常的视图页面
6.创建springmvc配置文件
    组件扫描器1 ： 扫描controller
    组件扫描器2：扫描@ControllerAdvice所在的包名
    3申明注解驱动