package managers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropConst;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CapabilitesManager {
    private static CapabilitesManager INSTANCE;
    private final TestPropManager testPropManager = TestPropManager.getTestPropManager();


    public static CapabilitesManager getDeviceManager() {
        if (INSTANCE == null) {
            INSTANCE = new CapabilitesManager();
        }
        return INSTANCE;
    }

    public DesiredCapabilities getCapabilites() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", testPropManager.getProperty(PropConst.PLATFORM_NAME));
        capabilities.setCapability("appium:deviceName", testPropManager.getProperty(PropConst.DEVICE_NAME));
        capabilities.setCapability("appium:automationName", testPropManager.getProperty(PropConst.AUTOMATION_NAME));
        capabilities.setCapability("appium:platformVersion", testPropManager.getProperty(PropConst.PLATFORM_VERSION));
        capabilities.setCapability("appium:appPackage", testPropManager.getProperty(PropConst.APP_PACKAGE));
        capabilities.setCapability("appium:appActivity", testPropManager.getProperty(PropConst.APP_ACTIVITY));
        capabilities.setCapability("appium:app", testPropManager.getProperty(PropConst.APP));
        capabilities.setCapability("appium:fullReset", Boolean.parseBoolean(testPropManager.getProperty(PropConst.FULL_RESET)));
        return capabilities;
    }
}
