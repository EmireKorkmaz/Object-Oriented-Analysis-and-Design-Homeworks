package com.emire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class MySort implements Comparator<Individual>
{

    @Override
    public int compare(Individual ind1, Individual ind2) {
        int retVal = 0;
        if(ind1.getFitness() > ind2.getFitness())
            retVal = 1;
        else if(ind1.getFitness() == ind2.getFitness())
            retVal = 0;
        else if(ind1.getFitness() < ind2.getFitness())
            retVal = -1;

        return retVal;
    }
}


public class Version2 extends Genetics {
    Random random = new Random();
    ArrayList<Individual> selectedOnes = new ArrayList<Individual>();
    Population population = new Population(1);

    public Version2(Population p) {
        this.population = p;
    }

    @Override
    public ArrayList<Individual> selection(ArrayList<Individual> people) {
        ArrayList<Individual> temp = new ArrayList<>();

        for (Individual ind: people)
            temp.add(new Individual(ind));

        Collections.sort(temp, new MySort());

        selectedOnes.add(temp.get(0));
        selectedOnes.add(temp.get(1));

        return selectedOnes;
    }

    @Override
    public ArrayList<Individual> crossover(Individual i1, Individual i2) {
        ArrayList<Individual> children = new ArrayList<Individual>();
        int index1 = random.nextInt(i1.getNumOfGenes()); // index to be changed
        int index2 = random.nextInt(i1.getNumOfGenes());

        // stores first elements' related values for swapping
        int temp1 = i1.getChromosomes().get(1).getGenes().get(index1);
        int temp2 = i1.getChromosomes().get(2).getGenes().get(index1);
        int temp3 = i1.getChromosomes().get(1).getGenes().get(index2);
        int temp4 = i1.getChromosomes().get(2).getGenes().get(index2);

        // swapping indices a.k.a crossover
        i1.getChromosomes().get(1).getGenes().set(index1, i2.getChromosomes().get(1).getGenes().get(index1));
        i1.getChromosomes().get(2).getGenes().set(index1, i2.getChromosomes().get(2).getGenes().get(index1));
        i2.getChromosomes().get(1).getGenes().set(index1, temp1);
        i2.getChromosomes().get(2).getGenes().set(index1, temp2);

        i1.getChromosomes().get(1).getGenes().set(index2, i2.getChromosomes().get(1).getGenes().get(index2));
        i1.getChromosomes().get(2).getGenes().set(index2, i2.getChromosomes().get(2).getGenes().get(index2));
        i2.getChromosomes().get(1).getGenes().set(index2, temp3);
        i2.getChromosomes().get(2).getGenes().set(index2, temp4);

        children.add(i1);
        children.add(i2);
        return children;
    }

    public double computeFitness(){
        double total = 0;
        for(Individual i : population.people){
            total += i.getFitness();
        }
        return total;
    }
}
