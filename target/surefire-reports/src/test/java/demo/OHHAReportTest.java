package demo;

import net.sourceforge.jtds.jdbcx.JtdsDataSource;

import javax.sql.DataSource;
import java.io.IOException;

public class OHHAReportTest extends BaseReportTest {



    public OHHAReportTest(String projectId, String datasetId, String reportId) {
        super(projectId , datasetId, reportId);
    }



    @Override
    public DataSource getDatasource() throws IOException {
        JtdsDataSource ds = new JtdsDataSource();
        ConfigDB.getPropsFromFile();
        ds.setServerName(ConfigDB.getServerName());
        ds.setPortNumber(ConfigDB.getPortNumber());
        ds.setUseNTLMV2(ConfigDB.getUseNTLMV2());
        ds.setUser(ConfigDB.getUser());
        ds.setPassword(ConfigDB.getPassword());
        ds.setDomain(ConfigDB.getDomain());
        return ds;
    }
}
