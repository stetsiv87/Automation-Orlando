package demo;

public abstract class BaseProjectTest extends BaseTest {

    private static String selectedProject;
    private final String projectId;


    public BaseProjectTest(String projectId) {
        this.projectId = projectId;

    }

    public void init() {
        super.initBrowser();
        if (!projectId.equals(selectedProject)) {
            openProject(projectId);
            selectedProject = projectId;
        }
    }
}
