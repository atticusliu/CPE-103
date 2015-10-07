import java.util.*;

public class StackTest
{

   public static void main(String[] args)
   {
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
         
         if (in.length() == 1)
         {
            switch (in.charAt(0))
            {
               case 'a':
               {
                  System.out.println("What would you like to add?");
                  String input = sc.nextLine();
                  s.push(input);
                  System.out.println(input + " pushed in.");
               }
               case 'd':
               {
                  String del = s.pop();
                  System.out.prinln(del + " popped out.");
               }
               case '
                 
