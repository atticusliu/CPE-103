import java.util.*;

public class AQueue<T>
{
   private T[] arr;
   private int front;
   private int end;
   private int count;

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

   public AQueue(int size)
   {
      arr = (T[]) new Object[size];
      front = 0;
      end = -1;
      count = 0;
   }

   public boolean isEmpty()
   {
      if (count == 0)
         return true;
      else
         return false;
   }

   public void enqueue(T value)
   {
      count++;
      //check to see if array is big enough
      //if count is greater than the length of arrlength than double the size
      if (count == arr.length)
      {
         T[] temp;
         temp = (T[]) new Object[arr.length*2];
         //copying into new array
         int i = 0;
         while (i < count)
         {
            temp[i] = arr[front];
            front = (front+1)% arr.length;
            i++;
         }
         arr = temp;
         front = 0;
         end = count-1;

         //end represents the index where we are adding the value to; add element
         end = (end+1)% arr.length;
         arr[end] = value;
      }
      else
      {
         //end represents the index where we are adding the value to
         end = (end + 1)% arr.length;
         arr[end] = value;
      }
   }

   public T dequeue()
   {
      if (count!=0)
      {
         T retVal = arr[front];
         arr[front] = null;
         front = (front + 1)% arr.length;
         count--;
         return retVal;
      }
      else
         throw new MyException();
   }

   public void printArray()
   {
      for (int i = 0; i < arr.length; i++)
      {
         System.out.print(arr[i] + " ");
      }
   }

}
