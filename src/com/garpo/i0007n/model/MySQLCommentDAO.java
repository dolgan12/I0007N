package com.garpo.i0007n.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Conny Garpö on 4/27/2016.
 */
public class MySQLCommentDAO implements CommentDAO{
    @Override
    public List<Comment> getAllCommentsForId(int taskid) throws Exception {
        List<Comment> comments = new ArrayList<>();
        String selectSql = "SELECT * from comments WHERE taskId = ?";
        Connection con = MySQLDatabase.getInstance().getConnection();

        PreparedStatement selectStatement = con.prepareStatement(selectSql);
        selectStatement.setInt(1,taskid);

        ResultSet resultSet = selectStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            int updatedBy = resultSet.getInt("UpdatedBy");
            int taskId = resultSet.getInt("taskId");
            String commentText = resultSet.getString("comment");
            Date date = resultSet.getDate("created");

            Comment comment = new Comment(id, updatedBy, taskId, commentText, date);
            comments.add(comment);
        }
        return comments;
    }

    @Override
    public Comment getComment(int id) throws Exception {
        String selectSql = "SELECT * FROM comments WHERE id = ?";
        Connection con = MySQLDatabase.getInstance().getConnection();

        PreparedStatement selectStatement = con.prepareStatement(selectSql);

        selectStatement.setInt(1, id);

        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int commentId = resultSet.getInt("id");
        int updatedBy = resultSet.getInt("UpdatedBy");
        int taskId = resultSet.getInt("taskId");
        String commentText = resultSet.getString("comment");
        Date created = resultSet.getTimestamp("created");

        Comment comment = new Comment(commentId,updatedBy,taskId,commentText,created);
        selectStatement.close();

        return comment;
    }

    @Override
    public int addComment(Comment comment) throws Exception {
        String insertSql = "INSERT INTO comments (id, UpdatedBy, taskId, comment, created) values (?, ?, ?, ?, ?)";
        Connection con = MySQLDatabase.getInstance().getConnection();

        PreparedStatement insertStatement = con.prepareStatement(insertSql);

        insertStatement.setInt(1, comment.getId());
        insertStatement.setInt(2, comment.getUpdatedBy());
        insertStatement.setInt(3, comment.getTaskId());
        insertStatement.setString(4, comment.getText());
        insertStatement.setDate(5, comment.getSqlUpdated());

        int added = insertStatement.executeUpdate();

        insertStatement.close();
        return added;
    }

    @Override
    public int updateComment(Comment comment) throws Exception {
        String updateSql = "UPDATE comments SET UpdatedBy = ?, comment = ?";
        Connection con = MySQLDatabase.getInstance().getConnection();

        PreparedStatement updateStatement = con.prepareStatement(updateSql);
        updateStatement.setInt(1, comment.getUpdatedBy());
        updateStatement.setString(2, comment.getText());

        int updated = updateStatement.executeUpdate();
        updateStatement.close();
        return updated;
    }
    public int getMaxId() throws Exception {
        String selectSql = "SELECT MAX(id) AS max FROM comments";
        Connection con = MySQLDatabase.getInstance().getConnection();

        PreparedStatement selectStatement = con.prepareStatement(selectSql);

        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int commentId = resultSet.getInt("max");
        return commentId;
    }
}
