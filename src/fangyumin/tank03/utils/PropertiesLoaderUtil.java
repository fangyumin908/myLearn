package fangyumin.tank03.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoaderUtil {

    private PropertiesLoaderUtil(){}
    static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertiesLoaderUtil.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return (String)properties.getProperty(key);
    }

    public static void main(String[] args) throws IOException {

//        System.out.println(PropertiesLoaderUtil.getValue("enemiesInitializationCount"));
    }
}
