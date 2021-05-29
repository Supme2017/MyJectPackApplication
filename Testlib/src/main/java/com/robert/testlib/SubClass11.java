package com.robert.testlib;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

public class SubClass11 extends ParentClass1 {

    protected int x;

    public int getX() {
        return this.x;
    }

    public void setX(int var1) {
        System.out.println("SubClass11 setX  x = " + var1);
        this.x = var1;
    }

    public void setValue() {
        this.setX(20);
        super.setValue();
    }


    public final void display() {
        String var1 = "x = " + this.getX();
        boolean var2 = false;
        System.out.println(var1);
        var1 = "super.x = " + super.getX();
        var2 = false;
        System.out.println(var1);
    }


    public static final void main(@NotNull String[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        SubClass11 pObj = new SubClass11();
        pObj.setValue();
        pObj.display();
    }
}
