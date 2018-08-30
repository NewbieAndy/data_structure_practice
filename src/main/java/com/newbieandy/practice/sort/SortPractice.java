package com.newbieandy.practice.sort;

import java.util.Random;

/**
 * 冒泡排序
 */
public class SortPractice {
    public static void main(String[] args) {
        int[] arr = getArr(16);
        printArr(arr);
//        bubblingSort(arr);
        insertSort(arr);
        System.out.println("======");
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
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
    private static void bubblingSort(int[] arr) {
        int length = arr.length;
        for (int l = 0; l < length; l++) {
            for (int i = 0; i < length - l - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //取出要排序的元素
            int temp = arr[i];
            int j = i;
            for (; j > 0 && temp > arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
