package com.emire;

public class DSAdapter implements ThreadSafeDS, Runnable{

    BestDS bestie = new BestDS();

    public DSAdapter(BestDS best){
        this.bestie = best;
    }

    @Override
    public void insert(Object o) {
        bestie.insert(o);
    }

    @Override
    public void remove(Object o) {
        bestie.remove(o);
    }

    @Override
    public Object get(int index) {
        bestie.get(index);
        return null;
    }

    @Override
    public void run() {
        for(int i=0;i<10; i++) {
            insert(i);
        }
    }
}
