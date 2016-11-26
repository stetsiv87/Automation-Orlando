package demo;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.junit.AfterClass;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static demo.ConfigDB.getTenantPassword;

public class OHHA_openArAccountsTest extends Test_New  {


    private static String query ="openAr.testquery";
    private static String filename_project = "Open Ar Report.txt";
    private static String foldername_project ="OHHA";


    public OHHA_openArAccountsTest() throws IOException {
        super(filename_project, foldername_project,query);
        System.out.println("runnig constructor...");
    }

    @BeforeClass
    public static void beforeClass () throws IOException {
        initBrowser();

    }

    @Before
    public void before() throws IOException {
        steps();
    }

    @Test
    public void testLoadReport() {
        Assert.assertEquals("Open AR Accounts_Rpt. Numero", driver.getTitle());
    }

    @Test
    public void testCheckTotals () throws IOException, SQLException {

        final int[] a = new int[1];

        System.out.println(readValue(getValue()));
        System.out.println();
        queryDB(getTestQuery(), (rs, rowNumber) -> {
            a[0] = rs.getInt("counts");
        });
        System.out.println(a[0]);
        Assert.assertEquals("FAILED",a[0],Integer.parseInt(readValue(getValue()).replace(",","")));

    }
    @AfterClass
    public static void afterClass(){
        quit();
    }



}
