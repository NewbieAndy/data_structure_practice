package com.newbieandy.practice.sort;

import java.util.Random;

/**
 * 冒泡排序
 */
public class SortPractice {
    public static void main(String[] args) {
        int[] arr = getArr(20);
        System.out.println(arr);
        bubblingSort(arr);
        System.out.println(arr);
    }

    /**
     * 获取默认数组
     *
     * @return
     */
    private static int[] getArr(int langth) {
        Random random = new Random();
        int[] arr = new int[langth];
        for (int i = 0; i < langth; i++) {
            int nextInt = random.nextInt(langth);
            arr[i] = nextInt;
        }
        return arr;
    }

    /**
     * 冒泡排序
     */
    public static void bubblingSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
