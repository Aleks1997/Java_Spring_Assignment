package com.example.JavaSpringComtrade360.controller;

import com.example.JavaSpringComtrade360.model.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.JavaSpringComtrade360.service.HelloWorldService;

import java.util.List;
import java.util.Random;


@RestController
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    HelloWorldService helloWorldService = new HelloWorldService();

    @GetMapping("/hello-rest")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/hello")
    public ModelAndView helloHtml(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello.html");
        return modelAndView;
    }

    @GetMapping("/db/hello")
    public String helloWorldByLang(@RequestParam(name="lang") String lang){
        List<HelloWorld> helloWorldList = helloWorldService.getHelloWorldByLang(lang);
        return helloWorldList.get(0).getWord();
    }

    @GetMapping("/secure/hello")
    public ModelAndView secureHelloHtml(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin.html");
        return modelAndView;
    }

    @PostMapping("/secure/submit")
    public ModelAndView secureSubmitToH2(@RequestParam("word") String word, @RequestParam("lang") String lang){
        System.out.println("Word :" + word);
        System.out.println("Lang: " + lang);

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setWord(word);
        helloWorld.setLang(lang);
        helloWorld.set_id(new Random().nextInt());

        helloWorldService.saveOrUpdate(helloWorld);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello.html");
        return modelAndView;
    }


}
