/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 29 October 2015
 * Project 3
 */

import java.util.*;

// defining the stack
public class MyStack<T>
{
   // nested Node class
   private class Node
   {
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
   
   // push method
   public void push(T element)
   {
      // defining a new Node called temp
      Node temp = new Node();
      temp.elem = element;
      temp.next = top;
      top = temp;
      
   }

   // pop method
   public T pop()
   {
      if (top != null)
      {
         // defining a new Node called temp
         Node temp = new Node();
         temp = top;
         top = temp.next;
         return temp.elem;
      }
      else
         throw new EmptyStackException();
   }

   // peek method
   public T peek()
   {
      if (top != null)
      {
         return top.elem;
      }
      else
         throw new EmptyStackException();
   }

   // isEmpty method
   public boolean isEmpty()
   {
      if (top == null)
         return true;
      else
         return false;
   }
      
}

