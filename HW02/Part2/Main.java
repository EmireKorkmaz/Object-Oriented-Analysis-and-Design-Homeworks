package com.emire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;



class MyThread extends Thread{
    private int v;
    private Thread t;
    Genetics version;
    static double fitness;
    int i;

    public  MyThread(int v){
        this.v = v;
    }

    public void run(){

    }

    public void start () {
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }

}



public class Main extends JPanel {
    static int x1, x2, x3, a, i=0, j=0, k=0;
    static double y1, y2, y3;
    int firstCounter=100, secondCounter=100, thirdCounter=100;
    static boolean exit = false;

    JButton b = new JButton("START");

    JFrame f = new JFrame();
    public void foo(int a) {
        this.a = a;
        f.setSize(400, 400);
        f.add(new Main());
        f.add(b);
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 150,20);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Welcome to Javatpoint.");
            }
        });
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] a) {
        Main m = new Main();
        MyThread mt1 = new MyThread(1){
            @Override
            public void run(){
                m.foo(1);
            }
        };
        MyThread mt2 = new MyThread(2){
            @Override
            public void run(){
                m.foo(2);
            }
        };
        MyThread mt3 = new MyThread(3){
            @Override
            public void run(){
                m.foo(3);
            }
        };
        mt1.start();
        mt2.start();
        mt3.start();
    }
    public void paint(Graphics g) {
        int m = 0;
        while(!exit){
            if (a == 1) {
                Population population = new Population(100);
                double fitness = 0.0;
                int i = 0;
                System.out.println("======================================================\nVERSION 1");

                Genetics version = new Version1(population);
                System.out.println(population.getHighestFitness());

                while (i < 75) {
                    fitness = version.computeFitness();
                    System.out.println("loop: " + i + " fitness: " + fitness + "\n");
                    g.setColor(Color.YELLOW);
                    g.fillRect (i, (int) fitness, 5, 5);

                    ArrayList<Individual> selectedOnes = version.selection(population.people);
                    ArrayList<Individual> children = version.crossover(new Individual(selectedOnes.get(0)), new Individual(selectedOnes.get(1)));

                    Individual individual1 = version.mutation(children.get(0));
                    Individual individual2 = version.mutation(children.get(1));

                    if (individual1 != null) {
                        for (Individual ind : population.people) {
                            if (selectedOnes.get(0) == ind) {
                                population.people.remove(ind);
                                population.people.add(individual1);
                                break;
                            }
                        }
                    }
                    if (individual2 != null) {
                        for (Individual ind : population.people) {
                            if (selectedOnes.get(1).equals(ind)) {
                                population.people.remove(selectedOnes.get(1));
                                population.people.add(individual2);
                                break;
                            }
                        }
                    }
                    i++;
                }

            }
            else if(a==2){
                while(j<secondCounter){

                    double fitness = 0.0;
                    int i = 0;
                    System.out.println("======================================================\nVERSION 2");
                    Main m2 = new Main();
                    Population population2 = new Population(100);
                    System.out.println(population2.getHighestFitness());
                    Genetics version = new Version1(population2);
                    version = new Version2(population2);

                    while (i < 50) {
                        fitness = version.computeFitness();
                        System.out.println("loop: " + i + " fitness: " + fitness + "\n");

                        g.setColor(Color.BLUE);
                        g.fillRect (i, (int) fitness, 5, 5);

                        ArrayList<Individual> selectedOnes = version.selection(population2.people);
                        ArrayList<Individual> children = version.crossover(selectedOnes.get(0), selectedOnes.get(1));

                        Individual individual1 = version.mutation(children.get(0));
                        Individual individual2 = version.mutation(children.get(1));

                        if (individual1 != null) {
                            for (Individual ind : population2.people) {
                                if (selectedOnes.get(0) == ind) {
                                    population2.people.remove(ind);
                                    population2.people.add(individual1);
                                    break;
                                }
                            }
                        }
                        if (individual2 != null) {
                            for (Individual ind : population2.people) {
                                if (selectedOnes.get(1).equals(ind)) {
                                    population2.people.remove(selectedOnes.get(1));
                                    population2.people.add(individual2);
                                    break;
                                }
                            }
                        }
                        i++;
                    }
                }
            }
            else if(a==3){
                double fitness = 0.0;
                int i = 0;
                System.out.println("======================================================\nVERSION 3");
                Main m3 = new Main();
                Population population3 = new Population(100);
                Genetics version = new Version1(population3);

                System.out.println(population3.getHighestFitness());

                version = new Version3(population3);

                while (i< 190) {
                    fitness = version.computeFitness();
                    System.out.println("loop: " + i + " fitness: " + (int)fitness + "\n");
                    g.setColor(Color.RED);
                    g.fillRect (i,(int) fitness, 5, 5);
                    ArrayList<Individual> selectedOnes = version.selection(population3.people);
                    ArrayList<Individual> children = version.crossover(selectedOnes.get(0), selectedOnes.get(1));

                    Individual individual1 = version.mutation(children.get(0));
                    Individual individual2 = version.mutation(children.get(1));

                    if (individual1 != null) {
                        for (Individual ind : population3.people) {
                            if (selectedOnes.get(0) == ind) {
                                population3.people.remove(ind);
                                population3.people.add(individual1);
                                break;
                            }
                        }
                    }
                    if (individual2 != null) {
                        for (Individual ind : population3.people) {
                            if (selectedOnes.get(1).equals(ind)) {
                                population3.people.remove(selectedOnes.get(1));
                                population3.people.add(individual2);
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

}

