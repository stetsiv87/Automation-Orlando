package Orlando.OHHA;

import Orlando.BaseTest;
import org.junit.*;
import java.io.IOException;
import java.sql.SQLException;

public class OHHA_TransactionOpenARBaseTest extends BaseTest {

    private static String query ="TransactionOpenAR.sql";
    private static String filename_project = "Transaction Open AR.properties";
    private static String foldername_project ="OHHA";


    public OHHA_TransactionOpenARBaseTest() throws IOException {
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


