package com.telusko;


import com.telusko.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
//        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
//        Alien obj1 =  context.getBean("alien1", Alien.class);
//        obj1.setAge(21);
//        System.out.println( obj1.getAge() );
//        obj1.code();
//        Computer obj = context.getBean( Computer.class);
//        Desktop obj2 =  context.getBean( Desktop.class);

        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        //Desktop dt= context.getBean("desktop1",Desktop.class);
//        Desktop dt= context.getBean(Desktop.class);
//        dt.compile();
//        Desktop dt1= context.getBean(Desktop.class);
//        dt1.compile();

        Alien obj1= context.getBean(Alien.class);
        //obj1.setAge(21);
        System.out.println( obj1.getAge());
        obj1.code();
        Desktop dt1= context.getBean(Desktop.class);
    }
}
