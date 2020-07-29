package com.emire;

/**
 * @author Emire Korkmaz
 */

import javax.swing.*;
import java.util.ArrayList;

public class MatrixInversion implements SolvingMethods {

    /**
     * Bu method, linear denklemin koklerini bulur.
     * @param a Denklemin katsayilarindan olusan matris
     * @param b Denklemin sag tarafının olusturdugu matris
     * @return Denklemin koklerinin bulundugu matris
     */
    @Override
    public double[] solve(Double[][] a, ArrayList<Double> b) {
        Double [][] inv;
        double[] sol = null;

        inv = inverseMatrix(a);
        if(inv != null){
            sol = matrixMultiplication(inv,b);
        }

        return sol;
    }

    /**
     * Bu method, iki matrisin carpimini hesaplar.
     * @param a İki boyutlu bir matris
     * @param b Tek boyutlu bir matris
     * @return İki matrisin carpiminin sonucu
     */

    private double[] matrixMultiplication(Double[][] a, ArrayList<Double> b){
        int rowSizeA = a.length;
        int colSizeA = a[0].length;
        int rowSizeB = b.size();
        double[] result = new double[rowSizeA];
        if(colSizeA != rowSizeB) {
            JOptionPane.showMessageDialog(null,"This system is not solved. Because illegal matrix multiplication.");
            return null;
        }
        else{
            for (int i = 0; i < rowSizeA; i++){
                for(int k = 0; k < rowSizeB; k++)
                    result[i] += a[i][k] * b.get(k);
                }
            }
        return result;
    }

    /**
     * Bu method, verilen matrisin tersini bulur.
     * @param matrix İki boyutlu bir matris
     * @return Verilen matrisin tersi
     */

    private Double[][]  inverseMatrix(Double[][] matrix){
        Double division = 0.0;
        Double coefficient = 0.0;
        Double [][] invMatrix = new Double[matrix.length][];
        double result = determinantMatrix(matrix);
        if(result == 0){
            JOptionPane.showMessageDialog(null,"This matrix have not inverse. Because determinant of this matrix is zero." +
                    "This system have no unique solution.");
            return null;
        }
        else{
            for(int i = 0; i < matrix.length; i++)
                invMatrix[i] = new Double[matrix.length];
            for (int i = 0; i < matrix.length; i++){ // Birim matrisin oluşturulması
                for (int j = 0; j < matrix.length; j++){
                    if(i == j)
                        invMatrix[i][j] = 1.0;
                    else
                        invMatrix[i][j] = 0.0;
                }
            }
            for (int i = 0; i < matrix.length; i++){
                division = matrix[i][i];
                for(int j = 0; j < matrix.length; j++){
                    matrix[i][j] = matrix[i][j] / division;
                    invMatrix[i][j] = invMatrix[i][j] / division;
                }
                for(int k = 0; k < matrix.length; k++){
                    if(k != i){
                        coefficient = matrix[k][i];
                        for(int j = 0; j < matrix.length; j++){
                            matrix[k][j] = matrix[k][j] - (matrix[i][j] * coefficient);
                            invMatrix[k][j] = invMatrix[k][j] - (invMatrix[i][j] * coefficient);
                        }
                    }
                }
            }
        }
        return invMatrix;
    }

    /**
     * Bu method, verilen matrisin determinantini hesaplar.
     * @param matrix İki boyutlu bir matris
     * @return Verilen matrisin determinanti
     */

    private double determinantMatrix(Double[][] matrix){
        if(matrix.length == 1){
            return matrix[0][0];
        }
        else if(matrix.length == 2){
            return ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
        }
        Double[][] temp = new Double[matrix.length][];
        double ratio, result;
        for (int i = 0; i < matrix.length; i++)
            temp[i] = new Double[matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                temp[i][j] = matrix[i][j];
            }
        }
        for (int j = 0; j < matrix.length - 1; j++){
            if(temp[j][j] == 0.0){
                swapRows(temp,j,j+1);
            }
            for(int i = j + 1; i< matrix.length; i++){
                ratio = temp[i][j] / temp[j][j];
                for(int k = j; k < matrix.length; k++){
                    temp[i][k] -= ratio * temp[j][k];
                }
            }
        }
        result = 1;
        for (int i = 0; i < matrix.length; i++){
            result *= temp[i][i];
        }
        return result;
    }

    /**
     * Bu method verilen satirlari birbiri ile degistirir.
     * @param matrix Iki boyutlu bir matris
     * @param row1 Verilen ilk satir
     * @param row2 Verilen ikinci satir
     */

    private void swapRows(Double[][] matrix, int row1, int row2){
        double temp;
        for (int j = 0; j < matrix.length; j++){
            temp = matrix[row1][j];
            matrix[row1][j] = matrix[row2][j];
            matrix[row2][j] = temp;
        }
    }
}
