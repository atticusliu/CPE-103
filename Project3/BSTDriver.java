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
    public static void main(String[] args) {
        // new scanner object
        Scanner sc = new Scanner(System.in);
        BST<Integer> binTree = new BST<Integer>();

        System.out.println("Choose one of the following operations by entering provided letter: ");
        System.out.println("     a - add the element");
        System.out.println("     d - delete the element");
        System.out.println("     f - find the element");
        System.out.println("     e - check if the tree is empty");
        System.out.println("     k - make the tree empty");
        System.out.println("     n - get the number of nodes (the size) of the tree");
        System.out.println("     m - find the mimimal element");
        System.out.println("     x - find the maximal element");
        System.out.println("     p - print the tree in preorder using iterator");
        System.out.println("     i - print the tree in inorder using iterator");
        System.out.println("     l - print the tree in levelorder using iterator");
        System.out.println("     t - print the tree using printTree");
        System.out.println("     o - output the tree using toString");
        System.out.println("     q - quit the program");

        boolean cond = true;


        while (cond) {
            System.out.print("Enter menu choice: ");
            String in = sc.nextLine();

            if (in.length() == 1) {
                switch (in.charAt(0)) {


                    // ADD AN ELEMENT
                    case 'a':
                        System.out.print("Value: ");
                        if (sc.hasNextInt()) {
                            int temp = sc.nextInt();
                            sc.nextLine();
                            binTree.insert(temp);
                            System.out.println(temp + " added.");
                        } else {
                            System.out.println("Invalid value for command.");
                            sc.nextLine();
                        }
                        break;

                    // DELETE AN ELEMENT
                    case 'd':
                        System.out.print("Value: ");
                        if (sc.hasNextInt()) {
                            int temp = sc.nextInt();
                            sc.nextLine();
                            binTree.delete(temp);
                            System.out.println(temp + " deleted.");
                        } else {
                            System.out.println("Invalid value for command.");
                            sc.nextLine();
                        }
                        break;

                    // FIND AN ELEMENT
                    case 'f':
                        System.out.print("Value: ");
                        if (sc.hasNextInt()) {
                            int temp = sc.nextInt();
                            sc.nextLine();
                            if (binTree.find(temp))
                                System.out.println(temp + " found.");
                            else
                                System.out.println("Not found.");
                        } else {
                            System.out.println("Invalid value for command.");
                            sc.nextLine();
                        }
                        break;

                    // CHECK IF TREE IS EMPTY
                    case 'e':
                        if (binTree.isEmpty())
                            System.out.println("Tree is empty.");
                        else
                            System.out.println("Tree is not empty.");
                        break;

                    // MAKE TREE EMPTY
                    case 'k':
                        binTree.makeEmpty();
                        System.out.println("Tree is made empty.");
                        break;

                    // GET NUMBER OF NODES IN TREE
                    case 'n':
                        System.out.println("There are " + binTree.size() + " nodes in the tree.");
                        break;

                    // FIND MINIMAL ELEMENT
                    case 'm':
                        System.out.println("The minimal element in the tree is " + binTree.findMinimum());
                        break;

                    // GET MAXIMAL ELEMENT
                    case 'x':
                        System.out.println("The maximal element in the tree is " + binTree.findMaximum());
                        break;

                    // PRINT TREE IN PREORDER (ITERATOR)
                    case 'p':
                        Iterator<Integer> preIter = binTree.iteratorPre();
                        while (preIter.hasNext())
                            System.out.println(preIter.next());
                        break;

                    // PRINT TREE IN INORDER (ITERATOR)
                    case 'i':
                        Iterator<Integer> inIter = binTree.iteratorIn();
                        while (inIter.hasNext())
                        {
                            System.out.println("FETTY");
                            System.out.println(inIter.next());
                        }

                        break;

                    // PRINT TREE IN LEVELORDER (ITERATOR)
                    case 'l':
                        Iterator<Integer> levelIter = binTree.iteratorLevel();
                        while (levelIter.hasNext())
                            System.out.println(levelIter.next());
                        break;

                    // PRINT TREE USING printTree()
                    case 't':
                        binTree.printTree();
                        System.out.println();
                        break;

                    // OUTPUT TREE USING toString()
                    case 'o':
                        System.out.println("Tree: " + binTree.toString());
                        break;

                    // QUIT THE PROGRAM
                    case 'q':
                        cond = false;
                        System.out.println("Farewell.");
                        break;
                    default:
                        System.out.println("Invalid menu choice.");
                }
            } else {
                System.out.println("Invalid menu choice.");
            }
        }
    }
}