package demo1;

import demo.ConfigDB;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.rmi.AccessException;
import java.sql.SQLException;


public  class BaseTest extends ZeroTest {

    static WebDriver driver;
    public static String url = "https://stg-login.visiquate.com/numero";


    @BeforeClass
    public static void beforeClass() throws SQLException, IOException {
        driver = new FirefoxDriver();
        ConfigDB.getPropsFromFile();
        login(url, ConfigDB.getTenant(), ConfigDB.getUserName(), ConfigDB.getTenantPassword());
        SQL.getDatasource();
        OpenArTest();

    }

    @Test
    public void testOpenAR_Report() throws SQLException, IOException {
        Assert.assertEquals("FAILED", pc.getTitle(), driver.getTitle());
        }

    @Test
    public void testCheckTotals () throws IOException, SQLException {

        final int[] a = new int[1];

        SQL.queryDB(sc.getTestQuery(), (rs, rowNumber) -> {
            a[0] = rs.getInt("counts");
            });

        Assert.assertEquals("FAILED",a[0],Integer.parseInt(readValue(pc.getValue()).replace(",","")));

        }
//        System.out.println(a[0]);
//        System.out.println(readValue(pc.getValue()).replace(",",""));







    @AfterClass
    public static void afterClass() {
        driver.quit();

    }


}
