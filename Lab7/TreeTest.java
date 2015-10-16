import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.Integer;
import java.lang.NumberFormatException;
import java.util.*;

public class TreeTest
{
    public static void main(String[] args)
    {
        Integer[] heapArray = new Integer[20];
        String[] tempArray = new String[20];
        Scanner sc = new Scanner(System.in);

        System.out.print("Input: " );
        while(sc.hasNextLine())
        {

            String input = sc.nextLine();
            try {
                System.out.println();
                tempArray = input.split("\\s+");

                int count = 0;
                try
                {
                    while (count < tempArray.length) {
                        heapArray[count] = Integer.parseInt(tempArray[count]);
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    while (count < 20) {
                        heapArray[count] = Integer.parseInt(tempArray[count]);
                        count++;
                    }
                }

                // in case there are more than 20 elements
                if(tempArray.length > 20)
                {
                    if (TreeWork.isHeap(heapArray, 20))
                        System.out.println("Heaptest: IS a heap.");
                    else
                        System.out.println("Heaptest: is NOT a heap");
                    TreeWork.printTree(heapArray, 20);
                }
                else
                {
                    if (TreeWork.isHeap(heapArray, tempArray.length))
                        System.out.println("Heaptest: IS a heap.");
                    else
                        System.out.println("Heaptest: is NOT a heap");
                    TreeWork.printTree(heapArray, tempArray.length);
                }

                System.out.print("Input: ");
            }
            catch (NumberFormatException e) {
                System.out.println("The tree is empty");
                System.out.print("Input: ");
            }
        }
    }
}