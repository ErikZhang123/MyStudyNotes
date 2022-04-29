一、Springboot中对容器的使用
printApplication.run()的返回结果是ConfigurableApplicationContext，这个类继承了ApplicationContext。
所以实际上run的返回值就是一个容器对象，同样可以通过getBean的方法从中获取对象
ApplicationContext applicationContext = SpringApplication.run(SpringbootApplicationcontext07Application.class, args);
applicationContext.getBean("");

二、CommandLineRunner接口
    CommandLineRunner与ApplicationRunner接口中都存在run方法，执行时机：容器启动之后

    区别： run方法的参数不同
    CommandLineRunner: run(String ...args)
    ApplicationRunner: run(ApplicationContext args)
