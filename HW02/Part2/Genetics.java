package com.emire;

import java.util.ArrayList;
import java.util.Random;

public abstract class Genetics {
    public abstract ArrayList<Individual> selection(ArrayList<Individual> people);
    public abstract ArrayList<Individual> crossover(Individual i1, Individual i2);

    public Individual mutation(Individual i){
        Random random = new Random();
        int num = random.nextInt(10);
        int index1 = random.nextInt(i.getNumOfGenes());
        int index2 = random.nextInt(i.getNumOfGenes());
        if(num < i.getNumOfGenes()){
            int temp1 = i.getChromosomes().get(1).getGenes().get(index1);
            int temp2 = i.getChromosomes().get(2).getGenes().get(index2);
            int t1 = (temp1 == 1 ? 0 : 1);
            int t2 = (temp2 == 1 ? 0 : 1);
            i.getChromosomes().get(1).getGenes().set(index1, t1);
            i.getChromosomes().get(2).getGenes().set(index2, t2);

            return i;
        }
        return i;
    }

    public int bitsToInt(ArrayList<Integer> bits){
        int result=0;
        for(int i=0; i<bits.size(); i++){
            result+= (int) Math.pow(2, bits.get(i));
        }
        return result;
    }
    public double computeFitness(){
        //todo
        return 0.0;
    }

}
