import java.io.*;
import java.util.*;

public class AStackClient
{

   // helper methods below

   public static boolean isInteger(String s)
   {
      boolean isInt = false;
      try
      {
         //Integer.parseInt(s);
         Integer.valueOf(s);
      } catch (NumberFormatException e) {
         // WHAT TO PUT HERE?!
         return false;
      } catch (NullPointerException e) {
         return false;
      }
      return true;
   }

   public static boolean isFloat(String s)
   {
      try
      {
         //Float.parseFloat(s);
         Float.valueOf(s);
      } catch (NumberFormatException e) {
         // WHAT TO PUT HERE?!
         return false;
      } catch (NullPointerException e) {
         return false;
      }
         return true;
   }


// MAIN METHOD

   public static void main(String[] args)
   {

      Scanner sc = new Scanner(System.in);
      System.out.println("File name: ");
      String filename = sc.next();
      sc.nextLine();

      AStack<String> stringStack = new AStack<String>(5);
      AStack<Float> floatStack = new AStack<Float>(5);
      AStack<Integer> integerStack = new AStack<Integer>(5);

      int intC = 0;
      int floatC = 0;
      int strC = 0;

      try
      {
         FileReader reader = new FileReader(filename);
         Scanner in = new Scanner(reader);

         String[] e = new String[50];
         String temp = "";

         //get input from .txt, map to array
         while(in.hasNextLine())
         {
            temp = temp + " " + in.nextLine();
         }

         e = temp.split("\\s+");

         // testing

         int justtest = 0;
         while(justtest < e.length)
         {
            System.out.print(e[justtest] + " ");
            justtest++;
         }

         System.out.println();

         int c = 0;
         while(c < e.length)
         {
            if(isInteger(e[c]))
            {
               integerStack.push(Integer.parseInt(e[c]));
               intC++;
            }
            else if(isFloat(e[c]))
            {
               floatStack.push(Float.parseFloat(e[c]));
               floatC++;
            }
            else
            {
               stringStack.push(e[c]);
               strC++;
            }
            c++;
         }
      } catch(IOException ex){
         System.out.println("Error processing file: " + ex);
      }

      // DISPLAY

      System.out.print("Strings: ");
      while(!stringStack.isEmpty())
      {
         System.out.print(stringStack.pop() + " ");
      }
      System.out.println();

      System.out.print("Floats: ");
      while(!floatStack.isEmpty())
      {
          System.out.print(floatStack.pop() + " ");
      }
      System.out.println();

      System.out.print("Integers: ");
      while(!integerStack.isEmpty())
      {
          System.out.print(integerStack.pop() + " ");
      }
      System.out.println();
   }
}
