package demo1;

import demo.*;
import net.sourceforge.jtds.jdbcx.JtdsDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {

    public static  void queryDB(String query, SQL.RowHandler rowHandler) throws SQLException, IOException {
        try (Connection con = getDatasource().getConnection()) {
            try (Statement s = con.createStatement()) {
                try (ResultSet rs = s.executeQuery(query)) {
                    int currentRow = 0;
                    while (rs.next()) {
                        rowHandler.handleRow(rs, currentRow);
                        currentRow++;
                    }
                }
            }
        }
    }


    public static DataSource getDatasource() throws IOException {
        JtdsDataSource ds = new JtdsDataSource();
        demo.ConfigDB.getPropsFromFile();
        ds.setServerName(demo.ConfigDB.getServerName());
        ds.setPortNumber(demo.ConfigDB.getPortNumber());
        ds.setUseNTLMV2(demo.ConfigDB.getUseNTLMV2());
        ds.setUser(demo.ConfigDB.getUser());
        ds.setPassword(demo.ConfigDB.getPassword());
        ds.setDomain(demo.ConfigDB.getDomain());
        return ds;
    }

    interface RowHandler {
        void handleRow(ResultSet rs, int rowNumber) throws SQLException;
    }
}
