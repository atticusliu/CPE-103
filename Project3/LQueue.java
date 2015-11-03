/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 29 October 2015
 * Project 3
 */

import java.util.*;

// public class to implement a queue as a linked list
public class LQueue<T> 
{
   // nested class to define Node
   private class Node
   {
      // Node holds T type value
      public T value;
      // next that points to the next Node
      public Node next;
   }

    // public nested MyException class
    public static class MyException extends RuntimeException
    {
       public MyException()
      {
         super();
      }
       public MyException(String message)
      {
         super(message);
      }
    }

   // instance variables front, end, for either end of the queue
   private Node front;
   private Node end;

   // constructor that sets both front and end to null
   public LQueue()
   {
      front = end = null;
   }

   // public method to enqueue an item to the queue
   public void enqueue(T item)
   {
      // create new Node called temp, set the item to be its value
      Node temp = new Node();
      temp.value = item;

      //if empty
      if (front == null)
      {
         // both front and end will be temp
         front = temp;
         end = temp;   
      }
      else
      {
         // if list isn't empty, add new node to end of list
         end.next = temp;
         // adjust tail to point to newly added node
         end = temp;
      }
   }

   // public method that deletes front element and returns its value
   public T dequeue()
   {
      if (front == null)
      {
         throw new MyException();
      }

      else
      {
         // create T type variable called retvalue, holds front's value
         T retvalue = front.value;
         // adjust front
         front = front.next;
         return retvalue;
      }
   }

   // public method that returns true if list is empty, false otherwise
   public boolean isEmpty()
   {
      return front == null;
   }

}
