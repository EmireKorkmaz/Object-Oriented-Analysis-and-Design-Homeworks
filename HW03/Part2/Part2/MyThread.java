package com.emire;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable
{
    public static Thread t1, t2, t3, t4;
    public static CyclicBarrier barrier = new CyclicBarrier(5);
    public static volatile boolean done = false;
    int whole, choice, numOfThreads;

    public void setter(int size, int c, int t){
        this.whole = size;
        this.choice = c;
        this.numOfThreads = t;
    }

    public void startThreads(){
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    @Override
    public void run() {

        int quarter = whole/2;
        int i=0, j=0;
        Random rand = new Random();
        Complex[][] A = new Complex[whole][whole];
        Complex[][] B = new Complex[whole][whole];
        Complex[][] result = new Complex[whole][whole];
        Complex[][] DFTResult = new Complex[whole][whole];

        Complex[][] A1 = new Complex[quarter][quarter];
        Complex[][] A2 = new Complex[quarter][quarter];
        Complex[][] A3 = new Complex[quarter][quarter];
        Complex[][] A4 = new Complex[quarter][quarter];
        Complex[][] B1 = new Complex[quarter][quarter];
        Complex[][] B2 = new Complex[quarter][quarter];
        Complex[][] B3 = new Complex[quarter][quarter];
        Complex[][] B4 = new Complex[quarter][quarter];
        Complex[][] R1 = new Complex[quarter][quarter];
        Complex[][] R2 = new Complex[quarter][quarter];
        Complex[][] R3 = new Complex[quarter][quarter];
        Complex[][] R4 = new Complex[quarter][quarter];

        for(int x=0; x<whole; x++) {
            for (int y = 0; y < whole; y++) {
                A[x][y] = new Complex(rand.nextDouble(), rand.nextDouble());
                B[x][y] = new Complex(rand.nextDouble(), rand.nextDouble());
            }
        }

        for(int x=0; x<quarter; x++) {
            for (int y = 0; y < quarter; y++) {
                A1[x][y] = A[i][j];
                B1[x][y] = B[i][j];
                j++;
            }
            i++;
            j=0;
        }
        i=0;
        j=quarter;

        for(int x=0; x<quarter; x++) {
            for (int y = 0; y < quarter; y++) {
                A2[x][y] = A[i][j];
                B2[x][y] = B[i][j];
                j++;
            }
            j=quarter;
            i++;
        }
        i=quarter;
        j=0;
        for(int x=0; x<quarter; x++) {
            for (int y = 0; y < quarter; y++) {
                A3[x][y] = A[i][j];
                B3[x][y] = B[i][j];
                j++;
            }
            i++;
            j=0;
        }
        i=quarter;
        j=quarter;
        for(int x=0; x<quarter; x++) {
            for (int y = 0; y < quarter; y++) {
                A4[x][y] = A[i][j];
                B4[x][y] = B[i][j];
                j++;
            }
            i++;
            j=quarter;
        }

        Addition obj1 = new Addition(A1, B1);
        Addition obj2 = new Addition(A2, B2);
        Addition obj3 = new Addition(A3, B3);
        Addition obj4 = new Addition(A4, B4);
        obj1.setC(choice);
        obj2.setC(choice);
        obj3.setC(choice);
        obj4.setC(choice);

        t1 = new Thread(obj1);
        t2 = new Thread(obj2);
        t3 = new Thread(obj3);
        t4 = new Thread(obj4);

        startThreads();

        System.out.println("Waiting for submatrices to get calculated.");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        if(done){
            System.out.println("Submatrices are getting united.");
            i=0;
            j=0;
            for(int x=0; x<quarter; x++) {
                for (int y = 0; y < quarter; y++) {
                    result[x][y] = obj1.getA()[i][j];
                    j++;
                }
                i++;
                j=0;
            }
            i=0;
            j=0;
            for(int x=0; x<quarter; x++) {
                for (int y = quarter; y < whole; y++) {
                    result[x][y] = obj2.getA()[i][j];
                    j++;
                }
                i++;
                j=0;
            }
            i=0;
            j=0;
            for(int x=quarter; x<whole; x++) {
                for (int y = 0; y < quarter; y++) {
                    result[x][y] = obj3.getA()[i][j];
                    j++;
                }
                i++;
                j=0;
            }
            i=0;
            j=0;
            for(int x=quarter; x<whole; x++) {
                for (int y = quarter; y < whole; y++) {
                    result[x][y] = obj4.getA()[i][j];
                    j++;
                }
                i++;
                j=0;
            }
            // ******************RESULT*****************
            System.out.println("A+B");
//            for(int x=0; x<whole; x++) {
//                for (int y = 0; y < whole; y++) {
//                    System.out.print(result[x][y]+"    ");
//                }
//                System.out.println();
//            }
            // *********************SUBRESULTS*****************
            System.out.println("A+B is getting divided again to calculate DFT");
            i=0;
            j=0;
            for(int x=0; x<quarter; x++) {
                for (int y = 0; y < quarter; y++) {
                    R1[x][y] = result[i][j];
                    j++;
                }
                i++;
                j=0;
            }
            i=0;
            j=quarter;

            for(int x=0; x<quarter; x++) {
                for (int y = 0; y < quarter; y++) {
                    R2[x][y] = result[i][j];
                    j++;
                }
                j=quarter;
                i++;
            }
            i=quarter;
            j=0;
            for(int x=0; x<quarter; x++) {
                for (int y = 0; y < quarter; y++) {
                    R3[x][y] = result[i][j];
                    j++;
                }
                i++;
                j=0;
            }
            i=quarter;
            j=quarter;
            for(int x=0; x<quarter; x++) {
                for (int y = 0; y < quarter; y++) {
                    R4[x][y] = result[i][j];
                    j++;
                }
                i++;
                j=quarter;
            }
            obj1.setR(R1);
            obj2.setR(R2);
            obj3.setR(R3);
            obj4.setR(R4);
            System.out.println("Waiting for DFT calculation");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("DFT is done, now it's time to get them united.");

            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            if(done){
                i=0;
                j=0;
                for(int x=0; x<quarter; x++) {
                    for (int y = 0; y < quarter; y++) {
                        DFTResult[x][y] = obj1.getDFT()[i][j];
                        j++;
                    }
                    i++;
                    j=0;
                }
                i=0;
                j=0;
                for(int x=0; x<quarter; x++) {
                    for (int y = quarter; y < whole; y++) {
                        DFTResult[x][y] = obj2.getDFT()[i][j];
                        j++;
                    }
                    i++;
                    j=0;
                }
                i=0;
                j=0;
                for(int x=quarter; x<whole; x++) {
                    for (int y = 0; y < quarter; y++) {
                        DFTResult[x][y] = obj3.getDFT()[i][j];
                        j++;
                    }
                    i++;
                    j=0;
                }
                i=0;
                j=0;
                for(int x=quarter; x<whole; x++) {
                    for (int y = quarter; y < whole; y++) {
                        DFTResult[x][y] = obj4.getDFT()[i][j];
                        j++;
                    }
                    i++;
                    j=0;
                }
            }
            System.out.println("DFT is ready.");
            obj1.print(DFTResult);
            JFrame frame = new JFrame("RESULT");
            frame.setLayout(new FlowLayout());
            frame.setSize(400, 400);
            JOptionPane.showMessageDialog(frame, obj1.toString(DFTResult));
            frame.setVisible(true);
        }
        Thread.UncaughtExceptionHandler h = (thread, exception) -> {
            t1.interrupt();
            t2.interrupt();
            t3.interrupt();
            t4.interrupt();
        };
        System.exit(0);
    }

}
