package managers;

import io.appium.java_client.AppiumDriver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import utils.PropConst;

import java.net.MalformedURLException;
import java.net.URL;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverManager {
    private AppiumDriver driver;
    private static DriverManager INSTANCE = null;
    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();
    private final CapabilitesManager capabilitesManager = CapabilitesManager.getDeviceManager();

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    private URL getUrl() {
        try {
            return new URL(testPropManager
                    .getProperty(PropConst.BASE_URL));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new AppiumDriver(getUrl(), capabilitesManager.getCapabilites());
            //Неявное ожидание
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
