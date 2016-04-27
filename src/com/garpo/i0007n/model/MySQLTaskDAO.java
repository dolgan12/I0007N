package com.garpo.i0007n.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conny Garpö on 4/24/2016.
 */
public class MySQLTaskDAO implements TaskDAO{
    @Override
    public int addTask(Task task) throws Exception {
        String insertSql = "INSERT INTO tasks (id, assignedTo, categoryId, statusId, description, estimateTime, usedTime) values (?, ?, ?, ?, ?, ?, ?)";
        Connection con = MySQLDatabase.getInstance().getConnection();

        PreparedStatement insertStatement = con.prepareStatement(insertSql);

        insertStatement.setInt(1, task.getId());
        insertStatement.setInt(2, task.getAssigned());
        insertStatement.setInt(3, task.getCategory());
        insertStatement.setInt(4, task.getStatus());
        insertStatement.setString(5, task.getDescription());
        insertStatement.setInt(6, task.getEstimateTime());
        insertStatement.setInt(7, task.getUsedTime());

        int added = insertStatement.executeUpdate();

        return added;
    }

    @Override
    public int updateTask(int id) throws Exception {
        return 0;
    }

    @Override
    public List<Task> getAllTasks() throws Exception {
        List<Task> tasks = new ArrayList<>();
        String selectSQL = "Select * FROM tasks ORDER BY id";
        Connection conn = MySQLDatabase.getInstance().getConnection();

        Statement selectStatement = conn.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(selectSQL);
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            int catId = resultSet.getInt("categoryId");
            int assigned = resultSet.getInt("assignedTo");
            int status = resultSet.getInt("statusId");
            String description = resultSet.getString("description");
            int eTime = resultSet.getInt("estimateTime");
            int uTime = resultSet.getInt("usedTime");
            Task task = new Task(id, assigned, catId, status, description, eTime, uTime);
            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public Task getTask(int id) throws Exception {
        return null;
    }
}
