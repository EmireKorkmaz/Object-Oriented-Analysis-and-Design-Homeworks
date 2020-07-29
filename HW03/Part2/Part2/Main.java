package com.emire;

import javax.swing.*;

public class Main {
    public static Thread th1, th2;
    public static void gui(MyThread m){
        String num1, num2, num3;
        int threads, size, choice;

        num1 = JOptionPane.showInputDialog("Number of threads?");
        threads = Integer.parseInt(num1);

        num2 = JOptionPane.showInputDialog("Matrix size?");
        size = Integer.parseInt(num2);

        num3 = JOptionPane.showInputDialog("Choice of synchronization? (1 or 2)");
        choice = Integer.parseInt(num3);

        if(!(choice== 1 || choice==2)){
            JOptionPane.showMessageDialog(new JFrame(), "Wrong choice! It should have been 1 or 2");
             System.exit(0);
        }

        m.setter(size, choice, threads);
    }


    public static void main(String[] args) throws InterruptedException {
        initiate();
    }

    public static void initiate() throws InterruptedException {
        MyThread mt = new MyThread();
        GUI g = new GUI();
        mt.setter(4,4,4);
        th1 = new Thread(mt);
        th2 = new Thread(new GUI());
        gui(mt);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }
}