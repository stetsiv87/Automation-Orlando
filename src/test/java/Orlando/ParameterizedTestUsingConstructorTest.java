package Orlando;


import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class ParameterizedTestUsingConstructorTest extends BaseTest {


    @Test
    public void Test_01_Login() throws IOException {
        initBrowser();
        steps();
    }

    @Test
    public void Test_02_LoadReport() throws IOException, InterruptedException {
        addAttribute(getMetricTitle());
        checkElementsPresenceSummary();
    }

    @Test
    public void Test_03_CheckTotals() throws IOException, SQLException {
        checkUIDB();
    }

    @Test
    public void Test_04_Drills() throws IOException, InterruptedException {
        checkElementsPresenceDetailed();
    }


    @Test
    public void Test_05_SummaryDetailedValueComparison() throws IOException, SQLException {
        checkSummaryDetails();
    }

    @Test
    public void Test_06_Logout() {
        quit();
    }


    public ParameterizedTestUsingConstructorTest(String testname, String filename_project, String query,String foldername_project) throws IOException {
        super(filename_project, query, foldername_project);
    }

    // creates the test data
    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() throws IOException {
        List<String[]> mTestList = ProjectConfig.getTestList();
        int testListSize = mTestList.size();
        Object[][] data = new Object[testListSize][4];
        for (int k = 0; k < testListSize; k++) {
            for (int i = 0; i < mTestList.get(0).length; i++) {
                data[k][i] = (mTestList.get(k))[i];
            }
        }
        return Arrays.asList(data);
    }


}
    


