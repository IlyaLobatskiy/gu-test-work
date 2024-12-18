import managers.DriverManager;
import org.testng.annotations.AfterTest;
import managers.PageManager;


public class BaseTest {
    protected final PageManager pageManager = PageManager.getPageManager();
    private final DriverManager driverManager = DriverManager.getDriverManager();

    @AfterTest
    public void closeSession() {
        driverManager.quitDriver();
    }
}
