/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 29 October 2015
 * Project 3
 */

import java.lang.System;
import java.lang.UnsupportedOperationException;
import java.util.*;
import java.util.NoSuchElementException;

public class BST<T extends Comparable<? super T>>
{
    // private class to declare BSTNode object
    private class BSTNode
    {
        T element;
        BSTNode left, right;

        public BSTNode() {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    // private instance BSTNode variable called root
    private BSTNode root;

    // ********** BEGINNING OF PRIVATE ITERATOR CLASSES *********

    // Iterator for pre-order traversal
    private class PreIter implements Iterator<T>
    {
        // instance variable used to get elements
        public MyStack<BSTNode> stk;

        // constructor
        public PreIter()
        {
            stk = new MyStack<BSTNode>();
            if(root != null)
                stk.push(root);
        }

        // check if there is an unvisited element
        public boolean hasNext()
        {
            return !stk.isEmpty();
        }

        // return "next" element of the collection
        public T next()
        {

            if(!hasNext())
                throw new NoSuchElementException();
            BSTNode y = stk.pop();
            if(y.right != null)
                stk.push(y.right);
            if(y.left != null)
                stk.push(y.left);
            return y.element;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

    }

    // Iterator for in-order traversal
    private class InIter implements Iterator<T>
    {

        // method that repeatedly turns left
        private void stackUpLefts(BSTNode x)
        {
            while (x.left != null) {
                stk.push(x.left);
                // move x to point to its left child
                x = x.left;
            }
        }

        // instance variable used to get elements
        public MyStack<BSTNode> stk;

        // constructor
        public InIter() {
            stk = new MyStack<BSTNode>();
            if (root != null)
            {
                stk.push(root);
                stackUpLefts(root);
            }

        }

        // check if there is an unvisited element
        public boolean hasNext()
        {
            return !stk.isEmpty();
        }

        // return "next" element of the collection
        public T next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            BSTNode y = stk.pop();
            if (y.right != null) {
                stk.push(y.right);
                stackUpLefts(y.right);
            }
            return y.element;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

    }

    // Iterator for level-order traversal
    private class LevelIter implements Iterator<T>
    {
        // instance variable used to get elements
        public LQueue<BSTNode> queue;

        // constructor
        public LevelIter()
        {
            queue = new LQueue<BSTNode>();
            if(root != null)
                queue.enqueue(root);
        }

        // check if there is an unvisited element
        public boolean hasNext()
        {
            return !queue.isEmpty();
        }

        // return "next" element of the collection
        public T next()
        {
            if(!hasNext())
                throw new NoSuchElementException();
            BSTNode y = queue.dequeue();
            if(y.left != null)
                queue.enqueue(y.left);
            if(y.right != null)
                queue.enqueue(y.right);
            return y.element;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
    // ********** END PRIVATE ITERATOR CLASSES **********

    // static class to define MyException
    public static class MyException extends RuntimeException
    {
        // constructor without parameters
        public MyException()
        { super(); }

        // constructor with parameter message
        public MyException(String message)
        { super(message); }
    }

    // constructor to create empty BST
    public BST()
    {
        root = null;
    }

    // ********** BEGINNING OF BST METHODS **********

    public void insert(T item)
    { root = insert(item, root); }

    private BSTNode insert(T item, BSTNode treeroot)
    {
        // if subtree is empty
        if(treeroot == null)
        {
            BSTNode temp = new BSTNode();
            treeroot = temp;
            temp.element = item;
        }
        else
        {
            if(item.compareTo(treeroot.element) < 0)
                treeroot.left = insert(item, treeroot.left);
            else
                treeroot.right = insert(item, treeroot.right);
        }
        return treeroot;
    }

    public void delete(T item)
    {
        root = delete(item, root);
    }

    private BSTNode delete(T item, BSTNode treeroot)
    {
        // if subtree is not empty
        if(treeroot != null)
        {
            // if item is smaller than subtree's root element
            if(item.compareTo(treeroot.element) < 0)
                treeroot.left = delete(item, treeroot.left);
            else if(item.compareTo(treeroot.element) > 0)
                treeroot.right = delete(item, treeroot.right);
            else
                treeroot = deleteNode(treeroot);
        }
        return treeroot;
    }

    // called on by delete
    private BSTNode deleteNode(BSTNode x)
    {
        BSTNode newRoot = new BSTNode();
        T nextValue = successor(x);

        // if x has two children
        if(x.left != null && x.right != null)
        {
            x.element = nextValue;
            x.right = delete(nextValue, x.right);
            newRoot = x;
        }
        else
        {
            if(x.left != null)
                newRoot = x.left;
            else
            {
                if (x.right != null)
                    newRoot = x.right;
            }
        }
        return newRoot;
    }

    // gets the node containing the smallest value of right subtree of x
    private T successor(BSTNode x)
    {
        // temp is a pointer
        System.out.println("A");
        BSTNode temp = new BSTNode();
        System.out.println("B");
        temp = x.right;
        System.out.println("C");
        while(temp.left != null)
        {
            temp = temp.left;
            System.out.println("D");
        }
        System.out.println("E");
        return temp.element;
    }

    public boolean find(T item)
    {
        return find(item, root);
    }

    // crashes when inputted element isn't in the tree
    private boolean find(T item, BSTNode treeroot)
    {
        boolean answer;
        // base case
        if(treeroot == null)
            answer = false;
        else
        {
            // if target is the subtree's root element
            if(item.compareTo(treeroot.element) == 0)
                answer = true;
            else
            {
                // if target is smaller than subtree's root element
                if(item.compareTo(treeroot.element) < 0)
                    answer = find(item, treeroot.left);
                else
                    answer = find(item, treeroot.right);
            }
        }
        return answer;
    }

    // check to see if root is null
    public boolean isEmpty()
    {
        return root == null;
    }

    // make root null
    public void makeEmpty()
    {
        root = null;
    }

    // use recursion
    public int size()
    {
        return size(root);
    }

    private int size(BSTNode treeroot)
    {
        int count;
        if(treeroot == null)
            count = 0;
        else
            count = size(treeroot.left) + 1 + size(treeroot.right);
        return count;
    }

    public T findMinimum()
    {
        return findMinimum(root);
    }

    private T findMinimum(BSTNode treeroot)
    {
        T answer;
        if(treeroot == null)
            throw new MyException("Tree is empty.");
        else
        {
            // base case
            if(treeroot.left == null)
                answer = treeroot.element;
            else
                answer = findMinimum(treeroot.left);
        }
        return answer;

    }

    public T findMaximum()
    {
        return findMaximum(root);
    }

    private T findMaximum(BSTNode treeroot)
    {
        T answer;
        if(treeroot == null)
            throw new MyException("Tree is empty.");
        else
        {
            // base case
            if(treeroot.right == null)
                answer = treeroot.element;
            else
                answer = findMaximum(treeroot.right);
        }
        return answer;
    }

    // to create a new PreIter object
    public Iterator<T> iteratorPre()
    {
        return new PreIter();
    }

    // to create a new InIter object
    public Iterator<T> iteratorIn()
    {
        return new InIter();
    }

    // to create a new LevelIter object
    public Iterator<T> iteratorLevel()
    {
        return new LevelIter();
    }

    // recursively print the tree
    public void printTree()
    {
        String indent = "";
        printTree(indent, root);
    }

    private void printTree(String space, BSTNode treeroot)
    {
        if(treeroot != null)
        {
            System.out.println(space + treeroot.element);
            space += "    ";
            printTree(space, treeroot.left);
            printTree(space, treeroot.right);

        }

    }

    // return a string containing all elements of tree
    public String toString()
    {
        return toString(root);
    }

    // print elements out levelorder
    private String toString(BSTNode treeroot)
    {
        String ret = "";
        if(treeroot != null)
        {
            ret = treeroot.element + " ";
            ret = ret.concat(toString(treeroot.left));
            ret = ret.concat(toString(treeroot.right));
        }
        return ret;
    }
    // ********** END OF BST METHODS **********
}