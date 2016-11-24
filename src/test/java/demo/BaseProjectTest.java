package demo;

import java.io.IOException;

public abstract class BaseProjectTest extends BaseTest {

    private static String selectedProject;
    private final String projectId;


    public BaseProjectTest(String projectId) {
        this.projectId = projectId;

    }

    public void init() throws IOException {
        super.initBrowser();
        selectedProject = null;
        if (!projectId.equals(selectedProject)) {
            openProject(projectId);
            selectedProject = projectId;
        }
    }
}
