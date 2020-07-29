package com.emire;

/**
 * @author Emire Korkmaz
 */


import java.util.ArrayList;

public class Equations {

    private SolvingMethods methods;

    /**
     * Constructor
     * @param methods Denklemin hangi metot ile cozulecegini tutar
     */

    Equations(SolvingMethods methods){
        this.methods = methods;
    }
    /**
     * Bu method, linear denklemin koklerini bulur.
     * @param a Denklemin katsayilarindan olusan matris
     * @param b Denklemin sag tarafının olusturdugu matris
     * @return Denklemin koklerinin bulundugu matris
     */

    public double [] solveEquations(Double a[][], ArrayList<Double> b){
        return methods.solve(a,b);
    }
}
