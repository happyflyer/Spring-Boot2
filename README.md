# [Spring-Boot2](https://github.com/happyflyer/Spring-Boot2)

- [SpringBoot2 零基础入门](https://www.bilibili.com/video/BV19K4y1L7MT)
- [SpringBoot2 核心技术与响应式编程](https://www.yuque.com/atguigu/springboot)

## 1. 内容概要

### 1.1. SpringBoot2 核心技术

- SpringBoot2 基础入门
  - Spring 能做什么
  - 什么是 SpringBoot
  - 快速体验 SpringBoot
  - 自动配置原理入门
- SpringBoot2 核心功能
  - 配置文件
  - web 开发
    - SpringMVC 自动配置
    - 请求映射与处理
    - 视图解析与内容协商
    - 跨域处理
    - 文件上传
    - 异常处理
    - 拦截器
    - web 原生
    - 定制化
  - 数据访问
    - 访问 MySQL
    - 整合 MyBatis
    - 整合 MyBatis Plus
  - JUnit5 单元测试
    - JUnit5 介绍
    - JUnit5 断言
    - JUnit5 常用注解
  - Actutor 生产指标监控
  - SpringBoot 核心原理解析
- SpringBoot2 场景整合
  - 虚拟化技术
  - 安全控制
  - 缓存技术
  - 消息中间件
  - 分布式入门
  - ...

### 1.2. SpringBoot2 响应式编程

- 响应式编程基础
  - 响应式编程模型
  - 使用 Reactor 开发
- Webflux 开发 web 应用
  - Webflux 构建 RESTful 应用
  - 函数时构建 RESTful 应用
  - RESTTemplate 与 WebClient
- 响应式访问持久化层
  - 响应式访问 MySQL
  - 响应式访问 Redis
- 响应式安全开发
  - Spring Security Reactive 构建安全服务
- 响应式原理
  - 集中 IO 模型
  - Netty-Reactor
  - 数据流处理原理

## 2. SpringBoot2 基础入门

### 2.1. 能做什么

#### 2.1.1. 微服务

- [Microservices Guide](https://martinfowler.com/microservices/)
- 微服务是一种架构风格
- 一个应用拆分为一组小型服务
- 每个服务运行在自己的进程内，也就是可独立部署和升级
- 服务之间使用轻量级 HTTP 交互
- 服务围绕业务功能拆分
- 可以由全自动部署机制独立部署
- 去中心化，服务自治。服务可以使用不同的语言、不同的存储技术

#### 2.1.2. 分布式

- 远程调用
- 服务发现
- 负载均衡
- 服务容错
- 配置管理
- 服务监控
- 链路追踪
- 日志管理
- 任务调度
- ...

#### 2.1.3. 云原生

- 服务自愈
- 弹性伸缩
- 服务隔离
- 自动化部署
- 灰度发布
- 流量治理
- ...

1. 初识云原生
2. 深入 Docker-容器化技术
3. 掌握星际级容器编排 Kubernetes
4. DevOps-实战企业 CI/CD，构建企业云平台
5. 拥抱新一代架构 Service Mesh 与 Serverless
6. 云上架构与场景方案实战

### 2.2. HelloWorld 快速体验

- 创建 Maven 工程
- 引入依赖
- 创建主程序
- 编写业务
- 测试
- 简化配置
- 简化部署

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.3.4.RELEASE</version>
  </parent>
  <groupId>org.example</groupId>
  <artifactId>Spring-Boot2</artifactId>
  <version>0.1.0</version>
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
  </dependencies>
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
</project>
```

```java
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
```

```java
@RESTController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01() {
        return "Hello, Spring Boot 2!";
    }
}
```

### 2.3. 依赖管理

- 父项目做依赖管理

```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>2.3.4.RELEASE</version>
</parent>
```

```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-dependencies</artifactId>
  <version>2.3.4.RELEASE</version>
</parent>
```

- 开发导入 starter 场景启动器依赖

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>z
</dependency>
```

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter</artifactId>
  <version>2.3.4.RELEASE</version>
  <scope>compile</scope>
</dependency>
```

- 无需关注版本号，自动版本仲裁

```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
</dependency>
```

- 可以修改版本号

```xml
<properties>
  <mysql.version>5.1.43</mysql.version>
</properties>
```

### 2.4. 自动配置

- 自动配好 Tomcat

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-tomcat</artifactId>
  <version>2.3.4.RELEASE</version>
  <scope>compile</scope>
</dependency>
```

- 自动配好 SpringMVC

```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-webmvc</artifactId>
  <version>5.2.9.RELEASE</version>
  <scope>compile</scope>
</dependency>
```

- 自动配好 Web 常见功能，如：字符编码问题
  - `dispatcherServlet`
  - `contextLoaderListener`
  - `characterEncodingFilter`
  - `internalResourceViewResolver`
  - ...
- 默认的包结构
  - 主程序所在包及其子包

```java
@SpringBootApplication
public class MainApplication {
}
```

```java
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("package")
public class MainApplication {
}
```

- 各种配置拥有默认值
  - 配置文件的值会绑定到 Java 类的属性
  - 这些 Java 类会在容器中创建对象

```properties
server.port=8888
spring.servlet.multipart.max-file-size=10MB
```

- 按需加载所有自动配置项
  - 引入了哪些 starter，才会自动开启配置
  - 所有的自动配置功能都在 `spring-boot-autoconfigure` 包里面

```java
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(
                MainApplication.class, args);
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```

### 2.5. 自动配置原理

#### 2.5.1. 组件注册

```java
@Bean
@Component
@Controller
@Service
@Repository
```

```java
@ComponentScan
```

#### 2.5.2. 组件依赖

- 自定义配置类

```java
@Configuration
public class MyConfig {
}
```

```java
// Full模式，单例，每次从容器中检查，找组件
// @Configuration(proxyBeanMethods = true)
// Lite模式，多实例，每次调用方法都会生成新对象
@Configuration(proxyBeanMethods = false)
public class MyConfig {
}
```

#### 2.5.3. 全类名导入

```java
@Import({User.class, DBHelper.class})
public class MyConfig {
}
```

#### 2.5.4. 条件装配

```java
@Conditional
```

```java
@ConditionalOnBean
@ConditionalOnMissingBean
@ConditionalOnClass
@ConditionalOnMissingClass
@ConditionalOnWebApplication
@ConditionalOnNotWebApplication
@ConditionalOnResource
@ConditionalOnJava
```

```java
public class MyConfig {
    @ConditionalOnBean(name = "tomcat")
    @Bean
    public User user02() {
        User user = new User("username02", 20);
        user.setPet(pet02());
        return user;
    }
    @Bean("tomcat")
    public Pet pet02() {
        return new Pet("tomcat02");
    }
}
```

```java
@ConditionalOnMissingBean(name = "tomcat")
public class MyConfig {
}
```

#### 2.5.5. 原生配置文件引入

```java
@ImportResource("classpath:beans.xml")
public class MyConfig {
}
```

#### 2.5.6. 配置绑定

```properties
mycar.brand=BYD
mycar.price=100000
```

- 方式一

```java
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;
}
```

- 方式二

```java
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;
}
```

```java
@EnableConfigurationProperties(Car.class)
// 1、开启Car配置绑定功能
// 2、把这个Car这个组件自动注册到容器中
public class MyConfig {
}
```

#### 2.5.7. 引导加载自动配置类

```java
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
}
```

- 代表当前是一个配置类

```java
@Configuration
public @interface SpringBootConfiguration {
}
```

- 扫描哪些 Spring 注解

```java
@Repeatable(ComponentScans.class)
public @interface ComponentScan {
}
```

- 开启自动配置

```java
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {
}
```

- 指定默认的包规则
- 利用 `Registrar` 给容器中批量导入一系列组件
- 将指定的一个包下的所有组件导入进来

```java
@Import({Registrar.class})
public @interface AutoConfigurationPackage {
}
```

#### 2.5.8. 按需开启自动配置项

```java
@Import(AutoConfigurationImportSelector.class)
```

- 利用 `getAutoConfigurationEntry` 给容器中批量导入一些组件

```java
getAutoConfigurationEntry(annotationMetadata);
```

- 调用 `getCandidateConfigurations` 获取到所有需要导入到容器中的配置类

```java
List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);
```

- 利用工厂加载 `loadSpringFactories` 得到所有的组件

```java
Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader);
```

- 从 `META-INF/spring.factories` 位置来加载一个文件
- 默认扫描我们当前系统里面所有 `META-INF/spring.factories` 位置的文件
- `spring-boot-autoconfigure-2.3.4.RELEASE.jar` 包里面也有 `META-INF/spring.factories`
- 虽然我们 127 个场景的所有自动配置启动的时候默认全部加载。`XxxxAutoConfiguration`
- 按照条件装配规则（`@Conditional`），最终会按需配置

#### 2.5.9. 定制化修改自动配置

- `AopAutoConfiguration`

```java
@Configuration(proxyBeanMethods = false)
@ConditionalOnMissingClass({"org.aspectj.weaver.Advice"})
@ConditionalOnProperty(
    prefix = "spring.aop",
    name = {"proxy-target-class"},
    havingValue = "true",
    matchIfMissing = true
)
static class ClassProxyingConfiguration {
}
```

```java
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({Advice.class})
static class AspectJAutoProxyingConfiguration {
}
```

- `DispatcherServletAutoConfiguration`

```java
@Bean(name = {"dispatcherServlet"})
public DispatcherServlet dispatcherServlet(WebMvcProperties webMvcProperties) {
    DispatcherServlet dispatcherServlet = new DispatcherServlet();
    dispatcherServlet.setDispatchOptionsRequest(webMvcProperties.isDispatchOptionsRequest());
    dispatcherServlet.setDispatchTraceRequest(webMvcProperties.isDispatchTraceRequest());
    dispatcherServlet.setThrowExceptionIfNoHandlerFound(webMvcProperties.isThrowExceptionIfNoHandlerFound());
    dispatcherServlet.setPublishEvents(webMvcProperties.isPublishRequestHandledEvents());
    dispatcherServlet.setEnableLoggingRequestDetails(webMvcProperties.isLogRequestDetails());
    return dispatcherServlet;
}
```

```java
@Bean
@ConditionalOnBean(MultipartResolver.class)
@ConditionalOnMissingBean(name = {"multipartResolver"})
public MultipartResolver multipartResolver(MultipartResolver resolver) {
    // 给容器中加入了文件上传解析器
    // 给@Bean标注的方法传入了对象参数，这个参数的值就会从容器中找
    // SpringMVC multipartResolver。防止有些用户配置的文件上传解析器不符合规范
    return resolver;
}
```

- `HttpEncodingAutoConfiguration`

```java
@Bean
@ConditionalOnMissingBean
public CharacterEncodingFilter characterEncodingFilter() {
}
```

- SpringBoot 默认会在底层配好所有的组件
- 但是，如果用户自己配置了，以用户的优先

#### 2.5.10. 总结

- SpringBoot 先加载所有的自动配置类，`XxxxAutoConfiguration`
- 每个自动配置类按照条件进行生效，默认都会绑定配置文件指定的值
  - xxxxProperties 里面拿
  - xxxxProperties 和配置文件进行了绑定
- 生效的配置类就会给容器中装配很多组件
- 只要容器中有这些组件，相当于这些功能就有了
- 定制化配置
  - 用户直接自己 `@Bean` 替换底层的组件
  - 用户去看这个组件是获取的配置文件什么值就去修改

`XxxxAutoConfiguration` ---> 组件 ---> xxxxProperties 里面拿值 ---> `application.properties`

### 2.6. 最佳实践

- 引入场景依赖
  - 参考 [场景启动器](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/html/using-spring-boot.html#using-boot-starter)
- 查看自动配置了哪些（选做）
  - 自己分析，引入场景对应的自动配置一般都生效了
  - 配置文件中 `debug=true` 开启自动配置报告
    - Positive matches:
    - Negative matches:
    - Exclusions:
    - Unconditional classes:
- 是否需要定制化
  - 参考 [可配置项](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/html/appendix-application-properties.html#common-application-properties)，按照需要定制化
  - 自定义加入或者替换组件
    - `@Bean`、`@Component`
    - 自定义器 `XXXXCustomizer`

### 2.7. Lombok

```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
</dependency>
```

- idea 中搜索安装 lombok 插件

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;
}
```

```java
@Slf4j
@RESTController
public class CarController {
    @Resource
    private Car car;
    @RequestMapping("/car")
    public Car handle01() {
        log.info("请求进来了...");
        return car;
    }
}
```

### 2.8. dev-tools

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <optional>true</optional>
</dependency>
```

- 项目或者页面修改以后：`Ctrl+F9` 重新编译，自动重启更新
- 热更新，使用 JRebel，付费

### 2.9. Spring Initailizr

## 3. SpringBoot2 核心功能

### 3.1. 配置文件

#### 3.1.1. 基本语法

- key: value；kv 之间有空格
- 大小写敏感
- 使用缩进表示层级关系
- 缩进不允许使用 tab，只允许空格
- 缩进的空格数不重要，只要相同层级的元素左对齐即可
- `'#'` 表示注释
- 字符串无需加引号，如果要加，`''` 与 `""` 表示字符串内容 会被 转义/不转义

```yaml
k: v
```

```yaml
k: { k1:v1, k2:v2, k3:v3 }
```

```yaml
k:
  k1: v1
  k2: v2
  k3: v3
```

```yaml
k: [v1, v2, v3]
```

```yaml
k:
  - v1
  - v2
  - v3
```

#### 3.1.2. 配置提示

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
  <optional>true</optional>
</dependency>
```

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <configuration>
        <excludes>
          <exclude>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
          </exclude>
        </excludes>
      </configuration>
    </plugin>
  </plugins>
</build>
```
