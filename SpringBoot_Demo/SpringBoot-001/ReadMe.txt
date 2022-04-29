相关注解：


SpringBoot特性：
SpringBoot的核心还是IOC容器
1。创建spring应用
2 内嵌了tomcat，Jetty，undertow
3。提供starter依赖，简化搭建配置
    starter依赖中已经帮我们将一些常用的对象已经配置好了
     比如Mybatis中的SqlSessionFactory，Dao代理对象
     我们只需要在springboot的pom文件中加入mybatis-spring-boot-starter依赖即可
4。springboot尽量自动的配置spring和第三方库，减少人工配置的压力。
    将第三方库中的对象都配置好，放到容器中
5。提供 metrics, health checks and externalized configuration 功能
        度量 , 健康检查（工作状态是否正常） ， 外部化配置（就是项目代码之外的配置，比如propoties文件）
6。 无需xml配置，不用生成代码
