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
    private static String query ="Charges Rolling 25 Months.sql";
    private static String filename_project = "Charges Rolling 25 Months.properties";
    private static String foldername_project ="OHHA";


    public OHHA_ChargesRolling25Test() throws IOException {
        super(filename_project, foldername_project, query);

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
        Assert.assertTrue(readElementName(getTitle()));
    }

    @Test
    public void testCheckTotals () throws IOException, SQLException {

        Assert.assertEquals("DB value: "+getDBvalue(query)+" does not match with UI value "+
                getUIValue(getValue()), true,compareValues(getValueDataType(),getDBvalue(query),getUIValue(getValue())));

    }

    @Test
    public void drillCheck () throws IOException, InterruptedException {
        addAttribute(getAttributeID());
        drillDown(getCellForDrill());
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Assert.assertTrue(readElementName_detailed(getTitleDetailed()));
        driver.switchTo().window(winHandleBefore);
    }

    @AfterClass
    public static void afterClass(){
        quit();
    }

}