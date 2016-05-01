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
        return null;
    }

    @Override
    public int addComment(Comment comment) throws Exception {
        return 0;
    }

    @Override
    public int updateComment(Comment comment) throws Exception {
        return 0;
    }
}
