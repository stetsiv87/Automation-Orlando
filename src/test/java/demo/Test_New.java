package demo;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

import static demo.ConfigDB.getTenant;
import static demo.ConfigDB.getTenantPassword;
import static demo.ConfigDB.getUserName;

/**
 * Created by Yuriy_Stetsiv on 11/26/2016.
 */
public class Test_New extends NavigationHelper implements ProjectConfig,SQLHelper,ScriptsConfig {

    public static String url = "https://stg-login.visiquate.com/numero";
    static WebDriver driver;
    static public String projectname;
    static public String dataset;
    static public String report;
    public static String file;
    public static String stFile;

    public Test_New(String file_project_config, String projectFolder, String query) throws IOException {
        this.file = file_project_config;
        ProjectConfig.getPropsFromFile(file_project_config,projectFolder);
        ScriptsConfig.getPropsFromFile(query);
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

    public static void quit() {
        driver.quit();
        driver = null;
    }

}