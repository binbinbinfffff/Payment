package com.cn.teamhelper.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

/**
 * 加载自定义properties配置文件工具类
 */
public class PropertiesUtil {
    private static Properties properties;
    private static HashMap<String,String> propertiesMap;
    public static Properties loadProperties(String filePath)throws Exception{

        try {
            if (properties == null){
            properties = new Properties();
            }
            System.out.println(Thread.currentThread().getContextClassLoader().getResource(filePath));
            properties.load
                    (Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath));
        }catch (IOException e){





            throw e;
        }
        return properties;
    }



    public static String getPropertiesValueByKey(String key)throws Exception{
        if (propertiesMap == null){
            propertiesMap = new HashMap<String, String>();
            Set<Object> keysSet = properties.keySet();
            for (Object oneKey:keysSet){
                String value = properties.getProperty(oneKey.toString());
                propertiesMap.put(oneKey.toString(),value);
            }
        }
        return propertiesMap.get(key);
    }


}
