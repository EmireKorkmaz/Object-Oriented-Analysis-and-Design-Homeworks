package com.emire;

import javax.swing.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;

public class Addition implements Runnable{
    public static int jobs = 0;
    int c;
    public static Semaphore semaphore = new Semaphore(1, true);
    public Complex [][] A, B, R;
    public Addition(Complex[][] quarterA, Complex[][] quarterB) {
        this.A = quarterA;
        this.B = quarterB;
    }

    public void setC(int c){
        this.c = c;
    }

    public void setR(Complex[][] quarter){
        this.R = quarter;
    }

    @Override
    public synchronized void run() {
        if(c==1){
            JOptionPane.showMessageDialog(new JFrame(), "COULDN'T IMPLEMENT IT. PLEASE EXIT OR RETRY WITH THE OTHER OPTION.");
        }
        else if(c==2){
            try {
                synchronized(this){
                    semaphore.acquire();
                    for(int x=0; x< A.length; x++) {
                        for (int y = 0; y < A.length; y++) {
                            A[x][y].add(B[x][y]);
                        }
                    }
                    jobs++;
                    semaphore.release();
                    MyThread.barrier.await();

                    if(jobs==4){
                        MyThread.done=true;
                        jobs=0;
                    }

                    MyThread.barrier.await();
                    if(jobs==4){
                        MyThread.done=true;
                    }
                    semaphore.acquire();
                    DFT dft = new DFT();
                    this.R = dft.computeDft(R);
                    jobs++;
                    semaphore.release();
                    MyThread.barrier.await();
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public Complex[][] getA (){
        return this.A;
    }
    public Complex[][] getDFT (){
        return this.R;
    }
    public void print(Complex[][] m){
        for(int x=0; x<m.length; x++) {
            for (int y = 0; y < m.length; y++) {
                System.out.print(m[x][y]+"    ");
            }
            System.out.println();
        }
    }
    public String toString(Complex[][] result){
        StringBuilder sbResult = new StringBuilder();

        for(int i = 0; i < result.length;i++)
        {
            for(int j = 0; j < result.length;j++)
            {
                sbResult.append(result[i][j]);
                sbResult.append("\t");
            }
            sbResult.append("\n");
        }

        return sbResult.toString();
    }
}