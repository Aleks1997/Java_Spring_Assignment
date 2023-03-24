package com.example.JavaSpringComtrade360.repository;

import com.example.JavaSpringComtrade360.model.HelloWorld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelloWorldRepository extends JpaRepository<HelloWorld, Integer> {
    List<HelloWorld> findByLang(String lang);
}
