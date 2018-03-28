package com.newbieandy.practice;

/**
 * Created by mchao on 2018/3/28. 在内部类中this指什么
 */
public class ThisTest {
    private int num = 8;

    public static void main(String[] args) {
        ThisTest test = new ThisTest();
        test.printTestNum();
        Inner inner = test.getInner();
        inner.printOuterNum();
        inner.printInnerNum();
    }

    public void printTestNum() {
        System.out.println(num);
    }

    public Inner getInner() {
        return new Inner();
    }

    private class Inner {
        private int num = 9;

        public void printInnerNum() {
            System.out.println(this.num);
        }

        public void printOuterNum() {
            System.out.println(ThisTest.this.num);
        }
    }
}
