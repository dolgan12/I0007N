package com.garpo.i0007n.view.mainframecomponents;

import com.garpo.i0007n.model.Person;
import com.garpo.i0007n.model.Task;
import com.garpo.i0007n.model.TaskTabelModel;
import com.garpo.i0007n.view.FormEvent;
import com.garpo.i0007n.view.FormListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


/**
 * Created by Conny Garpö on 4/24/2016.
 */
public class TaskTabelPanel extends JPanel{
    private JTable table;
    private TaskTabelModel tabelModel;
    private FormListener formListener;

    public TaskTabelPanel(){
        tabelModel = new TaskTabelModel();
        table = new JTable(tabelModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row, row);

                int id = (int)table.getModel().getValueAt(row, 0);
                String status = (String)table.getModel().getValueAt(row,1);
                String cat = (String)table.getModel().getValueAt(row,2);
                String desc = (String)table.getModel().getValueAt(row,3);
                Person assignedTo = (Person)table.getModel().getValueAt(row, 4);
                int estTime = (int)table.getModel().getValueAt(row,5);
                int usedTime = (int)table.getModel().getValueAt(row,6);
                FormEvent event = new FormEvent(this, id, assignedTo, cat, status, desc, estTime, usedTime);


                if(formListener != null){
                    formListener.formEventOccured(event);
                    System.out.println("Event sent!");
                }
            }
        });
    }

    public void setData(List<Task> taskList){
        tabelModel.setData(taskList);
    }
    public void refresh(){
        tabelModel.fireTableDataChanged();
    }
    public void setFormListener(FormListener formListener){
        this.formListener = formListener;
    }


}
