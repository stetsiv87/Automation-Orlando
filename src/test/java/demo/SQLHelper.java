package demo;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface SQLHelper {

    default void queryDB(String query, RowHandler rowHandler) throws SQLException, IOException {
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



    DataSource getDatasource() throws IOException;

    interface RowHandler {
        void handleRow(ResultSet rs, int rowNumber) throws SQLException;
    }
}
