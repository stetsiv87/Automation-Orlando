package Orlando.OHHA;

import Orlando.BaseTest;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.sql.SQLException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OHHA_openArAccountsBaseTest extends BaseTest {

    private static String query = "Open Ar Counts.sql";
    private static String filename_project = "Open Ar Report.properties";
    private static String foldername_project = "OHHA";


    public OHHA_openArAccountsBaseTest() throws IOException {
        super(filename_project, foldername_project, query);
    }

    @BeforeClass
    public static void beforeClass() throws IOException {
        initBrowser();
    }

    @Before
    public void before() throws IOException {
        steps();
    }

    @Test
    public void get01LoadReportTest() throws IOException {
        checkElementsPresenceSummary();
    }

    @Test
    public void get02CheckTotalsTest() throws IOException, SQLException {
        checkUIDB();
    }

    @Test
    public void get03DrillsTest() throws IOException, InterruptedException {
        checkElementsPresenceDetailed();
    }

    @Test
    public void get04SummaryDetailedValueComparisonTest() throws IOException, SQLException {
        checkSummaryDetails();
    }

    @AfterClass
    public static void afterClass() {
        quit();
    }
}