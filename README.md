# Spring Boot-Scheduler（定时）

## 1、pom.xml 引入Maven依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter</artifactId>
</dependency>
```

## 2、启动类

- 在启动类上面加上`@EnableScheduling`即可开启定时

```java
@SpringBootApplication
@EnableScheduling
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```

## 3、创建定时任务

- 注意任务类添加**@Component**注解

定时任务1：

```java
@Component
public class SchedulerTask {
    private int count=0;
	//每隔六秒打印一下内容。
    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task running  "+(count++));
    }

}
```

定时任务2：

```java
@Component
public class Scheduler2Task {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    //每隔六秒打印一下内容。
    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

}
```

结果如下：

```java
this is scheduler task running  0
现在时间：09:44:17
this is scheduler task running  1
现在时间：09:44:23
this is scheduler task running  2
现在时间：09:44:29
this is scheduler task running  3
现在时间：09:44:35
```

## 4、参数说明

`@Scheduled` 参数可以接受两种定时的设置，一种是我们常用的`cron="*/6 * * * * ?"`,一种是 `fixedRate = 6000`，两种都表示每隔六秒打印一下内容。

**fixedRate 说明**

- `@Scheduled(fixedRate = 6000)` ：上一次开始执行时间点之后6秒再执行
- `@Scheduled(fixedDelay = 6000)` ：上一次执行完毕时间点之后6秒再执行
- `@Scheduled(initialDelay=1000, fixedRate=6000)` ：第一次延迟1秒后执行，之后按 fixedRate 的规则每6秒执行一次