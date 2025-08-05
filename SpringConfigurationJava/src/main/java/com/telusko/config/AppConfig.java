package com.telusko.config;

import com.telusko.Alien;
import com.telusko.Computer;
import com.telusko.Desktop;
import com.telusko.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.telusko")
public class AppConfig {
//    @Bean
//    public Alien alien(@Qualifier("lap1") @Autowired Computer com){
//        Alien obj= new Alien();
//        obj.setAge(25);
//        //obj.setCom(desktop());
//        obj.setCom(com);
//        return obj;
//    }
//    @Bean(name={"com2", "Beast", "desktop1"})//name of bean is method name by default
//    //@Scope("prototype") //by default scope will be singleton and object will be created once
//    @Primary
//    public Desktop desktop(){
//        return new Desktop();
//    }
//    @Bean(name={"lap1"})//name of bean is method name by default
//    //@Scope("prototype") //by default scope will be singleton and object will be created once
//
//    public Laptop laptop(){
//        return new Laptop();
//    }


}
