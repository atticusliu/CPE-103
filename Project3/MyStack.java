/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 29 October 2015
 * Project 3
 */

import java.util.*;

// public class to define stack, stack operations
public class MyStack<T>
{
   // nested Node class
   private class Node
   {
      // each node has an element T, elem, and next, to point to the next value in a stack
      public T elem;
      public Node next;
   }

   // instance variable of Node that holds the address of 1st node
   private Node top;

   // constructor - creates empty stack
   public MyStack()
   {
      top = null;
   }
   
   // public method to push new element into stack
   public void push(T element)
   {
      // defining a new Node called temp
      Node temp = new Node();
      temp.elem = element;
      // link front of list to new node
      temp.next = top;
      // adjust top to point to newly added node
      top = temp;
      
   }

   // public method to pop Node off stack
   public T pop()
   {
      if (top != null)
      {
         // defining a new Node called temp, will hold top
         Node temp = new Node();
         temp = top;
         // delete first node
         top = temp.next;
         return temp.elem;
      }
      else
         throw new EmptyStackException();
   }

   // public peek method that returns value of first node
   public T peek()
   {
      if (top != null)
      {
         return top.elem;
      }
      else
         throw new EmptyStackException();
   }

   // public isEmpty method that returns true if list is empty, false otherwise
   public boolean isEmpty()
   {
      if (top == null)
         return true;
      else
         return false;
   }
      
}

