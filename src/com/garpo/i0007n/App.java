package com.garpo.i0007n;

import com.garpo.i0007n.view.MainFrame;

import javax.swing.*;

/**
 * Created by Conny Garpö on 4/23/2016.
 */
public class App {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
