package com.emire;

/**
 * @author Emire Korkmaz
 */


import java.util.ArrayList;

public interface SolvingMethods {

    /**
     * Bu method, linear denklemin koklerini bulur.
     * @param a Denklemin katsayilarindan olusan matris
     * @param b Denklemin sag tarafının olusturdugu matris
     * @return Denklemin koklerinin bulundugu matris
     */
    double[] solve(Double a[][], ArrayList<Double> b);
}
