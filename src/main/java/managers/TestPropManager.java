package managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropManager {
    private final Properties properties = new Properties();
    private static TestPropManager INSTANCE = null;

    private TestPropManager() {
        try {
            properties.load(new FileInputStream("src/main/resources/" +
                    System.getProperty("propFile", "application") + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestPropManager getTestPropManager() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropManager();
        }
        return INSTANCE;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
