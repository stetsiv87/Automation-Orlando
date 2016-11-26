package demo;

import demo.OHHAReportTest;
import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Global;
import org.junit.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static demo.Test_New.driver;

public class OHHA_ChargesRolling25Test extends Test_New {
    private static String query ="script_ChargesRolling25Months.txt";
    private static String filename_project = "Charges Rolling 25 Months.txt";
    private static String foldername_project ="OHHA";


    public OHHA_ChargesRolling25Test() throws IOException {
        super(filename_project, foldername_project,query);

    }

    @BeforeClass
    public static void beforeClass () throws IOException {
        initBrowser();
        System.out.println("ronnin initBrowser method..");
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

        final double [] a = new double[1];

        System.out.println(readValue((getValue().replace(",","")).replace("$","")));
        System.out.println(getTestQuery());

        queryDB(getTestQuery(), (rs, rowNumber) -> {
            a[0] = rs.getDouble("TotalCharges");
        });
        System.out.println(a[0]);
        Assert.assertEquals("FAILED",a[0], readValue((getValue().replace(",","")).replace("$","")));
    }

    @AfterClass
    public static void afterClass(){
        quit();
    }



}