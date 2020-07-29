package com.emire;

public class DFT {
    public static Complex[][] computeDft(Complex[][] matrix) {
        int n = matrix.length;
        Complex[][] out = new Complex[n][n];

        for(int i=0; i<n; i++) {
            for (int k = 0; k < n; k++) {
                double sumreal = 0;
                double sumimag = 0;
                for (int t = 0; t < n; t++) {
                    double angle = 2 * Math.PI * t * k / n;
                    sumreal += matrix[i][t].getReal() * Math.cos(angle) + matrix[i][t].getIm() * Math.sin(angle);
                    sumimag += -matrix[i][t].getReal() * Math.sin(angle) + matrix[i][t].getIm() * Math.cos(angle);
                }
                out[i][k]= new Complex(sumreal, sumimag);
            }
        }
        return out;
    }
}