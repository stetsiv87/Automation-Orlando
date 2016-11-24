package demo1;

import java.io.IOException;

/**
 * Created by Yuriy_Stetsiv on 11/24/2016.
 */
public class ZeroTest extends NavigationDriver  {


        static ProjectConfig pc  = new ProjectConfig();
        static ScriptsConfig sc = new ScriptsConfig();

    public static void getFiles (String fileScript, String fileProject, String folderProject) throws IOException {
        sc.setTestScript(fileScript);
        pc.setTestScript(fileProject);
        pc.setFoldername(folderProject);
        sc.getPropsFromFile();
        pc.getPropsFromFile();
    }

    public static void getSteps () throws IOException {
        openProject(pc.getProjectName());
        buttonHandle();
        selectReportFolder(pc.getReportFolder());
        selectDatasetid(pc.getDataset());
        selectReportid(pc.getReport());
    }

    public static  void OpenArTest() throws IOException {
        String filename_script ="openAr.testquery";
        String filename_project = "Open Ar Report.txt";
        String foldername_project ="OHHA";
        getFiles(filename_script,filename_project,foldername_project);
        getSteps();

      //  readValue(pc.getValue());

    }

}
