package com.interview.anonymousClass;

/**
 * 匿名内部类
 *
 * 1. 匿名内部类可以访问外部内的所有成员
 * 2. 属性屏蔽，与内嵌类相同，匿名内部类定义的类型（如变量）会屏蔽其作用域范围内的其他同名类型（变量）
 */
public class AnonymousClasses {

    /**
     * 包含两个方法的HelloWorld接口
     */
    interface HelloWorld {
        void greet();
        void greetSomeone(String someone);
    }

    public void sayHello() {

        // 1、局部类EnglishGreeting实现了HelloWorld接口
        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        // 2、匿名类实现HelloWorld接口
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        // 3、匿名类实现HelloWorld接口
        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };

        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }

    public static void main(String... args) {
        AnonymousClasses myApp = new AnonymousClasses();
        myApp.sayHello();
    }
}