import java.lang.System;
import java.util.*;

public class MyListDriver
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        MySortedList l = new MySortedList();

        System.out.println("Choose one of the following operations: ");
        System.out.println("    -add (enter the letter a)");
        System.out.println("    -delete (enter the letter d)");
        System.out.println("    -find max (enter the letter x)");
        System.out.println("    -find min (enter the letter m)");
        System.out.println("    -print (enter the letter p)");
        System.out.println("    -is empty (enter the letter e)");
        System.out.println("    -quit (enter the letter q)");

        //setting condition for loop (as long as the user has not pressed q)
        boolean cond = true;
        while(cond) {
            System.out.println("Enter menu choice: ");
            String in = sc.nextLine();

            if (in.length() == 1) {
                switch (in.charAt(0)) {
                    case 'a':
                        System.out.println("Value: ");
                        if (sc.hasNextInt()) {
                            int temp = sc.nextInt();
                            sc.nextLine();
                            l.add(temp);
                            System.out.println(temp + " added.");
                        } else {
                            System.out.println("Invalid value for add command.");
                            sc.nextLine();
                        }
                        break;
                    case 'd':
                        if (l.isEmpty()) {
                            System.out.println("List is empty, can't delete anything.");
                        } else {
                            System.out.println(l.delete() + " deleted.");
                        }
                        break;
                    case 'x':
                        if (l.isEmpty()) {
                            System.out.println("List is empty, can't find max value.");
                        } else {
                            System.out.println(l.max() + " is the max value.");
                        }
                        break;
                    case 'm':
                        if (l.isEmpty()) {
                            System.out.println("List is empty, can't find min value.");
                        } else {
                            System.out.println(l.min() + " is the min value.");
                        }
                        break;
                    case 'p':
                        l.print();
                        break;
                    case 'e':
                        if (l.isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            System.out.println("List is not empty.");
                        }
                        break;
                    case 'q':
                        cond = false;
                        System.out.println("Quitting.");
                        break;
                    default:
                        System.out.println("Invalid value");
                        break;
                }
            } else {
                System.out.println("Invalid menu choice.");
            }
        }
    }
}