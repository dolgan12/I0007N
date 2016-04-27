package com.garpo.i0007n.model;

import java.util.List;

/**
 * Created by Conny Garpö on 4/27/2016.
 */
public interface CommentDAO {
    List<Comment> getAllCommentsForId(int taskid) throws Exception;
    Comment getComment(int id) throws Exception;
    int addComment(Comment comment) throws Exception;
}
