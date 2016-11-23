package demo;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.sql.DataSource;
import java.io.IOException;

public abstract class BaseTest implements NavigationHelper, SQLHelper {

    static WebDriver driver;

    public static String url = "https://numero.visiquate.com";
    private static String tenant = "";
    private static String username = "";
    private static String password = "";

    public void initBrowser() {
        if (driver == null) {
            driver = new FirefoxDriver();
            login(url, tenant, username, password);

        }
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
        //driver = null;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public abstract DataSource getDatasource() throws IOException;
}
