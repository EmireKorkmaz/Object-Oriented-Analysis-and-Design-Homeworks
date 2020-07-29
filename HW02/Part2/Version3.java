package com.emire;

import java.util.ArrayList;
import java.util.Random;

public class Version3 extends Genetics {
    Population population = new Population(1);
    private int totalFitness = 0;
    Random random = new Random();
    ArrayList<Individual> selectedOnes = new ArrayList<Individual>();

    @Override
    public ArrayList<Individual> selection(ArrayList<Individual> people) {

        ArrayList<Individual> tempPeople = people;

        Individual best1 = selectionHelper(tempPeople);
        tempPeople.remove(best1);
        Individual best2 = selectionHelper(tempPeople);

        selectedOnes.add(best1);
        selectedOnes.add(best2);

        return selectedOnes;
    }

    private Individual selectionHelper(ArrayList<Individual> people){
        ArrayList<Individual> randomList = new ArrayList<Individual>();
        ArrayList<Integer> indices = new ArrayList<Integer>();

        int k = random.nextInt(people.size());

        for (int i=0; i<k; i++)
            indices.add(random.nextInt(people.size()));

        for(Integer index: indices)
            randomList.add(people.get(index));

        double maxFitness = 0.0;
        Individual best = new Individual();
        for (Individual ind: randomList) {
            if(maxFitness < ind.getFitness()) {
                maxFitness =  ind.getFitness();
                best = ind;
            }
        }
        return new Individual(best);
    }

    public Version3(Population p) {
        this.population = p;
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
        for(Individual i : population.people){
            total += i.getFitness();
        }
        return total;
    }
}
