import java.lang.System;
import java.util.*;

public class HashTest {
    public static void main(String[] args)
    {
        System.out.println("Size of table?");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
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
            System.out.print("Enter menu choice: ");
            String in = sc.nextLine();

            if (in.length() == 1) {
                switch (in.charAt(0)) {
                    case 'a':
                        System.out.print("Value: ");
                        if (sc.hasNextInt()) {
                            int value = sc.nextInt();
                            t.insert(value);
                            System.out.println(value + " is added.");
                            sc.nextLine();
                        } else {
                            System.out.println("Invalid value.");
                            sc.nextLine();
                        }
                        break;
                    case 'd':
                        System.out.print("Value: ");
                        int delValue = sc.nextInt();
                        t.delete(delValue);
                        System.out.println(delValue + " deleted");
                        sc.nextLine();

                        /*
                        if (!t.isEmpty()) {
                            int delValue = sc.nextInt();
                            t.delete(delValue);
                            System.out.println(delValue + " deleted");
                            sc.nextLine();
                        } else {
                            System.out.println("Invalid value");
                            sc.nextLine();
                        }
                        */
                        break;
                    case 'e':
                        if (t.isEmpty())
                            System.out.println("Table is empty");
                        else
                            System.out.println("The table is not empty");
                        break;
                    case 'p':
                        t.print();
                        break;
                    case 'f':
                        System.out.print("Value: ");
                        if (sc.hasNextInt()) {
                            // new integer temp to hold inputted value
                            int temp = sc.nextInt();
                            sc.nextLine();
                            if (t.find(temp))
                                System.out.println(temp + " found.");
                            else
                                System.out.println("Not found.");
                        }
                        else {
                            System.out.println("Invalid value for command.");
                            sc.nextLine();
                        }
                        break;
                    case 'q':
                        cond = false;
                        System.out.println("Quitting.");
                        break;
                    default:
                        System.out.println("Invalid menu choice");
                }
            } else {
                System.out.println("Invalid menu choice");
            }
        }

    }
}