package Setup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Setup {
    public Properties prop;
    public FileInputStream fs;

    @BeforeTest
    public void getEnvVar() throws IOException {
        String path = "./src/test/resources/config.properties";
        prop = new Properties();
        fs = new FileInputStream(path);
        prop.load(fs);
    }

    @BeforeMethod
    public void refresh() throws IOException {
        String path = "./src/test/resources/config.properties";
        prop = new Properties();
        fs = new FileInputStream(path);
        prop.load(fs);
    }
}
