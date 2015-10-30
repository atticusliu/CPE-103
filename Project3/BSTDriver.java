/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 29 October 2015
 * Project 3
 */

import java.util.*;

public class BSTDriver
{
    public static void main(String[] args)
    {
        // new scanner object
        Scanner sc = new Scanner(System.in);
        BST<Integer> binTree = new BST<Integer>();

        System.out.println("Choose one of the following operations by entering provided letter: ");
        System.out.println("     a - add the element");
        System.out.println("     d - delete the element");
        System.out.println("     f - find the element");
        System.out.println("     e - check if the tree is empty");
        System.out.println("     k - make the tree empty");
        System.out.println("     n - get the number of nodes(the size) of the tree");
        System.out.println("     m - find the mimimal element");
        System.out.println("     x - find the maximal element");
        System.out.println("     p - print the tree in preorder using iterator");
        System.out.println("     i - print the tree in inorder using iterator");
        System.out.println("     l - print the tree in levelorder using iterator");
        System.out.println("     t - print the tree using printTree");
        System.out.println("     o - output the tree using toString");
        System.out.println("     q - quit the program");

        boolean cond = true;


        while(cond)
        {
            System.out.println("Enter menu choices");
            String in = sc.nextLine();

            if(in.length() == 1)
            {
                switch(in.charAt(0))
                {
                    case 'a':
                        System.out.println("Value: ");
                        if (sc.hasNextInt())
                        {
                            int temp = sc.nextInt();
                            sc.nextLine();
                            binTree.insert(temp);
                            System.out.println(temp + "added");
                        }
                        else {
                            System.out.println("Invalid value for command");
                            sc.nextLine();
                        }
                        break;
                    case 'd':
                        System.out.println("Value: ");
                        if (sc.hasNextInt())
                        {
                            int temp = sc.nextInt();
                            sc.nextLine();
                            binTree.delete(temp);
                            System.out.println(temp + "deleted");
                        }
                        else {
                            System.out.println("Invalid value for command");
                            sc.nextLine();
                        }
                        break;
                    case 'f':
                        System.out.println("Value: ");
                        if (sc.hasNextInt())
                        {
                            int temp = sc.nextInt();
                            sc.nextLine();
                            if (binTree.find(temp))
                                System.out.println(temp + "found");
                            else
                                System.out.println("Not found");
                        }
                        else {
                            System.out.println("Invalid value for command");
                            sc.next
                        break;
                    case 'e':
                        break;
                    case 'k':
                        break;
                    case 'n':
                        break;
                    case 'm':
                        break;
                    case 'x':
                        break;
                    case 'p':
                        break;
                    case 'i':
                        break;
                    case 'l':
                        break;
                    case 't':
                        break;
                    case 'o':
                        break;
                    case 'q':
                        cond = false;
                        System.out.println("Farewell.");
                        break;
                    default:
                        System.out.println("Invalid menu choice");
                }
            }
        }


    }