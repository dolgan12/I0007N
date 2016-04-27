package com.garpo.i0007n.view.mainframecomponents;

import com.garpo.i0007n.controll.Controller;
import com.garpo.i0007n.model.Person;
import com.garpo.i0007n.view.FormEvent;
import com.garpo.i0007n.view.FormListener;

import javax.swing.*;
import java.util.ArrayList;
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
    private JButton okBtn;

    private FormListener formListener;

    Controller controller = Controller.getController();

    public TaskFormPanel(){
        Dimension dim = getPreferredSize();
        dim.width = 250;
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
        description = new JTextArea(10,10);
        estimateTime = new JTextField(5);
        usedTime = new JTextField(5);

        okBtn = new JButton("OK");

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




        layoutComponents();
    }

    public void layoutComponents(){
        setLayout(new GridBagLayout());

        Insets fiveRight = new Insets(0, 0, 0, 5);
        Insets noInsets = new Insets(0, 0, 0, 0);

        GridBagConstraints gc = new GridBagConstraints();

        // First row //
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        add(idNameLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        add(idLabel, gc);

        // second row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        add(statusLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        add(status, gc);

        // third row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        add(categoryLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        add(category, gc);

        // fourth row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        add(assignedToLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        add(assignedTo, gc);

        // fifth row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = fiveRight;
        add(descriptionLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = noInsets;
        add(description, gc);

        // sixth row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        add(estimateTimeLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        add(estimateTime, gc);

        // seventh row //
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = fiveRight;
        add(usedTimeLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = noInsets;
        add(usedTime, gc);

    }


    @Override
    public void formEventOccured(FormEvent event) {
        System.out.println("event");
        idLabel.setText(Integer.toString(event.getId()));
        status.getModel().setSelectedItem(event.getStatusId());
        category.getModel().setSelectedItem(event.getCategory());
        assignedTo.getModel().setSelectedItem(event.getAssignedTo());
        description.setText(event.getDescription());
        estimateTime.setText(Integer.toString(event.getEstimateTime()));
        usedTime.setText(Integer.toString(event.getUsedTime()));
    }
}
