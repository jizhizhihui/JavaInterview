package com.interview.test;

import java.util.Random;

public class T1 {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder word = null;
        System.out.println(random.nextInt(2));
        switch (random.nextInt(2)){
            case 1:
                word = new StringBuilder('P');
            case 2:
                word = new StringBuilder('G');
            default:
                word = new StringBuilder('M');
        }
        word.append('a');
        word.append('i');
        word.append('n');
        System.out.println(word);
    }


}
