package com.newbieandy.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chao.ma
 * @Date 2019/4/10 18:43
 * @Version 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String str) {
        //todo 未完成
        int length = str.length();
        Map<Character, Integer> counter = new HashMap<>();
        int result = 0;
        //起始指针
        int startIdx = 0;
        for (int idx = 0; idx < length; idx++) {
            char c = str.charAt(idx);
            //已经出现
            if (counter.containsKey(c)) {
                //当前结束指针为idx,起始指针为startIdx
                int l = idx - startIdx;
                startIdx = counter.get(c) - 1;
                result = Math.max(l, result);
            }
            //取出字符
            counter.put(str.charAt(idx), idx + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abc");
        System.out.println(i);
    }
}
