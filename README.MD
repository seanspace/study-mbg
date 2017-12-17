### Mybatis generator 使用示例

Mybatis generator代码
````
https://github.com/mybatis/generator
````
配置步骤
````
 首先需要引入数据库驱动，以及mbg包
    <dependency>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-core</artifactId>
        <version>1.3.0</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.34</version>
    </dependency>

1. 配置：mbg/generatorConfig.properties
2. 配置：mbg/generatorConfig.xml 配置需要生成的表对应的:table
3. 运行代码，生成对应的文件：com.github.seanspace.excutor.MBG.main

````