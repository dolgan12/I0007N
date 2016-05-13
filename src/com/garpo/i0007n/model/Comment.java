package com.garpo.i0007n.model;

import java.util.Date;

/**
 * Created by Conny Garpö on 4/27/2016.
 */
public class Comment {
    private static int count = 1;
    private int id;
    private int updatedBy;
    private int taskId;
    private String text;
    private Date updated;

    public Comment(int id, int updatedBy, int taskId, String text, Date updated) {
        this(updatedBy,taskId,text,updated);
        this.id = id;

    }

    public Comment(int updatedBy, int taskId, String text, Date updated){
        this.updatedBy = updatedBy;
        this.taskId = taskId;
        this.text = text;
        this.updated = updated;
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
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

    public java.sql.Date getSqlUpdated() {

        return new java.sql.Date(updated.getTime());
    }
    public Date getUpdated(){
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}

