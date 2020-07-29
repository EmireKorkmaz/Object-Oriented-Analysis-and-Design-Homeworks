package com.emire;

public class BestDS implements  BestDSEver, Runnable{

    @Override
    public void insert(Object o) {
        System.out.println("BESTDSEVER INSERT");
    }

    @Override
    public void remove(Object o) {
        System.out.println("BESTDSEVER REMOVE");
    }

    @Override
    public Object get(int index) {
        System.out.println("BESTDSEVER GET");
        return null;
    }
    @Override
    public void run() {
        for(int i=0;i<10; i++)
            insert(i);
    }
}
