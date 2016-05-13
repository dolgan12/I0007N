package com.garpo.i0007n.view.mainframecomponents;

import com.garpo.i0007n.controll.Controller;
import com.garpo.i0007n.model.Person;
import com.garpo.i0007n.controll.FormEvent;
import com.garpo.i0007n.model.Task;
import com.garpo.i0007n.view.FormListener;
import com.garpo.i0007n.view.MainFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.*;

/**
 * Created by Conny Garpö on 4/24/2016.
 */
public class TaskFormPanel extends JPanel implements  FormListener{
    private JLabel idNameLabel;
    private JLabel idLabel;
    private JLabel statusLabel;
    private JComboBox status;
    private JLabel categoryLabel;
    private JComboBox category;
    private JLabel assignedToLabel;
    private JComboBox assignedTo;
    private JLabel descriptionLabel;
    private JTextArea description;
    private JLabel estimateTimeLabel;
    private JTextField estimateTime;
    private JLabel usedTimeLabel;
    private JTextField usedTime;
    private JButton btn1;
    private JButton btn2;

    private FormListener formListener;

    Controller controller = Controller.getController();

    public TaskFormPanel(MainFrame parent){
        Dimension dim = getPreferredSize();
        dim.width = 280;
        setPreferredSize(dim);
        setMinimumSize(dim);

        idNameLabel = new JLabel("Task Id: ");
        idLabel = new JLabel();
        statusLabel = new JLabel("Staus: ");
        assignedToLabel = new JLabel("Assigned To: ");
        descriptionLabel = new JLabel("Description: ");
        estimateTimeLabel = new JLabel("Estimated Time: ");
        usedTimeLabel = new JLabel("Used Time: ");
        categoryLabel = new JLabel("Category: ");

        category = new JComboBox();
        status = new JComboBox();
        assignedTo = new JComboBox();
        description = new JTextArea(8,10);
        estimateTime = new JTextField(4);
        usedTime = new JTextField(4);

        description.setLineWrap(true);

        btn1 = new JButton("New Task");
        btn2 = new JButton("Cancel");


        btn2.addActionListener(actionEvent -> setEmpty());

        btn1.addActionListener(actionEvent -> {

            int assigned = assignedTo.getSelectedIndex();
            int categoryId = category.getSelectedIndex();
            int statusId = status.getSelectedIndex();
            String desc = description.getText();
            int est = -1;
            int used = -1;
            try{
                est = Integer.parseInt(estimateTime.getText());
            } catch (NumberFormatException e){
                new JOptionPane("Estimated Time cannot be empty!");
            }
            try{
                used = Integer.parseInt(usedTime.getText());
            }catch (NumberFormatException e){
                new JOptionPane("Used Time cannot be empty!");
            }



            if(btn1.getText().equals("Update")){
                int id = Integer.parseInt(idLabel.getText());
                if(id > 0 && assigned > 0 && categoryId > 0 && statusId > 0 && est >= 0 && used >= 0){
                    try {
                        controller.updateTask(id, assigned, categoryId, statusId, desc, est, used);
                        parent.refreshTable();
                        setEmpty();

                    } catch (Exception e1) {
                        new JOptionPane("Update Error");
                        e1.printStackTrace();
                    }
                }
            }else{
                try{
                    int id = controller.getNextId();
                    if(id > 0 && assigned > 0 && categoryId > 0 && statusId > 0 && est >= 0 && used >= 0){

                        controller.addTask(id, assigned, categoryId, statusId,desc, est, used);
                        parent.refreshTable();
                        setEmpty();
                    }
                    System.out.println(id);
                } catch (Exception e){
                    new JOptionPane("New Task Error!");
                    e.printStackTrace();
                }
            }



        });



        // === Setup Status list ====
        List<String> statusList = controller.getStatusList();

        DefaultComboBoxModel statusListModel = new DefaultComboBoxModel();
        statusListModel.addElement("");
        for(String status : statusList){
            statusListModel.addElement(status);
        }
        status.setModel(statusListModel);
        status.setBorder(BorderFactory.createEtchedBorder());

        // === Setup Category Combobox ====

        List<String> categoryList = controller.getCategoryList();

        DefaultComboBoxModel categoryComboBoxModel = new DefaultComboBoxModel();
        categoryComboBoxModel.addElement("");
        for(String categoryitem : categoryList){
            categoryComboBoxModel.addElement(categoryitem);
        }
        category.setModel(categoryComboBoxModel);
        category.setBorder(BorderFactory.createEtchedBorder());

        // ==== Setup AssignedTo List ======
        List<Person> persons = controller.getPersons();

        DefaultComboBoxModel personListModel = new DefaultComboBoxModel();
        personListModel.addElement("");
        for(Person person : persons){
            personListModel.addElement(person);
        }
        assignedTo.setModel(personListModel);
        assignedTo.setBorder(BorderFactory.createEtchedBorder());

        Border innerBorder = BorderFactory.createTitledBorder("");
        Border outerBorder = BorderFactory.createEmptyBorder(3,3,3,3);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));


        layoutComponents();
    }

    public void setEmpty(){
        idLabel.setText("");
        status.getModel().setSelectedItem("");
        category.getModel().setSelectedItem("");
        assignedTo.getModel().setSelectedItem("");
        description.setText("");
        estimateTime.setText("");
        usedTime.setText("");
        btn1.setText("New Task");

    }

    public void layoutComponents(){


        GridBagLayout gridBagLayout = new GridBagLayout();
        JPanel gridPanel = new JPanel(gridBagLayout);
        JPanel flowPanel = new JPanel(new FlowLayout());

        //==== GRIDBAG LAYOUT - TOP PART OF THE FORM =========//

        Insets fiveRight = new Insets(3, 0, 0, 5);
        Insets noInsets = new Insets(3, 0, 0, 0);

        GridBagConstraints gc = new GridBagConstraints();

        // First row //
        gc.gridy = 0;

        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NORTHWEST;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(5,0,0,5);
        gridPanel.add(idNameLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(5,0,0,0);
        gridPanel.add(idLabel, gc);

        // second row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        gridPanel.add(statusLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        gridPanel.add(status, gc);

        // third row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        gridPanel.add(categoryLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        gridPanel.add(category, gc);

        // fourth row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        gridPanel.add(assignedToLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        gridPanel.add(assignedTo, gc);

        // fifth row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = fiveRight;
        gridPanel.add(descriptionLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = noInsets;
        gridPanel.add(new JScrollPane(description), gc);

        // sixth row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        gridPanel.add(estimateTimeLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        gridPanel.add(estimateTime, gc);

        // seventh row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        gridPanel.add(usedTimeLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        gridPanel.add(usedTime, gc);


        // next row //
        gc.gridy++;

        gc.weighty = 2;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        //add(btn1,gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
       // add(btn2,gc);

        flowPanel.add(btn1);
        flowPanel.add(btn2);


        add(gridPanel,BorderLayout.CENTER);
        add(flowPanel,BorderLayout.SOUTH);
    }


    @Override
    public void formEventOccured(FormEvent event) {
        idLabel.setText(Integer.toString(event.getId()));
        status.getModel().setSelectedItem(event.getStatusId());
        category.getModel().setSelectedItem(event.getCategory());
        assignedTo.getModel().setSelectedItem(event.getAssignedTo());
        description.setText(event.getDescription());
        estimateTime.setText(Integer.toString(event.getEstimateTime()));
        usedTime.setText(Integer.toString(event.getUsedTime()));

        btn1.setText("Update");
    }
}
