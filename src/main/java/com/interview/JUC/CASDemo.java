package com.interview.JUC;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. CAS 是什么？ ==> compareAndSet
 *      比较并交换
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.compareAndSet(5,2021) + " current data: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,1024) + " current data: " + atomicInteger.get());
    }
}
