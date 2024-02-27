package com.spring.service;

import com.spring.FirstClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {
    private FirstClass firstClass;
    private Environment environment;

//    public MyFirstService(@Qualifier("bean1") FirstClass firstClass) {
//        this.firstClass = firstClass;
//    }

    @Autowired
    public void injectDependency (FirstClass firstClass) {
        this.firstClass = firstClass;
    }

    public String tellAStory() {
        return "The dependency is saying " + firstClass.sayHello();
    }

    public String getJavaVersion() {
       return environment.getProperty("java.version");
    }

    public String getOsName() {
        return environment.getProperty("os.name");
    }

    public String readProp() {
        return environment.getProperty("my.custom.property");
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
