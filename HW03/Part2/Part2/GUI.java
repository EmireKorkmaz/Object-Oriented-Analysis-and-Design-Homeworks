package com.emire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class GUI implements ActionListener, Runnable {
    JFrame frame;

    @Override
    public void run() {
        GUI instance = new GUI();

        frame = new JFrame("DFT CALCULATOR");
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 100);

        JButton hello = new JButton("CANCEL");
        hello.setActionCommand(Actions.CANCEL.name());
        hello.addActionListener(instance);
        frame.add(hello);

        JButton goodbye = new JButton("RESTART");
        goodbye.setActionCommand(Actions.RESTART.name());
        goodbye.addActionListener(instance);
        frame.add(goodbye);

        JButton exit = new JButton("EXIT");
        exit.setActionCommand(Actions.EXIT.name());
        exit.addActionListener(instance);
        frame.add(exit);

        frame.setVisible(true);
    }

    private enum Actions {
        CANCEL,
        RESTART,
        EXIT
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand() == Actions.CANCEL.name()) {
            MyThread.t1.stop();
            MyThread.t2.stop();
            MyThread.t3.stop();
            MyThread.t4.stop();
            Addition.semaphore.release();
            Thread.currentThread().interrupt();
            JOptionPane.showMessageDialog(new JFrame(), "PLEASE RESTART OR EXIT");

        } else if (evt.getActionCommand() == Actions.RESTART.name()) {
            try {
                Main.initiate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else if (evt.getActionCommand() == Actions.EXIT.name()) {
            System.out.println("Exitting...");
            System.exit(0);
        }
    }
}