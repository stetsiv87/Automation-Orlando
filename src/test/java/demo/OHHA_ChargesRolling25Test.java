package demo;

import demo.OHHAReportTest;
import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Global;
import org.junit.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static demo.Test_New.driver;

public class OHHA_ChargesRolling25Test extends Test_New {
    private static String query ="script_ChargesRolling25Months.txt";
    private static String filename_project = "Charges Rolling 25 Months.sql";
    private static String foldername_project ="OHHA";


    public OHHA_ChargesRolling25Test() throws IOException {
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
        Assert.assertEquals( driver.getTitle(),getTitle());
    }

    @Test
    public void testCheckTotals () throws IOException, SQLException {

        Assert.assertEquals("DB value: "+getDBvalue(query)+" does not match with UI value "+
                getUIValue(getValue()), true,compareValues(getValueDataType(),getDBvalue(query),getUIValue(getValue())));

    }

    @AfterClass
    public static void afterClass(){
        quit();
    }

}