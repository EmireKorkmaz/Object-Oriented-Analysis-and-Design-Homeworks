package com.emire;

public class ThreadSafe implements ThreadSafeDS, Runnable {

    @Override
    public synchronized void insert(Object o) {
        System.out.println("THREAD SAFE INSERT");
    }

    @Override
    public synchronized void remove(Object o) {
        System.out.println("THREAD SAFE REMOVE");
    }

    @Override
    public synchronized Object get(int index) {
        System.out.println("THREAD SAFE GET");
        return null;
    }

    @Override
    public void run() {
        for(int i=0;i<10; i++)
            insert(i);
    }
}
