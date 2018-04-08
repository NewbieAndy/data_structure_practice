package com.newbieandy.practice.tree;

/**
 * Created by mchao on 2018/4/8.
 */
public class AvlTree<T> {
    //获取树高
    private int height(AvlNode<T> tree) {
        return null == tree ? -1 : tree.height;
    }

    private static class AvlNode<T> {
        //数据
        T element;
        //左子树
        AvlNode<T> left;
        //右子数
        AvlNode<T> right;
        //树高
        int height;

        AvlNode(T element) {
            this(element, null, null);
        }

        AvlNode(T element, AvlNode left, AvlNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }
}
