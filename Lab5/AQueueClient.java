import java.io.*;
import java.util.*;

public class AQueueClient
{

   public static boolean isFloat(String s)
   {
      try
      {
         //Integer.parseInt(s);
         Float.valueOf(s);
      } catch (NumberFormatException e) {
         return false;
      } catch (NullPointerException e) {
         return false;
      }
      return true;
   }

   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.println("What numbers would you like to output?");
      AQueue<Float> floatque = new AQueue<Float>(5);

      String[] temp = new String[50];
      String input = "";

      while(sc.hasNextLine())
      {
         input = input + sc.nextLine()+ " ";
      }
      temp = input.split("\\s+");

      /*
      // testing
      int justtest = 0;
      while(justtest < temp.length)
      {
         System.out.print(temp[justtest] + " ");
         justtest++;
      }
      */

      int count = 0;
      while(count < temp.length)
      {
         if(isFloat(temp[count]))
         { 
            floatque.enqueue(Float.parseFloat(temp[count]));
         }
         count++;
      }

      // displaying

      while(!floatque.isEmpty())
      {
         System.out.print(floatque.dequeue() + " ");
      }
      System.out.println();
   }
}
