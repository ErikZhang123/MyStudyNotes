在springboot中并不推荐使用jsp，而是推荐使用模版替代jsp作为模版

使用jsp：需要进行配置
1。加入处理jsp的依赖，负责编译jsp,因为springboot使用的是内嵌的tomcat而不是本机的tomcat
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>

2. 如果需要servlet的jsp功能，还要加入别的对应依赖
<dependency>
    <groupId> javax.servlet </groupId>
    <artifactId>jstl</artifactId>
</dependency>
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>javax.servlet.jsp-api</artifactId>
    <version>2.3.1</version>
</dependency>
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
</dependency>

3. 创建存放jsp的目录，一般叫webapp。在main目录下，创建好以后使用project structure -> web resource directory
-> + 加入webapp作为web应用的目录

4。 在pom.xml中指定jsp文件的编译目录META-INF/resources.
    在build标签中配置
    <resources>
        <resource>
<!--                JSP目录-->
            <directory>src/main/webapp</directory>
<!--                编译后的存放目录-->
            <targetPath>META-INF/resources</targetPath>
<!--                指定处理的目录和文件,将所有目录都编译到上面的文件中-->
            <includes>
                <include>**/*.*</include>
            </includes>
        </resource>
    </resources>
5. 创建Controller
6。在application.properties 配置视图解析器
    #配置视图解析器
    #配置前缀
    spring.mvc.view.prefix=/
    #配置后缀
    spring.mvc.view.suffix=.jsp