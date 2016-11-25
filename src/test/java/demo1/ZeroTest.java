package demo1;

import demo.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class ZeroTest implements NavigationDriver  {

    static WebDriver driver;
    static ProjectConfig pc  = new ProjectConfig();
    static ScriptsConfig sc = new ScriptsConfig();

    public static String url = "https://stg-login.visiquate.com/numero";

    ZeroTest(String filename_script,String filename_config, String folderename_project) throws IOException {
        sc.setTestScript(filename_script);
        pc.setTestScript(filename_config);
        pc.setFoldername(folderename_project);
        sc.getPropsFromFile();
        pc.getPropsFromFile();
    }

    public void initBrowser() throws IOException {
        driver = new FirefoxDriver();
        ConfigDB.getPropsFromFile();
        login(url, ConfigDB.getTenant(), ConfigDB.getUserName(), ConfigDB.getTenantPassword());
        SQL.getDatasource();
    }



    public  void getSteps () throws IOException {
        openProject(pc.getProjectName());
        buttonHandle();
        selectReportFolder(pc.getReportFolder());
        selectDatasetid(pc.getDataset());
        selectReportid(pc.getReport());
    }


}
