package org.leon.designPattern.Factory;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class PhoneFactoryTest {
    static Logger logger = LogManager.getLogger(PhoneFactoryTest.class);


    @Test
    public void factoryPractice(){
        PhoneFactory fac = new PhoneFactory();
        PhoneInterface phone = fac.GerneratePhone("MiPhone");
        phone.displayText("hello MOTO");

        PhoneInterface phone2 = fac.GerneratePhoneMannul("MiPhone");
        phone2.displayText("well done");
        logger.info("print log");

        System.out.println("properties: " + fac.properties.getProperty("app.title") + fac.properties.getProperty("app.desc"));
    }

    @Test
    public void reflectionPractice(){
        try {
            Class cls = Class.forName("org.leon.designPattern.Factory.Iphone");
            System.out.println("name: " + cls.getName());


            System.out.println(String.join("-", Stream.of(cls.getDeclaredMethods()).map(
                    f-> {return f.getName();}
            ).toList()));

            Class cls2 = Iphone.class;
            System.out.println("class equals: " + (cls == cls2));

            PhoneInterface phone = (PhoneInterface) cls2.getDeclaredConstructor(String.class).newInstance("Iphone");
            phone.displayText("use reflection created");

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void singletonPractice(){
        Singleton s = Singleton.getInstance();
        s.saySometing("hello world");
    }

}