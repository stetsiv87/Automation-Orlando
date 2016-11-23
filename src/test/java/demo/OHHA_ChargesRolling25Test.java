package demo;

import demo.OHHAReportTest;import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OHHA_ChargesRolling25Test extends OHHAReportTest {
    private static String query = "Select top 3  Aroutstanding  from nohbian_datamart_02.dbo.vatbsum";
    private static String projectId = "Orlando+Health+Hospital+Analytics";
    private static String datasedID = "B0216042413E16462C4C2890871953FB";
    private static String reportID = "780F44844340B7599E62B1B313729B29";

    public OHHA_ChargesRolling25Test() {
        super(projectId,datasedID, reportID);
    }

    @Test
    public void testLoadReport() {
        Assert.assertEquals("Charges Rolling 25 Months_Rpt. Numero", getDriver().getTitle());
    }

    @Test
    public void testTotals() throws SQLException, IOException {
        Map<String, Double> totals = new HashMap<>();
        queryDB(query, (rs, rowNumber) -> {
            totals.put("Dollars", rs.getDouble("Aroutstanding"));
        });
        System.out.println(totals);
    }

//    @AfterClass
//    public static void closeDriver(){
//        afterClass();
//    }

}