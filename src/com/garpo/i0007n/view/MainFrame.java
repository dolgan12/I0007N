package com.garpo.i0007n.view;

import com.garpo.i0007n.controll.Controller;
import com.garpo.i0007n.view.mainframecomponents.TaskFormPanel;
import com.garpo.i0007n.view.mainframecomponents.MainMenuBar;
import com.garpo.i0007n.view.mainframecomponents.TaskTabelPanel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

/**
 * Created by Conny Garpö on 4/23/2016.
 */
public class MainFrame extends JFrame{

    private MainMenuBar menuBar;
    private TaskTabelPanel taskTabelPanel;
    private JSplitPane splitPane;
    private TaskFormPanel taskFormPanel;

    /**
     *  Constructor to create the main window of the application
     */
    public MainFrame(){
        super("Fiktivt AB - Ärende System");

        // Using the nimbus Look and feel to make the windows look better.
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Controller controller = Controller.getController();
        // MainFrame Layout

        setLayout(new BorderLayout());

        menuBar = new MainMenuBar(this);
        setJMenuBar(menuBar);

        taskFormPanel = new TaskFormPanel();
        taskTabelPanel = new TaskTabelPanel();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,taskFormPanel, taskTabelPanel);
        splitPane.setEnabled(false);


        try {
            taskTabelPanel.setData(controller.getTasks());
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Add event listener //
        taskTabelPanel.setFormListener(taskFormPanel);

        add(splitPane, BorderLayout.CENTER);
        // Set the Options of the Main window
        Dimension size = new Dimension(800,600);
        setMinimumSize(size);
        setSize(size);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);


        /**
         *   ==========  MAIN WINDOW EVENT LISTENERS ============
         */
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);

            }

            public void windowClosing(WindowEvent e) {
                try {
                    controller.closeDb();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                dispose();
            }
        });

    }
}
