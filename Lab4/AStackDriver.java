import java.util.*;

public class AStackDriver
{

   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      //AStack[] stack = new AStack[5];
      AStack<Integer> stack = new AStack<Integer>(5);

      System.out.println("Choose one of the following operations: ");
      System.out.println("-     add/push (enter the letter a)");
      System.out.println("-     delete/pop (enter the letter d)");
      System.out.println("-     peek (enter the letter p)");
      System.out.println("-     isEmpty (enter the letter e)");
      System.out.println("-     quit (enter the letter q)");

      boolean cond = true;

      while (cond)
      {
         System.out.println("Enter menu choices: ");
         String in = sc.nextLine();

         if(in.length() == 1)
         {
            switch(in.charAt(0))
            {
               case 'a':
                  System.out.println("Value: ");
                  if(sc.hasNextInt())
                  {
                     int temp = sc.nextInt();
                     sc.nextLine();
                     stack.push(temp);
                  } else {
                     System.out.println("Invalid value for the add/push command.");
                     sc.nextLine();
                  }
                  break;
               case 'd':
                  if(stack.isEmpty())
                     System.out.println("Stack is empty");
                  else
                     System.out.println(stack.pop() + " was popped.");
                  break;
               case 'p':
                  if(!stack.isEmpty())
                  {
                     System.out.println(stack.peek());
                  } else {
                     System.out.println("Stack is empty.");
                  }
                  break;
               case 'e':
                  if(stack.isEmpty())
                  {
                     System.out.println("Yes");
                  } else {
                     System.out.println("No");
                  }
                  break;
               case 'q':
                  cond = false;
                  while(!stack.isEmpty())
                  {
                     System.out.print(stack.pop() + " ");
                  }
                     System.out.println();
                  break;
               default:
                  System.out.println("Invalid value");
            }
         } else {
            System.out.println("Invalid menu value.");
         }
      } // end while
   }
}
