package demo;

import org.junit.*;
import java.io.IOException;
import java.sql.SQLException;


public class OHHA_openArAccountsTest extends Test_New  {

    private static String query ="Open Ar Counts.sql";
    private static String filename_project = "Open Ar Report.properties";
    private static String foldername_project ="OHHA";


    public OHHA_openArAccountsTest() throws IOException {
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
