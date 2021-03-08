package com.interview.JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue: 是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原则对元素进行排序。
 * LinkedBlockingDeque:  一个基于链表结构的阻塞队列，次队列按FIFO（先进先出）排序元素，吞吐量通常高于ArrayBlockingQueue。
 * SynchronousQueue:  一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于
 *
 *
 * 1 队列
 *
 * 2 阻塞队列
 *      2.1 阻塞队列有没有好的一面
 *
 *      2.2 不得不阻塞，你如何管理
 *
 *
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception{

//        ArrayBlockingQueue
//        LinkedBlockingQueue;
//        PriorityBlockingQueue
//        DelayQueue
//        SynchronousQueue
//        LinkedTransferQueue
//        LinkedBlockingDeque

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.add("x"));


    }
}
