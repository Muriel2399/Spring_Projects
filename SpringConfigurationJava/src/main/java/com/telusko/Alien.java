package com.telusko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Value("21")
   private  int age;
  // private int salary;
    @Autowired
    @Qualifier("lap") //class name with small letter
   private Computer com;
    public Alien(){
        System.out.println( "Alien Object Created.." );
    }
//    public Alien(int age, Computer com){
//        System.out.println( "Para Constructor Called" );
//        this.age=age;
//        this.lap=lap;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
       // System.out.println( "setter called" );
        this.age = age;
    }

    public void code(){
        System.out.println( "Coding" );
        com.compile();
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }
}
