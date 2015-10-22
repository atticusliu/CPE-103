/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 19 October 2015
 * Project 2
 */

import java.util.*;
import java.util.InputMismatchException;

public class HeapTest
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int size = 0;

        // handle user input of size of heap
        boolean condInt = true;
        while(condInt)
        {
            System.out.println("Insert initial size of heap: ");
            if(sc.hasNextInt())
            {
                size = sc.nextInt();
                condInt = false;
            }
            else
            {
                System.out.println("Invalid value.");
            }
            sc.nextLine();
        }


        BinHeap<String> heap = new BinHeap<String>(size);

        System.out.println("Choose one of the following operations: ");
        System.out.println("- add an element (enter the letter a)");
        System.out.println("- delete the smallest element (enter the letter d)");
        System.out.println("- is the heap empty (enter the letter e)");
        System.out.println("- size of the collection (enter the letter s)");
        System.out.println("- print the collection (enter the letter p)");
        System.out.println("- Quit (enter the letter q)");

        // cond is boolean for while loop
        boolean cond = true;

        while (cond)
        {
            System.out.println("Enter menu choice: ");
            String in = sc.nextLine();
            if (in.length() == 1)
            {
                switch (in.charAt(0))
                {
                    case 'a':
                        System.out.println("Insert value to be added: ");
                        if (sc.hasNext())
                        {
                            String temp = sc.next();
                            heap.insert(temp);
                            System.out.println(temp + " added.");
                        }
                        else
                        {
                            System.out.println("Invalid value for add command.");
                        }
                        sc.nextLine();
                        break;
                    case 'd':
                        if(heap.isEmpty())
                        {
                            System.out.println("Can't delete smallest element, heap is empty.");
                        }
                        else
                        {
                            System.out.println(heap.deleteMin() + " deleted.");
                        }
                        break;
                    case 'e':
                        if(heap.isEmpty())
                        {
                            System.out.println("Heap is empty.");
                        }
                        else
                        {
                            System.out.println("Heap is not empty.");
                        }
                        break;
                    case 's':
                        System.out.println("The size is " + heap.size());
                        break;
                    case 'p':
                        System.out.println(heap.toString());
                        break;
                    case 'q':
                        cond = false;
                        System.out.println("Quitting.");
                        break;
                    default:
                        System.out.println("Invalid menu value.");
                        break;
                }
            }
            else
            {
            System.out.println("Invalid menu choice.");
            }
        }
    }
}