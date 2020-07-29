package com.emire;

public interface ThreadSafeDS{
    public void insert(Object o);

    public void remove(Object o);

    public Object get(int index);
}
