package pomutilities1;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

    public static String getProperty(String key) {

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "./src/test/resources/DDT/saucedemo.properties");

            Properties prop = new Properties();

            prop.load(fis);

            fis.close();

            return prop.getProperty(key);

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}