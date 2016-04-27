package com.garpo.i0007n.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conny Garpö on 4/24/2016.
 */
public class MySQLStatusDAO implements StatusDAO{
    @Override
    public List<Status> getAllStatus() throws Exception {
        List<Status> statuses = new ArrayList<>();
        String selectSql = "SELECT id, description FROM status ORDER BY id";
        Connection con = MySQLDatabase.getInstance().getConnection();

        Statement selectStatement = con.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(selectSql);

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String description = resultSet.getString("description");
            Status status = new Status(id, description);
            statuses.add(status);
        }
        return statuses;
    }

}
