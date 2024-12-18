package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class PinCodePage extends BasePage {
    @FindBy(id = "ru.rostel:id/fpTvGreetings")
    private WebElement nameUser;
    @FindBy(xpath = "//android.widget.Button")
    private List<WebElement> numbersPin;
    @FindBy(id = "ru.rostel:id/fpTvPinTitle")
    private WebElement textPassword;

    private void clickNum(int num) {
        int n = 0;
        for (WebElement element : numbersPin) {
            if (element.getText().equals(String.valueOf(num))) {
                n = numbersPin.indexOf(element);
            }
        }
        clickElement(numbersPin.get(n));
    }

    @SneakyThrows
    public TwoFaLanding createNewCode(int one, int two, int three, int four) {

        wait.until(ExpectedConditions.visibilityOf(textPassword));
        Assert.assertEquals(textPassword.getText(), "Придумайте код доступа");
        Thread.sleep(1000);
        clickNum(one);
        Thread.sleep(1000);
        clickNum(two);
        Thread.sleep(1000);
        clickNum(three);
        Thread.sleep(1000);
        clickNum(four);

        Thread.sleep(1000);
        Assert.assertEquals(textPassword.getText(), "Повторите код");
        clickNum(one);
        Thread.sleep(1000);
        clickNum(two);
        Thread.sleep(1000);
        clickNum(three);
        Thread.sleep(1000);
        clickNum(four);

        return pageManager.getTwoFaLanding();
    }
}
