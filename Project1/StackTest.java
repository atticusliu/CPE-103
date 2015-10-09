/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * Project 1
 */

import java.util.*;
import java.io.*;

// class for stacktest
public class StackTest
{

   // main function for all user input/output
   public static void main(String[] args) {
      // s is MyStack object that holds strings
      MyStack<String> s = new MyStack<String>();

      // declaring Scanner object
      Scanner sc = new Scanner(System.in);

      System.out.println("Choose one of the following operations: ");
      System.out.println("-push/add (enter the letter a)");
      System.out.println("-pop/delete (enter the letter d)");
      System.out.println("-peek (enter the letter p)");
      System.out.println("-check if the list is empty (enter the letter e)");
      System.out.println("-Quit (enter the letter q)");

      // cond is boolean for while loop
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
                     // input value
                     String input = sc.nextLine();
                     //sc.nextLine();
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
         }//ending if statement
         else {
            System.out.print("Invalid menu choice");
         }
      } //end while condition
   }//end main
} //end program
