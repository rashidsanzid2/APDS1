package utility;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;

public class Property {
    private static Logger getLogger() {
        return LogManager.getLogger(Property.class);
    }

    public static String getProperty(String propsPath, String key) {
        PropertiesConfiguration props = getProperties(propsPath);
        String keyVal = null;

        if (props != null) {
            keyVal = props.getString(key);
        }

        return keyVal;
    }

    public static PropertiesConfiguration getProperties(String propsPath) {
        PropertiesConfiguration props = new PropertiesConfiguration();
        try {
            File propsFile = new File(propsPath);
            if (propsFile.exists()) {
                FileInputStream inputStream = new FileInputStream(propsFile);
                props.load(inputStream);
                inputStream.close();
                return props;
            }
        } catch (Exception e) {
            getLogger().debug(e.getMessage());
            return null;
        }

        return null;
    }
}
