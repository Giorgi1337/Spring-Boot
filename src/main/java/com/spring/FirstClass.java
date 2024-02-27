package com.spring;


public class FirstClass {

    private String myVar;

    public FirstClass(String myVar) {
        this.myVar = myVar;
    }
    public String sayHello() {
        return "Hello there my var = " + myVar;
    }
}
