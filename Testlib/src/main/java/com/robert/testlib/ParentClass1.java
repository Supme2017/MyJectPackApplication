package com.robert.testlib;

public class ParentClass1 {

    protected int x;

    public int getX() {
        return x;
    }

    public void setX(int var1) {
        System.out.println("ParentClass1 setX  x = " + var1);
        x = var1;
    }

    protected void setValue() {
        setX(10);
    }
}
