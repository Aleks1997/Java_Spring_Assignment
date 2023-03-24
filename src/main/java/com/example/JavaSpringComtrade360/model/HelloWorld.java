package com.example.JavaSpringComtrade360.model;

import jakarta.persistence.*;

import java.util.Random;

@Entity
//@Table(name="helloworld") //h2
public class HelloWorld {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String lang;
    @Column
    private String word;

    public HelloWorld(){

    }

    public HelloWorld(String l,String w){
        this.lang = l;
        this.word = w;
        this.id = new Random().nextInt();
    }

    public int get_id() {
        return id;
    }

    public void set_id(int _id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
