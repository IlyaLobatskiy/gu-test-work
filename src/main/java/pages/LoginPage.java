package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'login')]")
    private WebElement loginField;
    @FindBy(xpath = "//android.widget.EditText[contains(@resource-id, 'password')]")
    private WebElement passwordField;
    @FindBy(xpath = "//android.widget.Button[contains(@text, 'Войти')]")
    private WebElement loginButton;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Авторизация\"]/android.widget.TextView")
    private WebElement title;


    @SneakyThrows
    public PinCodePage authorizationValidTestUser() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        Assert.assertEquals(title.getText(), "Авторизация", "Не открыт экран авторизации");

        fillingInInputField(loginField, prop.getProperty("phone"));
        Thread.sleep(1000);
        Assert.assertFalse(loginButton.getText().isEmpty(), "Логин не введен");

        fillingInInputField(passwordField, prop.getProperty("pass"));
        Thread.sleep(1000);
        Assert.assertFalse(passwordField.getText().isEmpty(), "Пароль не введен");

        clickElement(loginButton);

        return pageManager.getPinCodePage();
    }
}
