import java.util.*;

public class AQueueDriver
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      AQueue<Integer> que = new AQueue<Integer>(5);

      System.out.println("Choose one of the following operations: ");
      System.out.println("    -enqueue/add (enter the letter a)");
      System.out.println("    -dequeue/delete (enter the letter d)");
      System.out.println("    -check if the list is empty (enter the letter e)");
      System.out.println("    -print Array (enter the letter p)");
      System.out.println("    -quit (enter the letter q)");

      //setting condition for loop (as long as the user has not pressed q)
      boolean cond = true;

      while (cond)
      {
         System.out.println("Enter menu choice: ");
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
                     //skips whatever else is on the line and the enter key
                     sc.nextLine();
                     que.enqueue(temp);
                     System.out.println(temp + "enqueued");
                  }
                  else
                  {
                     System.out.println("Invalid value for enqueue command.");
                     sc.nextLine();
                  }
                  break;
               case 'd':
                  if (que.isEmpty())
                  {
                     System.out.println("Que is empty.");
                  }
                  else
                     System.out.println(que.dequeue() + "dequeued");
                  }
                  break;
               case 'e':
                  if (que.isEmpty())
                     System.out.println("The queue is empty.");
                  else
                     System.out.println("The queue is NOT empty.");
                  break;
               case 'p':
                  que.printArray();
                  break;
               case 'q':
                  cond = false;
                  System.out.println("Quitting.");
                  System.out.println("The content of the que is: ");
                  while(!que.isEmpty())
                  {
                     System.out.print(que.dequeue() + " ");
                  }
                  System.out.println();
                  break;
               default:
                  System.out.println("Invalid value");
            }
         }
         else
         {
            System.out.println("Invalid menu choice");
         }
      }
   }
}
