package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PermissionGeoPage extends BasePage {
    @FindBy(id = "ru.rostel:id/vpbIvClose")
    private WebElement backButton;
    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'Title')]")
    private WebElement title;

    public MainPage closePermissionPage() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton));
        Assert.assertEquals(getTextElement(title), "Разрешите приложению доступ к местоположению");
        clickElement(backButton);
        return pageManager.getMainPage();
    }
}
