package com.tada;

import java.util.Properties;

public class PropertiesUtil {

    public static Properties getProperties(final String fileName){
        final Properties properties = new Properties();

        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName));
        } catch(Exception ex){
            ex.getMessage();
        }
        return properties;
    }

}