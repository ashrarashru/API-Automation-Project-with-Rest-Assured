package Utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Utils {

    public static void setEnvVar(String key, String value) throws ConfigurationException {
        String path = "./src/test/resources/config.properties";

        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration(path);
        propertiesConfiguration.setProperty(key, value);
        propertiesConfiguration.save();
    }
}
