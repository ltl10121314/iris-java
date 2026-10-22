package com.leibangzhu.iris.demoa.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class AppProvider {

//    @Autowired
//    private IHelloService helloService;

    @RequestMapping("/")
    String home(){
        return "Hello world!";
    }

//    @RequestMapping("/hello")
//    String hello(){
//        return helloService.sayHello("leo");
//    }
//
//    @RequestMapping("/hello2")
//    String hello2(){
//        return helloService.sayHello2("leo");
//    }

    public static void main(String[] args){
        SpringApplication.run(AppProvider.class,args);
    }
}
