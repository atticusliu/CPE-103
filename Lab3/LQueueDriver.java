import java.util.*;

public class LQueueDriver
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      LQueue<Integer> que = new LQueue<Integer>();

      System.out.println("Choose one of the following operations: ");
      System.out.println("-   enqueue/add (enter the letter a)");
      System.out.println("-   dequeue/delete (enter the letter d)");
      System.out.println("-   check if the list is empty (enter the letter e)");
      System.out.println("-   quit (enter the letter q)");

      boolean cond = true;

      while (cond)
      {
         System.out.println("Enter menu choice: ");
         String in = sc.nextLine();
         
         if(in.length() == 1) {

            switch(in.charAt(0)) {
               case 'a':
                  System.out.println("value: ");
                  if(sc.hasNextInt()){
                     int temp = sc.nextInt();
                     sc.nextLine();
                     que.enqueue(temp);               
                     System.out.println(temp + " enqueued.");
               
                  } else {
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
		  {
                     System.out.println(que.dequeue() + "dequeued.");
		     
		  }
                  break;
               case 'e':
                  if(que.isEmpty())
                     System.out.println("Yes");
                  else
                     System.out.println("No");
                  break;
               case 'q':
                  cond = false;
                  while (!que.isEmpty())
                  {
                    System.out.print(que.dequeue() + " ");
                  }
	          System.out.println(); 
                  break;
               default:
                  System.out.println("Invalid value");
                  // PRINT OUT QUEUE   
            }
         } else {
              System.out.println("Invalid menu value");
         }
      }

   }
}
