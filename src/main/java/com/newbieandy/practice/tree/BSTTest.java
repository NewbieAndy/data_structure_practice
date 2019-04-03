package com.newbieandy.practice.tree;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        int[] arr = new int[]{5, 6, 3, 2, 4, 2, 6, 1, 7, 9, 10};

        for (int i = 0; i < 11; i++) {
            tree.insert(arr[i]);
        }
        System.out.println(tree);
        tree.printTree();
    }
}
