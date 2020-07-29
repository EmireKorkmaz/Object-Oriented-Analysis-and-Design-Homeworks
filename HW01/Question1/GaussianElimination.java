package com.emire;

/**
 * @author Emire Korkmaz
 */


import javax.swing.*;
import java.util.ArrayList;

public class GaussianElimination implements SolvingMethods {

    //Data Fields
    private ArrayList<Double> scaled; // Scaled Matrisi

    /**
     * Scaled matrisini olusturur
     */

    public GaussianElimination(){
        scaled = new ArrayList<>();
    }

    /**
     * Bu method verilen satirlari birbiri ile degistirir.
     * @param a A matrisi
     * @param b B matrisi
     * @param row1 Verilen ilk satir
     * @param row2 Verilen ikinci satir
     * @param n B matrisinin eleman sayisi
     */

    private void swapRow(Double a[][], ArrayList<Double> b, int row1, int row2, int n){
        double temp;
        // B matrisinin satirlarinin yer degistirilmesi
        temp = b.get(row1);
        b.set(row1,b.get(row2));
        b.set(row2,temp);
        // Scaled matrisinin satirlarinin yer degistirilmesi
        temp = scaled.get(row1);
        scaled.set(row1,scaled.get(row2));
        scaled.set(row2,temp);
        //A matrisinin satirlarinin yer degistirilmesi
        for(int j=0; j<n; j++){
            temp = a[row1][j];
            a[row1][j] = a[row2][j];
            a[row2][j] = temp;
        }
    }

    /**
     * Bu method scaled matrisini olusturur
     * @param a A matrisi
     * @param size A matrisinin toplam satir sayisi
     */

    private Object scaledMatrix(Double a[][], int size){
        // Satir olarak mutlakca en buyuk elemanin bulunmasi
        for(int i=0; i<size; i++){
            double max = Math.abs(a[i][0]);
            for(int j=1; j<size; j++){
                if (Math.abs(a[i][j]) > max){
                    max = Math.abs(a[i][j]);
                }
            }
            scaled.add(max); // En buyuk elemanin scaled matrisine eklenmesi
        }
        // Eger scaled matrisinin icersinde 0.0 degerinin olmasi
        for(int i=0; i<scaled.size(); i++) {
            if (scaled.get(i).equals(0.0)) {
                JOptionPane.showMessageDialog(null,"This system have no unique solution!");
                return null;
            }
        }
        return size;
    }

    /**
     * Bu method, linear denklemin koklerini bulur.
     * @param a Denklemin katsayilarindan olusan matris
     * @param b Denklemin sag tarafının olusturdugu matris
     * @return Denklemin koklerinin bulundugu matris
     */
    @Override
    public double[] solve(Double a[][], ArrayList<Double>b){
        int size = b.size();
        int maxRow = 0;
        if (scaledMatrix(a,size) != null){ // Scaled matrisinin olusturulmasi
            for(int j=0; j<size; j++){
                double max = a[0][j] / scaled.get(0);
                for(int i=1; i<size; i++){
                    if(a[i][j] / scaled.get(i) > max){
                        maxRow = i;
                    }
                }
                // Satirlarin yer degistirilmesi
                swapRow(a,b,j,maxRow,size);
                // Gauss elimination
                for (int i = j + 1; i < size; i++) {
                    double alpha = a[i][j] / a[j][j];
                    b.set(i,b.get(i) - (alpha * b.get(j)));
                    for (int k = j; k < size; k++) {
                        a[i][k] -= alpha * a[j][k];
                    }
                }
            }
            //Back Substitution
            double[] x = new double[size];
            for (int i = size - 1; i >= 0; i--) {
                double sum = 0.0;
                for (int j = i + 1; j < size; j++) {
                    sum += a[i][j] * x[j];
                }
                x[i] = (b.get(i) - sum) / a[i][i];
            }
            return x;
        }
        else
            return null;
    }
}
