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

// BST class to hold BSTNode class, iterator classes, BST methods
public class BST<T extends Comparable<? super T>>
{
    // private class to declare BSTNode object
    private class BSTNode
    {
        // BSTNode holds an element, a left child, and a right child
        T element;
        BSTNode left, right;

        // BST Node constructor
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
            // creating a new stack of BSTNode objects
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
            // set y equal to what is popped off stk
            BSTNode y = stk.pop();
            if(y.right != null)
                stk.push(y.right);
            if(y.left != null)
                stk.push(y.left);
            return y.element;
        }

        // public remove method for the pre-order traversal
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
            // create a stack of BSTNode objects
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
            // create BSTNode y, set it to what's popped off the stack
            BSTNode y = stk.pop();
            if (y.right != null) {
                stk.push(y.right);
                stackUpLefts(y.right);
            }
            return y.element;
        }

        // method to remove for in-order traversal
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
            // create queue of BSTNode objects
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
            // BSTNode y is what's dequeued from queue
            BSTNode y = queue.dequeue();
            if(y.left != null)
                queue.enqueue(y.left);
            if(y.right != null)
                queue.enqueue(y.right);
            return y.element;
        }

        // method to remove for level-order traversal
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

    // public method to add an element to the BST
    public void insert(T item)
    { root = insert(item, root); }

    // private method for insert--recursion used here
    private BSTNode insert(T item, BSTNode treeroot)
    {
        // if subtree is empty
        if(treeroot == null)
        {
            // BSTNode temp created
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

    // public method to delete element from bst
    public void delete(T item)
    {
        root = delete(item, root);
    }

    // private method for delete--recursion used here
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

    // private helper method called on by delete that deletes a node
    private BSTNode deleteNode(BSTNode x)
    {
        // initialize BSTNode newRoot
        BSTNode newRoot;
        // if x has two children
        if(x.left != null && x.right != null)
        {
            // create T type nextValue, set it to successor(x)
            T nextValue = successor(x);
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
                else
                    newRoot = null;
            }
        }
        return newRoot;
    }

    // private helper method called on by delete
    // gets the node containing the smallest value of right subtree of x
    private T successor(BSTNode x)
    {
        // temp is a pointer
        BSTNode temp = new BSTNode();
        temp = x.right;
        while(temp.left != null)
        {
            temp = temp.left;
        }
        return temp.element;
    }

    // public function to call on find
    public boolean find(T item)
    {
        return find(item, root);
    }

    // private function for find, recursion used here
    private boolean find(T item, BSTNode treeroot)
    {
        // initialize boolean variable answer, will be returned at end
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

    // public method to check to see if root is null
    public boolean isEmpty()
    {
        return root == null;
    }

    // public method to make root null
    public void makeEmpty()
    {
        root = null;
    }

    // public method to find size
    public int size()
    {
        return size(root);
    }

    // private method to find size, recursion used here
    private int size(BSTNode treeroot)
    {
        // initialize count variable, will be returned at end
        int count;
        if(treeroot == null)
            count = 0;
        else
            count = size(treeroot.left) + 1 + size(treeroot.right);
        return count;
    }

    // public method to find minimum
    public T findMinimum()
    {
        return findMinimum(root);
    }

    // private method to find minimum, recurison used here
    private T findMinimum(BSTNode treeroot)
    {
        // initialize T type variable answer, will be returned at end
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

    // public method to find maximum
    public T findMaximum()
    {
        return findMaximum(root);
    }

    // private method to find maximum, recursion used here
    private T findMaximum(BSTNode treeroot)
    {
        // initialize T type variable answer, will be returned at end
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
        // new PreIter object, refers to pre-order iterator created earlier in the file
        return new PreIter();
    }

    // to create a new InIter object
    public Iterator<T> iteratorIn()
    {
        // new inIter object, refer to in-order iterator created earlier in the file
        return new InIter();
    }

    // to create a new LevelIter object
    public Iterator<T> iteratorLevel()
    {
        // new LevelIter object, refer to level-order iterator created earlier in the file
        return new LevelIter();
    }

    // recursively print the tree
    public void printTree()
    {
        // empty string indent, will be added to in private printTree method
        String indent = "";
        printTree(indent, root);
    }

    // private method to print tree, recursion used here
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

    // public method to return a string containing all elements of tree
    public String toString()
    {
        return toString(root);
    }

    // private method to print elements out levelorder
    private String toString(BSTNode treeroot)
    {
        // empty string ret, will be returned at end. Used for concatenation
        String ret = "";
        if(treeroot != null)
        {
            // set ret equal to element and space
            ret = treeroot.element + " ";
            // recurisve call, with left and right children
            ret = ret.concat(toString(treeroot.left));
            ret = ret.concat(toString(treeroot.right));
        }
        return ret;
    }
    // ********** END OF BST METHODS **********
}