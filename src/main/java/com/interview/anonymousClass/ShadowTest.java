package com.interview.anonymousClass;

/**
 * 匿名内部类的属性屏蔽
 */
public class ShadowTest {
    public int x = 0;

    interface FirstLevel {
        void methodInFirstLevel(int x);
    }

    FirstLevel firstLevel =  new FirstLevel() {

        public int x = 1;

        @Override
        public void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    };

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.firstLevel;
        fl.methodInFirstLevel(23);
    }
}
