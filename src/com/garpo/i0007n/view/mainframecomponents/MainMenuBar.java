package com.garpo.i0007n.view.mainframecomponents;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Conny Garpö on 4/23/2016.
 */
public class MainMenuBar extends JMenuBar{

    public MainMenuBar(JFrame frame) {
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");

        // add the fileMenu to the bar
        add(fileMenu);
        //add items to the fileMenu
        fileMenu.addSeparator();
        fileMenu.add(exitItem);




        /**
         * ====== Menu items event listeners ============
         */
        exitItem.addActionListener(event -> {
                int action = JOptionPane.showConfirmDialog(frame,"Are you sure?", "Exit", JOptionPane.OK_CANCEL_OPTION);
                if(action == JOptionPane.OK_OPTION){
                    WindowListener[] listeners = frame.getWindowListeners();

                    for(WindowListener listener : listeners){
                        listener.windowClosing(new WindowEvent(frame,0));
                    }
                }
        });


        /**
         *  ====== Menu items Accelerators & Mnemonics =====
         */
        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    }
}
