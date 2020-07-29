package com.emire;

public class Main {
    public static void main(String[] args){
        BestDS best = new BestDS();
        ThreadSafe ts = new ThreadSafe();

        ThreadSafeDS threadSafeDS = new DSAdapter(best);
        Thread[] t = new Thread[30];

        for (int i =0; i<10; i++){
            t[i] = new Thread(best);
        }

        for (int i =10; i<20; i++){
            t[i] = new Thread(ts);
        }

        for (int i =20; i<30; i++){
            t[i] = new Thread(new DSAdapter(best));
        }

        for (int i=0;i<30;i++){
            t[i].start();
        }

    }
}