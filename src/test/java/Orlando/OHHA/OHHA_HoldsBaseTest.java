package Orlando.OHHA;

import Orlando.BaseTest;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Yuriy_Stetsiv on 12/13/2016.
 */
public class OHHA_HoldsBaseTest extends BaseTest {

    private static String query ="Holds.sql";
    private static String filename_project = "Holds.properties";
    private static String foldername_project ="OHHA";


    public OHHA_HoldsBaseTest() throws IOException {
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
    public void testLoadReport() throws IOException, InterruptedException {
        addAttribute(getMetricTitle());
        checkElementsPresenceSummary();
    }

    @Test
    public void testCheckTotals () throws IOException, SQLException {
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
