import java.util.*;
/*
 * @authors: Salonee Thanawala, Atticus Liu
 *
 * CPE103-03
 * Project 1
 */

public class MyStack<T>
{
   //nested Node class
   private class Node
   {
      public T elem;
      public Node next;
   }

   //instance variable of Node that holds the address of 1st node
   private Node top;

   //constructor - creates empty stack
   public MyStack()
   {
      top = null;
   }
   
   //methods
   public void push(T element)
   {
      Node temp = new Node();
      temp.elem = element;
      temp.next = top;
      top = temp;
      
   }

   public T pop()
   {
      if (!(top == null))
      {
         Node temp = new Node();
         temp = top;
         top = temp.next;
         return temp.elem;
      }
      else
         throw new EmptyStackException();
   }

   public T peek()
   {
      if (!(top == null))
      {
         return top.elem;
      }
      else
         throw new EmptyStackException();
   }

   public boolean isEmpty()
   {
      if (top == null)
         return true;
      else
         return false;
   }
      
}

