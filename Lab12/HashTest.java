import java.lang.System;
import java.util.*;

public class HashTest {
    public static void main(String[] args)
    {
        System.out.println("Size of table?");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        HashTableSC<Integer> t = new HashTableSC<Integer>(size);

        System.out.println("Choose one of the following operations: ");
        System.out.println("    -add/insert (enter the letter a)");
        System.out.println("    -find (enter the letter f)");
        System.out.println("    -delete (enter the letter d)");
        System.out.println("    -is empty (enter the letter e)");
        System.out.println("    -print (enter the letter p)");
        System.out.println("    -quit (enter the letter q)");

        boolean cond = true;

        while(cond) {
            System.out.println("Enter menu choice: ");
            String in = sc.nextLine();

            if (in.length() == 1) {
                switch (in.charAt(0)) {
                    case 'a':
                        System.out.println("Value: ");
                        if (sc.hasNextInt()) {
                            int value = sc.nextInt();
                            t.insert(value);
                            System.out.println(value + " is added.");
                        } else {
                            System.out.println("Invalid value.");
                            sc.nextLine();
                        }
                        break;
                    case 'd':
                        System.out.println("Value: ");
                        if (!t.isEmpty()) {
                            int delValue = sc.nextInt();
                            t.delete(delValue);
                            System.out.println(delValue + " deleted");
                        } else {
                            System.out.println("Invalid value");
                            sc.nextLine();
                        }
                        break;
                    case 'e':
                        if (t.isEmpty())
                            System.out.println("Table is empty");
                        else
                            System.out.println("The table is not empty");
                        break;
                    case 'p':
                        if (!t.isEmpty())
                            t.print();
                        else
                            System.out.println("Nothing in list");
                        break;
                    case 'q':
                        cond = false;
                        System.out.println("Quitting.");
                        break;
                    default:
                        System.out.println("Invalid value");
                }
            } else {
                System.out.println("Invalid menu choice");
            }
        }

    }
}