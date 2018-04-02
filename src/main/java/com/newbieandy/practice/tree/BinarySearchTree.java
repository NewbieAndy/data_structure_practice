package com.newbieandy.practice.tree;

/**
 * Created by mchao on 2018/4/2.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    //根节点
    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    //清空树
    public void makeEmpty() {
        root = null;
    }

    /**
     * 判断树中是否包含指定元素
     *
     * @param element 元素
     * @param tree    树
     * @return 是否包含
     */
    private boolean contains(T element, BinaryNode<T> tree) {
        if (null == tree) {
            return false;
        }
        //比较节点的元素与要判断的元素.并进行遍历
        int compareResult = element.compareTo(tree.element);
        if (compareResult < 0) {
            return contains(element, tree.left);
        } else if (compareResult > 0) {
            return contains(element, tree.right);
        } else {
            return true;
        }
    }

    private static class BinaryNode<T> {

        //数据
        T element;
        //左节点
        BinaryNode<T> left;
        //右节点
        BinaryNode<T> right;

        //节点对象
        BinaryNode(T element) {
            this(element, null, null);
        }

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
