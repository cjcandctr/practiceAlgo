package org.leon.designPattern.Factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class PhoneFactory {
    Properties properties;
    public PhoneFactory() {
        properties = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public PhoneInterface GerneratePhone(String type){
        String fullname = "org.leon.designPattern.Factory." + type;
        try {
            Class cls = Class.forName(fullname);
            Object obj = cls.getDeclaredConstructor(String.class).newInstance(type);
            return (PhoneInterface) obj;
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PhoneInterface GerneratePhoneMannul(String type){
        switch(type){
            case "Iphone":
                return new Iphone("Iphone7");
            case "MiPhone":
                return new MiPhone("Xiaomi5");
            case "PixalPhone":
                return new PixalPhone("Pixal2");
            default:
                return null;
        }
    }
}
