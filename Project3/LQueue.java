/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 29 October 2015
 * Project 3
 */

import java.util.*;

public class LQueue<T> 
{
   private class Node
   {
      public T value;
      public Node next;
   }

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

    //instance variables
    private Node front;
    private Node end;

    

    public LQueue()
    {
       front = end = null;
    }


   public void enqueue(T item)
   {
      Node temp = new Node();
      temp.value = item;

      //if empty
      if (front == null)
      {
         front = temp;
         end = temp;   
      }
      else
      {
         end.next = temp;
         end = temp;
      }
   }

   public T dequeue()
   {
      if (front == null)
      {
         throw new MyException();
      }

      else
      {
          T retvalue = front.value;
          front = front.next;
          return retvalue;
      }
   }

   public boolean isEmpty()
   {
      return front == null;
   }


}
