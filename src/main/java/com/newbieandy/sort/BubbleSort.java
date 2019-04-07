package com.newbieandy.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr) {
        int length = arr.length;
        boolean noSwap = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    noSwap = false;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (noSwap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 7, 8, 9, 0, 3, 4, 7, 85};
        Arrays.stream(arr).forEach(i -> System.out.print(i + ","));
        sort(arr);
        System.out.println("===");
        Arrays.stream(arr).forEach(i -> System.out.print(i + ","));
    }
}
