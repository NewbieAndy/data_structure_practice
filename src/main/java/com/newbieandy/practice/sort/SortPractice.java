package com.newbieandy.practice.sort;

import java.util.Random;

/**
 * 冒泡排序
 */
public class SortPractice {
    public static void main(String[] args) {
        int[] arr = getArr(30);
//        int[] arr = new int[]{6, 53, 5, 1, 0, 3, 2, 0, 4, 8};
        printArr(arr);
//        bubblingSort(arr);
//        insertSort(arr);
        quickSort(arr, 0, arr.length - 1);
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

    /**
     * 快速排序
     *
     * @param arr
     */
    private static void quickSort(int[] arr, int leftIdx, int rightIdx) {
        if (1 < (rightIdx - leftIdx)) {
            int pivot = getPivot(arr, leftIdx, rightIdx);
            int i = leftIdx;
            int j = rightIdx - 1;
            for (; ; ) {
                while (arr[++i] < pivot) {
                }
                while (arr[--j] > pivot) {
                }
                if (i < j) {
                    swap(arr, i, j);
                } else break;
            }
            swap(arr, i, rightIdx - 1);
            quickSort(arr, leftIdx, i - 1);
            quickSort(arr, i + 1, rightIdx);
        } else {
            if (arr[leftIdx] > arr[rightIdx]) {
                swap(arr, leftIdx, rightIdx);
            }
        }
    }

    /**
     * 确定主元
     *
     * @param arr
     * @param leftIdx
     * @param rightIdx
     * @return
     */
    private static int getPivot(int[] arr, int leftIdx, int rightIdx) {
        int centerIdx = (leftIdx + rightIdx) / 2;
        if (arr[leftIdx] > arr[centerIdx]) {
            swap(arr, leftIdx, centerIdx);
        }
        if (arr[leftIdx] > arr[rightIdx]) {
            swap(arr, leftIdx, rightIdx);
        }
        if (arr[centerIdx] > arr[rightIdx]) {
            swap(arr, centerIdx, rightIdx);
        }
        swap(arr, centerIdx, rightIdx - 1);
        return arr[rightIdx - 1];
    }

    /**
     * 交换数据
     *
     * @param arr
     * @param leftIdx
     * @param rightIdx
     */
    private static void swap(int[] arr, int leftIdx, int rightIdx) {
        int temp = arr[leftIdx];
        arr[leftIdx] = arr[rightIdx];
        arr[rightIdx] = temp;
    }
}
