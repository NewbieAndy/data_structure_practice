package com.newbieandy.practice.tree;

import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void test(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(8);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.insert(10);
        tree.insert(3);
        tree.insert(5);
        tree.insert(6);
    }
}
