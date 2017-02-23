package Orlando;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public interface ProjectConfig {


    Properties props = new Properties();
    String jhome = System.getenv("Autoscript");
    String path =  jhome + File.separator + "autoscript";


    default String getTestQuery(String filename_script) throws IOException {
        String fullPath = path + File.separator + File.separator +"scripts" + File.separator + filename_script;
        return new String(Files.readAllBytes(Paths.get(fullPath)));
    }

    static void getTestConfig(String filename, String foldername) throws IOException {
        String fullPath = path + File.separator + File.separator +"test config" + File.separator + foldername + File.separator + filename;
        props.load(new FileReader(new File(fullPath)));
    }

    static List<String[]> getTestList() throws IOException {
    List<String[]> mTestList = new ArrayList<>();
    FileReader fileReader = new FileReader(new File(path + File.separator + "TestList.txt"));
    BufferedReader br = new BufferedReader(fileReader);
    String line = null;
    while ((line = br.readLine()) != null) {
        String[] tokens = line.split(",");
        mTestList.add(tokens);
    }
    return mTestList;
}

    default String getProjectName() throws IOException {
        return props.getProperty("project_name");
    }
    default String getReportFolder() throws IOException {
        return props.getProperty("report_folder");
    }
    default String getDataset() throws IOException {
        return props.getProperty("dataset_id");

    }
    default String getReport() throws IOException {
        return props.getProperty("report_id");

    }
    default String getValue() throws IOException {
        return props.getProperty("metric_location");
    }
    default String getTitle() throws IOException {
        return props.getProperty("title_verification");
    }
    default String getValueDataType() throws IOException {
        return props.getProperty("metric_data_type");
    }
    default String getDBColumnName() throws IOException {
        return props.getProperty("DB_column_name");
    }
    default String getMetricTitle() throws IOException {
        return props.getProperty("Adding_metric");
    }
    default String getAttributeID() throws IOException {
        return props.getProperty("Adding_attribute");
    }
    default String getCellForDrill() throws IOException {
        return props.getProperty("drill_cell");
    }
    default String getTitleDetailed() throws IOException {
        return props.getProperty("title_verification_detailed");
    }
}
