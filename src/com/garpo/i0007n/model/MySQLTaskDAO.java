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

        insertStatement.close();

        return added;
    }

    @Override
    public int updateTask(Task task) throws Exception {
        String updateSQL = "UPDATE tasks SET assignedTo = ?, categoryId = ?, statusId = ?, description = ?, " +
                "estimateTime = ?, usedTime = ? WHERE id = ? ";
        Connection con = MySQLDatabase.getInstance().getConnection();

        PreparedStatement updateStatement = con.prepareStatement(updateSQL);
        updateStatement.setInt(1, task.getAssigned());
        updateStatement.setInt(2, task.getCategory());
        updateStatement.setInt(3, task.getStatus());
        updateStatement.setString(4, task.getDescription());
        updateStatement.setInt(5, task.getEstimateTime());
        updateStatement.setInt(6, task.getUsedTime());
        updateStatement.setInt(7, task.getId());

        int updated = updateStatement.executeUpdate();
        updateStatement.close();
        return updated;
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
        selectStatement.close();
        return tasks;
    }

    @Override
    public Task getTask(int id) throws Exception {
        String selectSQL = "SELECT * FROM tasks WHERE id = ?";
        Connection con = MySQLDatabase.getInstance().getConnection();

        PreparedStatement preparedStatement = con.prepareStatement(selectSQL);

        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int taskId = resultSet.getInt("id");
        int assignedTo = resultSet.getInt("assignedTo");
        int categoryId = resultSet.getInt("categoryId");
        int statusId = resultSet.getInt("statusId");
        String description = resultSet.getString("description");
        int estimateTime = resultSet.getInt("estimateTime");
        int usedTime = resultSet.getInt("usedTime");

        Task task = new Task(taskId, assignedTo,categoryId,statusId,description,estimateTime, usedTime);

        preparedStatement.close();
        return task;
    }

    @Override
    public int getMaxId() throws Exception {
        String selectSql = "SELECT MAX(id) AS max FROM tasks";
        Connection con = MySQLDatabase.getInstance().getConnection();

        PreparedStatement selectStatement = con.prepareStatement(selectSql);

        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int taskId = resultSet.getInt("max");
        return taskId;
    }
}
