package com.garpo.i0007n.model;

import java.util.Date;

/**
 * Created by Conny Garpö on 4/27/2016.
 */
public class Comment {
    private int id;
    private int updatedBy;
    private int taskId;
    private String text;
    private Date updated;

    public Comment(int id, int updatedBy, int taskId, String text, Date updated) {
        this.id = id;
        this.updatedBy = updatedBy;
        this.taskId = taskId;
        this.text = text;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}

