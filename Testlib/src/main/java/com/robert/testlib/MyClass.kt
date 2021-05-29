package com.robert.testlib

import com.sun.org.apache.xml.internal.security.Init

open class ParentClass {
    // x成员属性
     open var x: Int = 0
     open protected fun setValue() {
        x = 10
    }
}

class SubClass : ParentClass() {
    // 屏蔽父类x成员属性
    override var x: Int = 0
    public  fun setValue1() { // 重写父类函数 ⑤
// 访问子类对象x成员属性
        x = 20
// 调用父类setValue()函数
        setValue()
    }
    fun display() {
// 访问子类对象x成员属性
        println("x = " + x)
// 访问父类x成员属性
        println("super.x = " + super.x)
    }
}


fun test(w: Int, h: Int, t:Int, e: Int) : Int{

    println(w+h+t+e);
    return w+h+t+e;
}
fun main(args: Array<String>) {
//实例化子类SubClass
    val pObj = SubClass()
//调用setValue函数
    pObj.setValue1()
//调用子类print函数
    pObj.display()

    val b : Byte = 16;
    val s : Short = b.toShort();
    println(b)

//    test(w=50, 20, 20, 30);
    test(w=50, h=20, 20, 30);
}