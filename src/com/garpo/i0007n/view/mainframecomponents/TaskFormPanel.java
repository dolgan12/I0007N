package com.garpo.i0007n.view.mainframecomponents;

import com.garpo.i0007n.controll.Controller;
import com.garpo.i0007n.model.Person;
import com.garpo.i0007n.controll.FormEvent;
import com.garpo.i0007n.view.FormListener;

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

    public TaskFormPanel(){
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

        btn1 = new JButton("Update");
        btn2 = new JButton("Cancel");

        btn1.setVisible(false);
        btn2.setVisible(false);

        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                idLabel.setText("");
                status.getModel().setSelectedItem("");
                category.getModel().setSelectedItem("");
                assignedTo.getModel().setSelectedItem("");
                description.setText("");
                estimateTime.setText("");
                usedTime.setText("");

                btn1.setVisible(false);
                btn2.setVisible(false);
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

        Border innerBorder = BorderFactory.createTitledBorder("Task");
        Border outerBorder = BorderFactory.createEmptyBorder(3,3,3,3);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));


        layoutComponents();
    }

    public void layoutComponents(){


        GridBagLayout gridBagLayout = new GridBagLayout();

        //==== GRIDBAG LAYOUT - TOP PART OF THE FORM =========//

        setLayout(gridBagLayout);

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
        gc.insets = new Insets(10,0,0,5);
        add(idNameLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(10,0,0,0);
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
        add(new JScrollPane(description), gc);

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


        // next row //
        gc.gridy++;

        gc.weighty = 2;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(btn1,gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(btn2,gc);


        // Last row to add space at bottom of form.
        /*
        gc.gridy++;
        gc.weighty = 2;
        gc.weighty = 1;
        add(new JLabel(""), gc);
        */

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

        btn1.setVisible(true);
        btn2.setVisible(true);
    }
}
