package Orlando.OHHA;

import Orlando.BaseTest;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Yuriy_Stetsiv on 12/14/2016.
 */
public class OHHA_Transaction25MonthsBaseTest extends BaseTest {

    private static String query ="Transaction 25 Months.sql";
    private static String filename_project = "Transaction 25 Months.properties";
    private static String foldername_project ="OHHA";


    public OHHA_Transaction25MonthsBaseTest() throws IOException {
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
        checkElementsPresenceSummary();
    }

    @Test
    public void testCheckTotals () throws IOException, SQLException, InterruptedException {
        addAttribute(getMetricTitle());
        checkUIDB();
    }

    @Test
    public void testDrills () throws IOException, InterruptedException {
        checkElementsPresenceDetailed();
    }

    @AfterClass
    public static void afterClass(){
        quit();
    }

}
