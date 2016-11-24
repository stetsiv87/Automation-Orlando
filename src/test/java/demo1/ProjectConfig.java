package demo1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ProjectConfig {

    private String filename;
    private String foldername;

    static String jhome = System.getenv("Autoscript");

    private static Properties props = new Properties();

    public void setTestScript (String filename){

        this.filename=filename;
    }

    public void setFoldername(String foldername) {

        this.foldername = foldername;
    }

    public void getPropsFromFile() throws IOException {
        String fullPath = jhome + File.separator + "autoscript" + File.separator + File.separator +"test config" + File.separator + foldername + File.separator + filename;
        props.load(new FileReader(new File(fullPath)));
    }

    public String  getProjectName() throws IOException {
        return props.getProperty("project_name");

    }

    public String  getReportFolder() throws IOException {
        return props.getProperty("report_folder");

    }

    public String  getDataset() throws IOException {
        return props.getProperty("dataset_id");

    }

    public String  getReport() throws IOException {
        return props.getProperty("report_id");

    }

    public String  getValue() throws IOException {
        return props.getProperty("metric");
    }

    public String  getTitle() throws IOException {
        return props.getProperty("title_verification");
    }

}
