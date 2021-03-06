package com.newbieandy.leetcode.number;

/**
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 *
 * @author chao.ma
 * @Date 2019/4/3 18:12
 * @Version 1.0
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            if (rev > 0 && rev > (Integer.MAX_VALUE - pop) / 10) {
                return 0;
            }
            if (rev < 0 && rev < (Integer.MIN_VALUE - pop) / 10) {
                return 0;
            }
            rev = rev * 10 + pop;
            x = x / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(123));
    }
}
