package com.emire;

import java.util.ArrayList;

public class Population {
    private int size;
    ArrayList<Individual> people = new ArrayList<Individual>();
    ArrayList<Individual> selectedPeople = new ArrayList<Individual>();

    public Population(int s){
        this.size=s;
        for (int i=0; i<size; i++) {
            Individual ind = new Individual();
            people.add(ind);
        }
    }
    public void printAllGenes(){
        for(int i=0; i<this.size; i++){
            people.get(i).printChromosomes();
        }
    }

    public double getHighestFitness(){
        double max = 0.0;

        for (Individual i:people ) {
            if(max<i.getFitness())
                max = i.getFitness();
        }
        return max;
    }

}
