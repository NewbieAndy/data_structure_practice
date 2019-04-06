package com.newbieandy.algorithm.number;

public class PalindromeNumber {
    private static boolean isPalindrome(int x) {
        //0是回文
        if (x == 0) {
            return true;
        }
        //小于0，或者个位是0的  都不是回文数字
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int ox = x;
        //求反转后的值
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            if (rev > 0 && rev > (Integer.MAX_VALUE - pop) / 10) {
                rev = 0;
                break;
            }
            x = x / 10;
            rev = rev * 10 + pop;
        }
        return rev == ox;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }
}
