package com.otus.java.advanced.bytebuddy;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ByteBuddyExampleApplication {
    public static void main(String[] args) {
//        SpringApplication.run(ByteBuddyExampleApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ByteBuddyExampleApplication.class);
        ExampleService bean = (ExampleService) context.getBean("exampleService");
        System.out.println(bean.doSomething("был вызван метод с аннотацией @OurLog"));

        try {
            bean.doSomethingWithError("метод с ошибкой");
        } catch (RuntimeException e) {
            System.out.println("был вызван метод с аннотацией @OurLog(isShowError = true)");
        }
    }
}