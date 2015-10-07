import java.util.*;

public class Separator {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = 5;
      int[] intArray = new int[n];
      float[] floatArray = new float[n];

      //ArrayList<Integer> intArray = new ArrayList<Integer>();
      //ArrayList<Float> floatArray = new ArrayList<Float>();

      System.out.print("Please input numbers: ");

/*
      for (int i = 0; i < n;) {
         if(sc.hasNextInt() == true){
            intArray[i] = sc.nextInt();
            i++;
         } if (sc.hasNextFloat() == true) {
            floatArray[i] = sc.nextFloat();
            i++;
         } else {
            i = i;
         }
      }
*/
         
      int count = 0;
      int count1 = 0;

      while(sc.hasNext()) {
         
         if(sc.hasNextInt()) {
            if(count < n) {
               intArray[count] = sc.nextInt();
               count++;
            } else {
               break;
            }
         } else if(sc.hasNextFloat()) {
              if(count1 < n) {
                 floatArray[count1] = sc.nextFloat();
                 count1++;
              } else {
                 break;
              }
         } else {
            break;
         }
      }
 
      int c = 0;
      int c1 = 0;

      /* printing out array */ 
      System.out.print("Integers: ");
      while (c < count) {
         System.out.print(intArray[c] + " ");
         c++;
      }
      System.out.println();
      System.out.print("Floats: ");

      while (c1 < count1) {
         System.out.print(floatArray[c1] + " ");
         c1++;
      }
      System.out.println(); 
   }

}
