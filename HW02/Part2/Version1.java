package com.emire;

import com.sun.java.swing.plaf.windows.WindowsTextUI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Version1 extends Genetics {
    private int totalFitness = 0;
    Random random = new Random();
    Population p = new Population(1);
    ArrayList<Individual> selectedOnes = new ArrayList<Individual>();


    @Override
    public ArrayList<Individual> selection(ArrayList<Individual> people) {
        Individual i1 = selectionHelper(people,null);
        Individual i2 = selectionHelper(people,i1);

        selectedOnes.add(i1);
        selectedOnes.add(i2);

        return selectedOnes;
    }

    public Individual selectionHelper(ArrayList<Individual> people, Individual previous){
        int totalSum = 0,  sum = 0;
        for (Individual i : people) {
            totalSum += i.getFitness();
        }

        int r = random.nextInt(totalSum);

        for (Individual i: people) {
            sum += i.getFitness();
            if(sum>= r && !i.equals(previous)){
                return new Individual(i);
            }
        }
        return new Individual(people.get(0));
    }

    public Version1(Population p) {
        this.p = p;
    }

    // uses one point crossover
    @Override
    public ArrayList<Individual> crossover(Individual i1, Individual i2) {
        ArrayList<Individual> children = new ArrayList<Individual>();
        int index = random.nextInt(i1.getNumOfGenes()); // index to be changed

        // stores first elements related values for swapping
        int temp1 = i1.getChromosomes().get(1).getGenes().get(index);
        int temp2 = i1.getChromosomes().get(2).getGenes().get(index);

        // swapping indices a.k.a crossover
        i1.getChromosomes().get(1).getGenes().set(index, i2.getChromosomes().get(1).getGenes().get(index));
        i1.getChromosomes().get(2).getGenes().set(index, i2.getChromosomes().get(2).getGenes().get(index));
        i2.getChromosomes().get(1).getGenes().set(index, temp1);
        i2.getChromosomes().get(2).getGenes().set(index, temp2);

        children.add(i1);
        children.add(i2);
        return children;
    }

    public double computeFitness(){
        double total = 0;
        for(Individual i : p.people){
            total += i.getFitness();
        }
        return total;
    }
}
