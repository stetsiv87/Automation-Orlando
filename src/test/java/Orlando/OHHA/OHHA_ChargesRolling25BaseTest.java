package Orlando.OHHA;

import Orlando.BaseTest;
import org.junit.*;
import java.io.IOException;
import java.sql.SQLException;


public class OHHA_ChargesRolling25BaseTest extends BaseTest {

    private static String query ="Charges Rolling 25 Months.sql";
    private static String filename_project = "Charges Rolling 25 Months.properties";
    private static String foldername_project ="OHHA";


    public OHHA_ChargesRolling25BaseTest() throws IOException {
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