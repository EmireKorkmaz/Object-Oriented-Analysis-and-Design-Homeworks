package com.emire;

import sun.awt.X11.XSystemTrayPeer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Individual{
    private int maxChromosomeValue;
    private int numOfChromosomes = 2;
    private int numOfGenes = 2;
    private double fitness;
    private HashMap<Integer, Chromosome> chromosomes = new HashMap<Integer, Chromosome>(); //2 tane kromozom olacak her birinde de 20 tane gen olacak

    public int bitsToInt(ArrayList<Integer> bits){
        int result=0;
        for(int i=bits.size()-1; i>=0; i--){
            result+= (int) Math.pow(2, bits.get(i));
        }
        return result;
    }
    public double getFitness(){
        int x1 = bitsToInt(this.chromosomes.get(1).getGenes());
        int x2 = bitsToInt(this.chromosomes.get(2).getGenes());
        double newX1 = (5 * x1) / (Math.pow(2, this.numOfGenes)-1);
        double newX2 = (5 * x2) / (Math.pow(2, this.numOfGenes)-1);

        double value = (20 * newX1 * newX2) + (16 * newX2) - 2 * ((int) Math.pow(newX1, 2)) - (int) Math.pow(newX2, 2) - (int) Math.pow(newX1 + newX2, 2);
        this.fitness = value;
        return value;
    }
    public Individual(Individual i){
        this.setChromosomes(i.getChromosomes());
        this.numOfGenes = i.numOfGenes;
        this.numOfChromosomes = i.numOfChromosomes;
        this.fitness = i.fitness;

    }
    public void setChromosomes(HashMap<Integer, Chromosome> chromosomes) {
        this.chromosomes = chromosomes;
    }

    public Individual() {
        this.createChromosomes();
        this.getFitness();
    }

    public void createChromosomes(){
            Chromosome c1 = new Chromosome();
            Chromosome c2 = new Chromosome();
            this.chromosomes.put(1, c1);
            this.chromosomes.put(2,c2);
            this.numOfGenes = c1.getNumOfGenes();
            this.maxChromosomeValue = (int) Math.pow(2, this.numOfGenes)-1;
    }

    public int getNumOfGenes() {
        return this.numOfGenes;
    }

    public int getNumOfChromosomes() {
        return this.numOfChromosomes;
    }

    public void printChromosomes(){
        for (Map.Entry<Integer, Chromosome> c:chromosomes.entrySet()) {
            c.getValue().printGenes();
        }
    }

    public HashMap<Integer, Chromosome> getChromosomes() {
        return this.chromosomes;
    }

}
