package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    private static PropertyUtils instance = null;
    private static final Properties properties = new Properties();


    private PropertyUtils(){

    }

    public static PropertyUtils getInstance(){
        if(instance ==null){
            instance = new PropertyUtils();
        }
        return instance;
    }


    public String getDataFromUserProperty(String prop) throws IOException {
        FileInputStream fis = new FileInputStream(ConstantsUtils.USER_PROPERTIES);
        properties.load(fis);
        return properties.get(prop).toString();

    }

    


}
