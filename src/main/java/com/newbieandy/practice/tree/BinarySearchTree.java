package com.newbieandy.practice.tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;

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

    public boolean isEmpty() {
        return null == root;
    }

    public boolean contains(T element) {
        return contains(element, root);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMax(root).element;
    }

    public void insert(T element) {
        root = insert(element, root);
    }

    public void remove(T element) {
        root = remove(element, root);
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("empty tree");
        } else {
            printTree(root);
        }
    }

    private void printTree(BinaryNode t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private void noRecursionPrintTree(BinaryNode t) {
        LinkedList<BinaryNode> stack = new LinkedList<BinaryNode>();
        BinaryNode currentNode = t;
        while (null != currentNode || !stack.isEmpty()) {
            while (null != currentNode) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!stack.isEmpty()) {
                //todo
                currentNode = stack.peek();
            }
        }
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

    //查询最小值
    private BinaryNode<T> findMin(BinaryNode<T> tree) {
        if (null == tree) {
            return null;
        } else if (null == tree.left) {
            return tree;
        }
        return findMin(tree.left);
    }

    //查询最大值
    private BinaryNode<T> findMax(BinaryNode<T> tree) {
        if (null == tree) {
            return null;
        }
        while (null != tree.right) {
            tree = tree.right;
        }
        return tree;
    }

    private BinaryNode<T> insert(T element, BinaryNode<T> tree) {
        if (null == tree) {
            return new BinaryNode<T>(element, null, null);
        }
        int compareResult = element.compareTo(tree.element);
        if (compareResult < 0) {
            tree.left = insert(element, tree.left);
        } else if (compareResult > 0) {
            tree.right = insert(element, tree.right);
        } else {
            //重复数据不处理
        }
        return tree;
    }

    private BinaryNode<T> remove(T element, BinaryNode<T> tree) {
        if (null == tree) {
            return null;
        }
        int compareResult = element.compareTo(tree.element);
        if (compareResult > 0) {
            tree.right = remove(element, tree.right);
        } else if (compareResult < 0) {
            tree.left = remove(element, tree.left);
        } else if (null != tree.left && null != tree.right) {
            //找到要删除的节点,且有两个子节点
            //右节点最小值替代当前节点
            tree.element = findMin(tree.right).element;
            //在右子节点上删除此值
            remove(tree.element, tree.right);
        } else {
            //找到要删除的节点,若有一个子节点.则该子节点上升.若无子节点,这同样置为null
            tree = (null != tree.left) ? tree.left : tree.right;
        }
        return tree;
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
