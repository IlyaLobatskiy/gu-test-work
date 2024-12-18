package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TwoFaLanding extends BasePage {
    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'Title')]")
    private WebElement title;
    @FindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, 'root')]/android.widget.TextView")
    private WebElement passButton;

    public PermissionGeoPage passTwoFa() {
        wait.until(ExpectedConditions.elementToBeClickable(passButton));
        Assert.assertEquals(title.getText(), "Подтверждение входа стало обязательным");
        clickElement(passButton);
        return pageManager.getPermissionGeoPage();
    }
}
