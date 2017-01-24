package Orlando;

import org.apache.xpath.SourceTree;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yuriy_Stetsiv on 11/26/2016.
 */
public class BaseTest extends NavigationHelper implements ProjectConfig,SQLHelper,ScriptsConfig {

    static WebDriver driver;
    static public String projectname;
    static public String dataset;
    static public String report;
    public static String file;
    public static String stFile;
    public static String query;
    public static String drillMetricValue;


    public  BaseTest(String file_project_config, String projectFolder, String query) throws IOException {

                this.file = file_project_config;
                this.query = query;
                ProjectConfig.getPropsFromFile(file_project_config, projectFolder);
                if (!file.equals(stFile)) {
                    projectname = null;
                    dataset = null;
                    report = null;
                }
    }

    public static void initBrowser() throws IOException {
        if (driver==null) {
            driver = new FirefoxDriver();
            ConfigDB.getPropsFromFile();
            SQLHelper.getDatasource();
            login(ConfigDB.getUrl(), ConfigDB.getTenant(), ConfigDB.getUserName(), ConfigDB.getTenantPassword());
            System.out.println("Test row.....");
           
        }
    }

    public  void steps() throws IOException {
        stFile =file;
        if (!getProjectName().equals(projectname)){
            openProject(getProjectName());
            buttonHandle();
            selectReportFolder(getReportFolder());
            projectname = getProjectName();
        }

        if (!getDataset().equals(dataset)) {
            selectDatasetid(getDataset());
            dataset = getDataset();
        }

        if (!getReport().equals(report)) {
            selectReportid(getReport());
            report = getReport();
        }

    }

    public String getDBvalue(String query) throws IOException, SQLException {
        final String [] a = new String[1];
        queryDB(getTestQuery(query), (rs, rowNumber) -> {
            a[0] =rs.getString(getDBColumnName());
        });
        return a[0];
    }

    public String StringParser (String s) throws NullPointerException{
        return (((s.replace(",","")).replace("$","")).replace("(","")).replace(")","");
    }

    public String getUIValue (String value )  {
        String str = StringParser(readValue(value));
        return str;
    }

    public boolean compareValues (String type, String db, String ui, String totalsDetails){
        final String INTEGER_DATATYPE ="integer";
        final String DOUBLE_DATATYPE = "double";


        if (type.equals(INTEGER_DATATYPE) ){
            if (totalsDetails.equals("Totals")){
                return Integer.parseInt(db)==Integer.parseInt(ui)-1;
            } else {
                return Integer.parseInt(db)==Integer.parseInt(ui);
            }
        }
        if (type.equals(DOUBLE_DATATYPE)){
            BigDecimal a =BigDecimal.valueOf(Double.parseDouble(db));
            BigDecimal b =BigDecimal.valueOf(Double.parseDouble(ui));
            System.out.println(a+ " " + b);
            return a.equals(b);
        }

        return false;
    }

    public void checkElementsPresenceSummary() throws IOException {
        String [] tokens = getTitle().split(",");
        for (int i = 0; i <tokens.length ; i++) {
            Assert.assertTrue(readElementName(tokens[i]));
        }
    }

    public void checkUIDB () throws IOException, SQLException {
        Assert.assertEquals("DB value: "+getDBvalue(query)+" does not match with UI value "+
                getUIValue(getValue()), true,compareValues(getValueDataType(),getDBvalue(query),getUIValue(getValue()),"DB"));

    }

    public void checkSummaryDetails () throws IOException, SQLException {

        Assert.assertEquals("Value from Summary : "+ StringParser(getValueFromSummaryBeforeDrill()) +" does not match with value from details "+
                drillMetricValue, true,compareValues(getValueDataType(),StringParser(getValueFromSummaryBeforeDrill()),drillMetricValue,"Totals"));
    }


    public void checkElementsPresenceDetailed() throws IOException, InterruptedException {

        addAttribute(getAttributeID());
        drillDown(getCellForDrill());

        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        String [] tokens = getTitleDetailed().split(",");
        for (int i = 0; i <tokens.length ; i++) {
            Assert.assertTrue(readElementName_detailed(tokens[i]));
        }
        drillMetricValue = getIntegerValueFromDetail();
        driver.switchTo().window(winHandleBefore);
    }


    public static void quit() {
        driver.quit();
        driver = null;
    }

}