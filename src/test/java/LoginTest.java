import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void autorization() {
        pageManager.getMainAuthPage()
                .transitionToAuthorization()
                .authorizationValidTestUser()
                .createNewCode(1, 9, 1, 7)
                .passTwoFa()
                .closePermissionPage()
                .validUserName();
    }

}
