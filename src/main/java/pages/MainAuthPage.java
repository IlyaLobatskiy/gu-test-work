package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class MainAuthPage extends BasePage {

    @FindBy(id = "ru.rostel:id/flIvContourLogo")
    private WebElement contourSelection;
    @FindBy(xpath = "//android.view.ViewGroup[contains(@resource-id, 'root')]/android.widget.TextView")
    private WebElement loginButton;
    @FindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id, 'root')]/android.widget.TextView")
    private WebElement registerButton;
    @FindBy(id = "ru.rostel:id/flIvRobotIcon")
    private WebElement robotMaxButton;
    @FindBy(id = "ru.rostel:id/flIvScanQr")
    private WebElement gosScanButton;
    @FindBy(id = "ru.rostel:id/flIvAppLogo")
    private WebElement appLogo;
    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'bottomSheetCheckableDialogItemTvText')]")
    private List<WebElement> listOfContours;
    @FindBy(id = "ru.rostel:id/flTvContourText")
    private WebElement contourText;


    public LoginPage transitionToAuthorization() {
        wait.until(ExpectedConditions.elementToBeClickable(contourSelection));
        if (!getTextElement(contourText).equalsIgnoreCase(prop.getProperty("contour"))) {
            clickElement(contourSelection);
            wait.until(ExpectedConditions.visibilityOfAllElements(listOfContours));
            int num = 0;
            for (WebElement element : listOfContours) {
                if (element.getText().equalsIgnoreCase(prop.getProperty("contour"))) {
                    num = listOfContours.indexOf(element);
                }
            }
            clickElement(listOfContours.get(num));
        }
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        Assert.assertEquals(getTextElement(contourText), prop.getProperty("contour"), "Выбран неверный контур");
        clickElement(loginButton);
        return pageManager.getLoginPage();
    }


}
