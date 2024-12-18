package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.PropConst;


public class MainPage extends BasePage {
    @FindBy(id = "ru.rostel:id/fmTvProfileName")
    private WebElement nameUser;
    @FindBy(id = "ru.rostel:id/itlIvClose")
    private WebElement closeBuble;
    @FindBy(id = "android:id/button2")
    private WebElement closeAlert;
    @FindBy(id = "ru.rostel:id/parentPanel")
    private WebElement parentPanel;


    public MainPage validUserName() {
        wait.until(ExpectedConditions.elementToBeClickable(closeBuble));
        clickElement(closeBuble);
        if (Integer.parseInt(prop.getProperty(PropConst.PLATFORM_VERSION)) > 11) {
            wait.until(ExpectedConditions.elementToBeClickable(closeAlert));
            clickElement(closeAlert);
        }
        wait.until(ExpectedConditions.elementToBeClickable(nameUser));
        Assert.assertEquals(nameUser.getText(), "Фарит");
        return this;
    }
}
