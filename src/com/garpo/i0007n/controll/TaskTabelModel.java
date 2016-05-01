package com.garpo.i0007n.controll;

import com.garpo.i0007n.controll.Controller;
import com.garpo.i0007n.model.Task;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Conny Garpö on 4/24/2016.
 */
public class TaskTabelModel extends AbstractTableModel{
    Controller controller = Controller.getController();
    private List<Task> taskList;
    private String[] colNames = {"Task Id", "Status", "Category", "Description", "Assigned To", "Estimated Time", "Used Time"};

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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = taskList.get(rowIndex);
        switch (columnIndex){
            case 0:
                return task.getId();
            case 1:
                return controller.getStatus(task.getStatus()).getDescription();
            case 2:
                return controller.getCategory(task.getCategory()).getDescription();
            case 3:
                 return task.getDescription();
            case 4:
                return controller.getPerson(task.getAssigned());
            case 5:
                return task.getEstimateTime();
            case 6:
                return task.getUsedTime();
        }
        return null;
    }
}
