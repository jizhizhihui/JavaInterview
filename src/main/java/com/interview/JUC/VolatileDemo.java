package com.interview.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {
//    private int number = 0;
    private volatile int number = 0;

    public void addTo60() {
        this.number += 60;
    }

    public int getNumber() {
        return number;
    }

    public void addPlusPlus() {
        this.number++;
    }

    // 带原子性的Integer
    private AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
    public AtomicInteger getAtomicInteger(){
        return atomicInteger;
    }
}

/**
 * 1 验证 Volatile 的可见性
 * 1.1 假如 int number = 0; number 变量之前根本没有添加volatile关键字修饰，没有可见性
 * 1.2 添加了volatile ，可以解决可见性问题。
 *
 * 2 验证volatile不保证原子性
 * 2.1 原子性指的是什么意思？
 * 不可分割，完整性，也即某个线程正在错某个具体业务时，中间不可以被加塞或者分割，需要整体完整，要么同时成功，要么同时失败。
 *
 * 2.2 volatile不保证原子性，案例演示
 *
 * 2.3 why
 *
 * 2.4 如何保证原子性？
 *      加synchronized
 *      使用 JUC 下的 AtomicInteger
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }

        // 有两个活跃线程，主线程和gc线程
        while (Thread.activeCount() > 2){
            Thread.yield(); //使当前线程让出 CPU 时间片，线程从运行状态（Running）变为可执行状态（Runnable）
        }

        System.out.println(Thread.currentThread().getName() + "int type, finally number value: " + myData.getNumber());
        System.out.println(Thread.currentThread().getName() + "AtomicInteger type, finally number value: " + myData.getAtomicInteger());
    }

    // volatile 可以保证可见性，及时通知其他线程，主物理内存中的值已经被修改。
    public static void seeOkByVolatile() {

        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " come in ");
            //暂停一会儿线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + " update number value: " + myData.getNumber());
        }, "AAA").start();

        //第2个线程就是我们的Main线程
        while (myData.getNumber() == 0) {
            // main线程就一直在这里循环，知道number的值不再等于0.
        }

        System.out.println(Thread.currentThread().getName() + " mission is over");
    }
}
