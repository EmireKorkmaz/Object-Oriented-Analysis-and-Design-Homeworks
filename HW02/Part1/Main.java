package com.emire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) {
        Population population = new Population(100);
        double fitness=0.0;
        int i=0;

        System.out.println("======================================================\nVERSION 1");

        Genetics version = new Version1(population);
        System.out.println(population.getHighestFitness());

        while (i<75) {
            fitness = version.computeFitness();
            System.out.println("Generation: "+ i + " fitness: " + fitness + "\n");

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
        System.out.println("======================================================\nVERSION 2");

        Population population2 = new Population(100);
        System.out.println(population2.getHighestFitness());
        version = new Version2(population2);

        i = 0;
        while (i<50) {
            fitness = version.computeFitness();
            System.out.println("Generation: " + i + " fitness: " + fitness + "\n");

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

        System.out.println("======================================================\nVERSION 3");

        Population population3 = new Population(100);

        System.out.println(population3.getHighestFitness());

        version = new Version3(population3);
        i = 0;

        while (i<150) {
            fitness = version.computeFitness();
            System.out.println("Generation: " + i + " fitness: " + fitness + "\n");

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
