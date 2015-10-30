/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 29 October 2015
 * Project 3
 */

import java.util.*;
import java.util.NoSuchElementException;

public class BST<T extends Comparable<? super T>>
{
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

    private BSTNode root;

    // Iterator for pre-order traversal
    private class PreIter implements Iterator<T>
    {
        // instance variable used to get elements
        public MyStack<BSTNode> stk;

        // constructor
        public Iter()
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
            y = stk.pop();
            if(y.right != null)
                stk.push(y.right);
            if(y.left != null)
                stk.push(y.left);
            return y.element;
        }
    }

    // Iterator for in-order traversal
    private class InIter implements Iterator<T>
    {
        // instance variable used to get elements
        public MyStack<BSTNode> stk;

        // constructor
        public Iter()
        {
            stk = new MyStack<BSTNode>();
            if(root != null)
                stackUpLefts(root);
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
            y = stk.pop();
            if(y.right != null)
            {
                stk.push(y.right);
                stackUpLefts(y.right);
            }
            return y.element;
        }

        private void stackUpLefts(BSTNode x)
        while(x.left != null)
        {
            stk.push(x.left);
            // move x to point to its left child
            x = x.left;
        }
    }

    // Iterator for level-order traversal
    private class LevelIter implements Iterator<T>
    {
        // instance variable used to get elements
        public LQueue<BSTNode> queue;

        // constructor
        public Iter()
        {
            queue = new LQueue<BSTNode>();
            if(root != null)
                queue.enqueue(root);
        }

        // check fi there is an unvisited element
        public boolean hasNext()
        {
            return !queue.isEmpty();
        }

        // return "next" element of the collection
        public T next()
        {
            if(!hasNext())
                throw new NoSuchElementException();
            y = queue.dequeue();
            if(y.left != null)
                queue.enqueue(y.left);
            if(y.right != null)
                queue.enqueue(y.right);
            return y.element;
        }
    }

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

    public void insert(T item)
    { root = insert(item, root); }

    private BSTNode insert(int item, BSTNode treeroot)
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
            if(item < treeroot.element)
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

    private BSTNode delete(int item, BSTNode treeroot)
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
        // if x has two children
        if(x.left != null && x.right != null)
        {
            int nextvalue = successor(x);
            x = nextValue;
            x.right = delete(nextValue, x.right);
            BSTNode newRoot = x;
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
    private int successor(BSTNode x)
    {
        // temp is a pointer
        BSTNode temp = x.right;
        while(temp.left != null)
            temp = temp.left;
        return temp.element;
    }

    public boolean find(T item)
    {
        return find(item, root);
    }

    private boolean find(int item, BSTNode treeroot)
    {
        boolean answer;
        // base case
        if(root == null)
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
        int count = 0;
        if(treeroot == null)
            return 0;
        else
        {
            count = size(treeroot.left) + 1;
            count = size(treeroot.right) + 1;
        }
        return count;
    }

    public T findMinimum()
    {
        return findMinimum(root);
    }

    private T findMinimum(BSTNode treeroot)
    {
        if(treeroot == null)
            throw MyException();
    }

    public T findMaximum()
    {
        return findMaximum(root);
    }

    private T findMaximum(BSTNode treeroot)
    {
        if(treeroot == null)
            throw MyException();
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

    }

    // return a string containing all elements of tree
    // use recursion
    public String toString()
    {

    }

}