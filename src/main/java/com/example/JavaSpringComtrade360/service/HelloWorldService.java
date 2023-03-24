package com.example.JavaSpringComtrade360.service;

import com.example.JavaSpringComtrade360.model.HelloWorld;
import com.example.JavaSpringComtrade360.repository.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloWorldService {
    @Autowired
    HelloWorldRepository helloWorldRepository;

    public List<HelloWorld> getAllHelloWorlds(){
        return helloWorldRepository.findAll();
    }
    public void saveOrUpdate(HelloWorld helloWorld){
        helloWorldRepository.save(helloWorld);
    }
    public List<HelloWorld> getHelloWorldByLang(String l){
        return helloWorldRepository.findByLang(l);
    }
}