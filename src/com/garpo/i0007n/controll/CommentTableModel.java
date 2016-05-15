/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garpo.i0007n.controll;

/**
 *
 * @author Anna
 */
public class CommentTableModel {
    Controller controller = Controller.getController();
    private List<Comment> commentList;
    private String[] colNames = {"Kommentar", "Datum", "Användare"};

    public void setData(List<Task> taskList){
        this.taskList = taskList;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return taskList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

}
