package com.garpo.i0007n.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Conny Garpö on 4/28/2016.
 */
public class ClickListener extends MouseAdapter implements ActionListener{

    // Get how fast a double click is from the OS.
    private final static int clickInterval = (Integer) Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval");

    MouseEvent lastEvent;
    Timer timer;

    public ClickListener(){
        this(clickInterval);
    }
    public ClickListener(int delay){
        timer = new Timer(delay, this);
    }

    public void mouseClicked(MouseEvent event){
        if(event.getClickCount() > 2) return;

        lastEvent = event;
        if(timer.isRunning()){
            timer.stop();
            doubleClick(lastEvent);
        }else {
            timer.restart();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        singleClick(lastEvent);
    }

    public void singleClick(MouseEvent event){
    }
    public void doubleClick(MouseEvent event){}
}
