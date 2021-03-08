package com.interview.test;

import java.util.ArrayList;

public class MyArrayList {

    /**
     * arrayList remove
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("array");
        arrayList.add("list");
        arrayList.add("remove");

        arrayList.removeIf(s -> s.equals("list"));

        //等于下面代码
//        Iterator<String> iterator=arrayList.iterator();
//        while(iterator.hasNext()){
//            if (iterator.next().equals("list")) {
//                iterator.remove();
//            }
//        }
        System.out.println(arrayList);
    }

}
