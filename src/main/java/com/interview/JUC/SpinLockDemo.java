package com.interview.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLockDemo {

    // 原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in");

        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName() + "\t invoked myUnLock");
    }

    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();

         new Thread(() -> {
              spinLockDemo.myLock();
             try {
                 TimeUnit.SECONDS.sleep(5);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             spinLockDemo.myUnLock();
         }, "AA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

          new Thread(() -> {
               spinLockDemo.myLock();
               spinLockDemo.myUnLock();
           }, "BB").start();
    }
}
