package demo;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Objects;

import static demo.ConfigDB.getTenant;
import static demo.ConfigDB.getTenantPassword;
import static demo.ConfigDB.getUserName;

/**
 * Created by Yuriy_Stetsiv on 11/26/2016.
 */
public class Test_New extends NavigationHelper implements ProjectConfig,SQLHelper,ScriptsConfig,DataTypeHandler {

    public static String url = "https://stg-login.visiquate.com/numero";
    static WebDriver driver;
    static public String projectname;
    static public String dataset;
    static public String report;
    public static String file;
    public static String stFile;
    static int count =0;

    public Test_New(String file_project_config, String projectFolder) throws IOException {
        this.file = file_project_config;
        ProjectConfig.getPropsFromFile(file_project_config,projectFolder);
       // ScriptsConfig.getPropsFromFile(query);
        System.out.println(getProjectName());
        if (!file.equals(stFile)){
            projectname= null;
            dataset=null;
            report =null;
        }
    }

    public static void initBrowser() throws IOException {
        if (driver==null) {
            driver = new FirefoxDriver();
            ConfigDB.getPropsFromFile();
            SQLHelper.getDatasource();
            login(url, ConfigDB.getTenant(), ConfigDB.getUserName(), ConfigDB.getTenantPassword());
        }
    }


    public void steps() throws IOException {
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

    public String getUIValue (String value ){
        String str = (readValue(value).replace(",","")).replace("$","");
        return str;
    }

    public boolean compareValues (String type, String db, String ui){
        String intDataType ="integer";
        String bigDecimalDatatype = "double";


        if (type.equals(intDataType)){
            return Integer.parseInt(db)==Integer.parseInt(ui);

        }
        if (type.equals(bigDecimalDatatype)){
            BigDecimal a =BigDecimal.valueOf(Double.parseDouble(db));
            BigDecimal b =BigDecimal.valueOf(Double.parseDouble(ui));
           return a.equals(b);
        }

        return false;
    }


    public static void quit() {
        driver.quit();
        driver = null;
    }

}