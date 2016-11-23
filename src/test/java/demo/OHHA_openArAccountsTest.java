package demo;

import org.junit.AfterClass;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OHHA_openArAccountsTest extends OHHAReportTest {

    private static String query = "Select count(*) Aroutstanding  from nohbian_datamart_02.dbo.vatbsum";
    private static String projectId = "Orlando+Health+Hospital+Analytics";
    private static String datasedID = "18CC69A24F6F36CBA469B4A70C924BB9";
    private static String reportID = "FE0CEE9A43656219F4051EA17D65EF12";

    public OHHA_openArAccountsTest() {
        super(projectId,datasedID, reportID);
    }

    @Test
    public void testLoadReport() {
        Assert.assertEquals("Open AR Accounts_Rpt. Numero", getDriver().getTitle());
    }

    @Test
    public void testTotals() throws SQLException, IOException {
        Map<String, Integer> totals = new HashMap<>();
        queryDB(query, (rs, rowNumber) -> {
            totals.put("Dollars", rs.getInt("Aroutstanding"));
        });
        System.out.println(totals);
    }

//    @AfterClass
//    public static void closeDriver(){
//        afterClass();
//    }



}
