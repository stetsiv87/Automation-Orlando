package demo1;

import demo.ConfigDB;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.rmi.AccessException;
import java.sql.SQLException;

public  class OpenARAccounts_Test extends ZeroTest {

    static String filename_script ="openAr.testquery";
    static String filename_project="Open Ar Report.txt";
    static String foldername_project="OHHA";

    public OpenARAccounts_Test () throws IOException {
        super(filename_script,filename_project,foldername_project);
        super.initBrowser();
        super.getSteps();

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

    @AfterClass
    public static void afterClass() {
        driver.quit();

    }


}
