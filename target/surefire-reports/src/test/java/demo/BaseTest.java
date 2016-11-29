package demo;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.sql.DataSource;
import java.io.IOException;

import static demo.ConfigDB.getPropsFromFile;
import static demo.ConfigDB.getTenant;

public abstract class BaseTest implements ScriptsConfig,ProjectConfig {



    public static String url = "https://stg-login.visiquate.com/numero";


    public void initBrowser() throws IOException {

            ConfigDB.getPropsFromFile();
          //  login(url, ConfigDB.getTenant(), ConfigDB.getUserName(), ConfigDB.getTenantPassword());



        }


    @AfterClass
    public static void afterClass() {

        //driver = null;
    }



    public abstract DataSource getDatasource() throws IOException;
}
