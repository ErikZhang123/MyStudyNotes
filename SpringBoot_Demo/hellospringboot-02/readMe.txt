创建springboot项目方法：

一、使用springboot提供的初始化器
    New Module -> Spring Initializer -> default -> 然后按照显示的内容自定义
    在创建的时候，在国内可以在Custom处使用 https://start.springboot.io
    这个是一个创建向导，也可以通过浏览器访问。

二、 创建一个普通的maven项目，然后通过配置pom文件和resource下的文件
注意： resources下的spring配置文件名字必须是 application.properties 或.yml格式

       pom中要配置
        <!--    springboot的父项目-->
        <parent>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-parent</artifactId>
           <version>2.6.3</version>
           <relativePath/> <!-- lookup parent from repository -->
        </parent>

        dependencies中的依赖来自于父项目，所以不用写版本号
        <dependencies>
        因为我们在项目配置的时候已经配置了web包
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
                </dependency>

                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-test</artifactId>
                    <scope>test</scope>
                </dependency>
            </dependencies>

            <build>
                <plugins>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                    </plugin>
                </plugins>
            </build>