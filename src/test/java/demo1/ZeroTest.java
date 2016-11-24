package demo1;

import java.io.IOException;

/**
 * Created by Yuriy_Stetsiv on 11/24/2016.
 */
public class ZeroTest extends NavigationDriver  {


        static ProjectConfig pc  = new ProjectConfig();
        static ScriptsConfig sc = new ScriptsConfig();

    public static  void OpenArTest() throws IOException {
        String filename_script ="openAr.testquery";
        String filename_project = "Open Ar Report.txt";
        String foldername_project ="OHHA";

        sc.setTestScript(filename_script);
        pc.setTestScript(filename_project);
        pc.setFoldername(foldername_project);

        sc.getPropsFromFile();
        pc.getPropsFromFile();

        openProject(pc.getProjectName());
        buttonHandle();
        selectReportFolder(pc.getReportFolder());
        selectDatasetid(pc.getDataset());
        selectReportid(pc.getReport());
        readValue(pc.getValue());

    }

}
