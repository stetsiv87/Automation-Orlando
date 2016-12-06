package demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public interface ProjectConfig {


    Properties props = new Properties();



    static void getPropsFromFile(String filename, String foldername) throws IOException {
        String jhome = System.getenv("Autoscript");
        String fullPath = jhome + File.separator + "autoscript" + File.separator + File.separator +"test config" + File.separator + foldername + File.separator + filename;
        props.load(new FileReader(new File(fullPath)));
    }

    default String  getProjectName() throws IOException {
        return props.getProperty("project_name");

    }

    default String  getReportFolder() throws IOException {
        return props.getProperty("report_folder");

    }

    default String  getDataset() throws IOException {
        return props.getProperty("dataset_id");

    }

    default String  getReport() throws IOException {
        return props.getProperty("report_id");

    }

    default String  getValue() throws IOException {
        return props.getProperty("metric_location");
    }


    default String  getTitle() throws IOException {
        return props.getProperty("title_verification");
    }

    default String getValueDataType() throws IOException {
        return props.getProperty("metric_data_type");
    }

    default String getDBColumnName() throws IOException {
        return props.getProperty("DB_column_name");
    }

    default String  getMetricTitle() throws IOException {
        return props.getProperty("Adding_metric");
    }

    default String getAttributeID() throws IOException {
    }

    default String getCellForDrill() throws IOException {
        return props.getProperty("drill_cell");
    }

    default String getTitleDetailed() throws IOException {
        return props.getProperty("title_verification_detailed");
    }
}
