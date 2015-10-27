import java.lang.System;
import java.util.*;

public class BSTWork
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BasicBST bst = new BasicBST();

        System.out.println("Choose one of the following operations: ");
        System.out.println("    -add/insert (enter the letter a)");
        System.out.println("    -count odds (enter the letter o)");
        System.out.println("    -get height (enter the letter h)");
        System.out.println("    -count leaves (enter the letter l)");
        System.out.println("    -count one-child nodes(enter the letter c)");
        System.out.println("    -quit (enter the letter q)");

        //setting condition for loop (as long as the user has not pressed q)
        boolean cond = true;
        while (cond) {
            System.out.println("Enter menu choice: ");
            String in = sc.nextLine();

            if (in.length() == 1)
            {
                switch (in.charAt(0))
                {
                    case 'a':
                        // integers?!
                        System.out.println("Value: ");
                        if (sc.hasNextInt()) {
                            int temp = sc.nextInt();
                            sc.nextLine();
                            bst.insert(temp);
                            System.out.println(temp + " added.");
                        } else {
                            System.out.println("Invalid value for add command.");
                            sc.nextLine();
                        }
                        break;
                    case 'o':
                        System.out.println("Number of odd values: " + bst.countOdds());
                        break;
                    case 'h':
                        System.out.println("Height of BST: " + bst.height());
                        break;
                    case 'l':
                        System.out.println("Number of leaves: " + bst.countLeaves());
                        break;
                    case 'c':
                        System.out.println("Number of one-child nodes: " + bst.countOneChildParents());
                        break;
                    case 'q':
                        cond = false;
                        System.out.println("Quitting.");
                        break;
                    default:
                        System.out.println("Invalid value");
                        break;
                }
            }
        }
    }
}