package com.garpo.i0007n.view.mainframecomponents;

import com.garpo.i0007n.controll.TaskTabelModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by Conny Garpö on 5/5/2016.
 */
public class TimeStatusColumnCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col){
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        TaskTabelModel tableModel = (TaskTabelModel) table.getModel();
        if(tableModel.getTimeStatus(row)){
            label.setBackground(Color.RED);
        } else if(!isSelected){
            label.setBackground(table.getBackground());
        } else {
            label.setBackground(super.getBackground());
        }
        return label;
    }
}
