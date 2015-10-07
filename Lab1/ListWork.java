import java.util.*;

// By Salonee Thanawala and Atticus Liu

public class ListWork {

   public static <T> boolean search(T[] arr, T target) {
      int length = arr.length;
      int count = 0;
      boolean ret = false;
      while(count < length){
         if(target.equals(arr[count])){
	    ret = true;
         }
         count++;
      }
      return ret;
   }


   public static <T> void print(T[] arr) {
      int length = arr.length;
      int count = 0;
      System.out.print("Your integers: ");
      while(count < length) {
         System.out.println(arr[count]);
         count++;
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Integer[] temp = new Integer[10];
      Integer count = 0;
      System.out.println("Please input 10 integers: ");
      
      while(count < 10){
         try {
            temp[count] = sc.nextInt();
            count++;
         }
         catch (InputMismatchException e)  {
            System.out.println("Integers only! " +  sc.next() + " is not an integer.");            
         }
      }
      sc.nextLine();
      System.out.print("Search for a value: ");

      boolean response = true;

      while(response != false) {
      
         try {
            Integer prompt = sc.nextInt();
	    if (search(temp, prompt) == true) {
               System.out.println("Found.");
            } else {
               System.out.println("Not Found. ");
            }
         }
         catch (InputMismatchException e)   {
            System.out.println("Integers only!");
         }

         System.out.print("search? y/n, lowercase please ");
	 String res = sc.next();
         if (res.equals("y")) {
            System.out.print("Value? ");
         }
         if (res.equals("n")) {
           response = false;
         }
         /*
         else {
	    System.out.print("y or n please.");
         }
         */


      }
      System.out.println("End of program. The following list of 10 integers shoudl be the output: ");
      print(temp);

   }
}
