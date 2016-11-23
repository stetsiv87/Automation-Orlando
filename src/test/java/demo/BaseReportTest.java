package demo;

import org.junit.Before;

public abstract class BaseReportTest extends BaseProjectTest {

    private static String currentReport;

    private static String reportFolder = "Reports";
    private final String datasetId;
    private final String reportId;

    public BaseReportTest(String projectId, String datasetId, String reportId) {
        super(projectId);
        this.datasetId = datasetId;
        this.reportId = reportId;


    }

    @Before
    @Override
    public void init() {
        super.init();
        if (!reportId.equals(currentReport)) {
            selectReportFolder(reportFolder);
            selectDatasetid(datasetId);
            selectReportid(reportId);
            currentReport = reportId;
        }
    }
}
