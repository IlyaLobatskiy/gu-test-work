package managers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pages.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageManager {
    private static PageManager INSTANCE;
    private LoginPage loginPage;
    private MainAuthPage mainAuthPage;
    private PinCodePage pinCodePage;
    private MainPage mainPage;
    private TwoFaLanding twoFaLanding;
    private PermissionGeoPage permissionGeoPage;

    public static PageManager getPageManager() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public MainAuthPage getMainAuthPage() {
        if (mainAuthPage == null) {
            mainAuthPage = new MainAuthPage();
        }
        return mainAuthPage;
    }

    public PinCodePage getPinCodePage() {
        if (pinCodePage == null) {
            pinCodePage = new PinCodePage();
        }
        return pinCodePage;
    }

    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public TwoFaLanding getTwoFaLanding() {
        if (twoFaLanding == null) {
            twoFaLanding = new TwoFaLanding();
        }
        return twoFaLanding;
    }

    public PermissionGeoPage getPermissionGeoPage() {
        if (permissionGeoPage == null) {
            permissionGeoPage = new PermissionGeoPage();
        }
        return permissionGeoPage;
    }
}
