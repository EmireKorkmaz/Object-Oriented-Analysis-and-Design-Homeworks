package com.emire;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Chromosome {
    private int numOfGenes = 10;
    private ArrayList<Integer> genes=new ArrayList<Integer>();
    ArrayList<String> alphabet = new ArrayList<String>();
    Random random = new Random();

    public int getNumOfGenes() {
        return numOfGenes;
    }

    public ArrayList<Integer> getGenes() {
        return genes;
    }

    public Chromosome(){
        for (int i=0; i<numOfGenes; i++) {
            genes.add(random.nextInt(2));
        }
    }
    public void printGenes(){
        for (int i=0; i<numOfGenes; i++) {
            System.out.print(genes.get(i) + " ");
        }
        System.out.println("\n");
    }
}
