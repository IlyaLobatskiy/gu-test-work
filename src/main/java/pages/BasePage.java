package pages;

import managers.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import managers.PageManager;
import managers.TestPropManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected final DriverManager driver = DriverManager.getDriverManager();
    protected final PageManager pageManager = PageManager.getPageManager();
    protected final TestPropManager prop = TestPropManager.getTestPropManager();
    protected WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(60));

    public BasePage() {

        PageFactory.initElements(new AppiumFieldDecorator(driver.getDriver(), Duration.ofSeconds(5)), this);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public String getTextElement(WebElement element) {
        return element.getText();
    }

    public void fillingInInputField(WebElement element, String content) {
        element.sendKeys(content);
    }

    public boolean isDisplayedElement(WebElement element) {
        return element.isDisplayed();
    }
}
