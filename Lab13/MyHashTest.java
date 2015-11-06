import java.lang.System;
import java.util.*;

public class MyHashTest {
    public static void main(String[] args)
    {
        System.out.println("Size of table?");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        MyHashTable<Integer> t = new MyHashTable<Integer>(size);

        System.out.println("Choose one of the following operations: ");
        System.out.println("    -add/insert (enter the letter a)");
        System.out.println("    -find (enter the letter f)");
        System.out.println("    -delete (enter the letter d)");
        System.out.println("    -is empty (enter the letter e)");
        System.out.println("    -print (enter the letter p)");
        System.out.println("    -make empty (enter the letter k)");
        System.out.println("    -size (enter the letter s)");
        System.out.println("    -output the collection (enter the letter o)");
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
                    case 'k':
                        t.makeEmpty();
                        System.out.println("The table has been made empty");
                        break;
                    case 's':
                        System.out.println("The size of the table is: " + t.size());
                        break;
                    case 'o':
                        Iterator<Integer> iter = t.iter();
                        while (iter.hasNext())
                            System.out.print(iter.next() + " ");
                        System.out.println();
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