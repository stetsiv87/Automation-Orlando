package demo;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.junit.AfterClass;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static demo.ConfigDB.getTenantPassword;

public class OHHA_openArAccountsTest extends Test_New  {


    private static String query ="openAr.testquery";
    private static String filename_project = "Open Ar Report.txt";
    private static String foldername_project ="OHHA";


    public OHHA_openArAccountsTest() throws IOException {
        super(filename_project, foldername_project);
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
    public void testLoadReport() throws IOException {
        Assert.assertEquals(getTitle(), driver.getTitle());
    }

    @Test
    public void testCheckTotals () throws IOException, SQLException {

        Assert.assertEquals("DB value: "+getDBvalue(query)+" does not match with UI value "+
                getUIValue(getValue()), true,CompareValues(getValueDataType(),getDBvalue(query),getUIValue(getValue())));

    }


    @AfterClass
    public static void afterClass(){
        quit();
    }



}
