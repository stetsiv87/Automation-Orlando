package demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.sql.DataSource;
import java.io.IOException;

public abstract class BaseTest implements NavigationHelper, SQLHelper {

     static WebDriver driver;

    public static String url = "https://numero.visiquate.com";
//    private static String tenant = ConfigDB.getTenant();
//    private static String username = ConfigDB.getUserName();
//    private static String password = ConfigDB.getTenantPassword();

    public void initBrowser() throws IOException {
        if (driver == null) {
            driver = new FirefoxDriver();
            ConfigDB.getPropsFromFile();
            login(url, ConfigDB.getTenant(), ConfigDB.getUserName(), ConfigDB.getTenantPassword());

        }
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
      //  driver = null;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public abstract DataSource getDatasource() throws IOException;
}
