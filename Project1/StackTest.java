import java.util.*;
import java.io.*;

public class StackTest
{

   public static void main(String[] args) {
      MyStack<String> s = new MyStack<String>();
      Scanner sc = new Scanner(System.in);

      System.out.println("Choose one of the following operations: ");
      System.out.println("-push/add (enter the letter a)");
      System.out.println("-pop/delete (enter the letter d)");
      System.out.println("-peek (enter the letter p)");
      System.out.println("-check if the list is empty (enter the letter e)");
      System.out.println("-Quit (enter the letter q)");

      boolean cond = true;

      while (cond)
      {
         System.out.println("Enter menu choices");
         String in = sc.nextLine();

         if (in.length() == 1) {
            switch (in.charAt(0)) {
               case 'a':
                  System.out.println("What would you like to add?");
                  if (sc.hasNext())
                  {
                     String input = sc.nextLine();
                     sc.nextLine();
                     s.push(input);
                     System.out.println(input + " pushed in.");
                  }
                  else
                  {
                     System.out.println("Invalid value for the add/push command.");
                     sc.nextLine();
                  }
                  break;
               case 'd':
                  if (s.isEmpty())
                  {
                     System.out.println("The stack is empty.");
                  }
                  else
                  {
                     System.out.println(s.pop() + " was popped.");
                  }
                  break;
               case 'p':
                  if (!s.isEmpty())
                  {
                     System.out.println(s.peek() + " is on top");
                  }
                  else
                  {
                     System.out.println("Stack is empty.");
                  }
                  break;
               case 'e':
                  if (s.isEmpty()) {
                     System.out.println("empty");
                  }
                  else
                  {
                     System.out.println("not empty.");
                  }
                  break;
               case 'q':
                  cond = false;
                  System.out.println("quitting");
                  break;
               default:
                  System.out.println("Invalid menu choice");
            }
         }//ending my if statement
         else {
            System.out.print("Invalid menu choice");
         }
      } //end while condition
   }//end main
} //end program
