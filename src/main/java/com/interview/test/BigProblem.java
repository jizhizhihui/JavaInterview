package com.interview.test;

import java.math.BigInteger;

/**
 * 大数值问题
 *
 * 结果：0
 * 原因：add() 用法为( a = b + c;) : a = b.add(c);
 */
public class BigProblem {
    public static void main(String[] args) {
        BigInteger fiveThousand = new BigInteger("5000");
        BigInteger fiftyThousand = new BigInteger("50000");
        BigInteger fiveHundredThousand = new BigInteger("500000");

        BigInteger totle = BigInteger.ZERO;

        totle.add(fiveThousand);
        totle.add(fiftyThousand);
        totle.add(fiveHundredThousand);

        System.out.println(totle);
        System.out.println(Math.round(11.5) );
        System.out.println(Math.round(-11.5) );
    }
}
