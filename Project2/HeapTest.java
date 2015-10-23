/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 19 October 2015
 * Project 2
 */

import java.util.*;
import java.util.InputMismatchException;

// class for HeapTest, where prompting and interfacing is done
public class HeapTest
{
    // main method, where prompting and interfacing is mainly done
    public static void main(String[] args)
    {
        // new scanner object
        Scanner sc = new Scanner(System.in);
        // set size to 0
        int size = 0;

        // handle user input of size of heap
        // condInt is boolean variable to help make sure program doesn't crash when
        // invalid size is inputted
        boolean condInt = true;
        while(condInt)
        {
            System.out.println("Insert initial size of heap: ");
            // look for an int
            if(sc.hasNextInt())
            {
                // set size to be inputted int
                size = sc.nextInt();
                // done looking for size, break out of loop
                condInt = false;
            }
            // program did not get an int
            else
            {
                System.out.println("Invalid value.");
            }
            // loop back and give user another try
            sc.nextLine();
        }

        // creating a heap of size "size"
        BinHeap<String> heap = new BinHeap<String>(size);

        // options
        System.out.println("Choose one of the following operations: ");
        System.out.println("- add an element (enter the letter a)");
        System.out.println("- delete the smallest element (enter the letter d)");
        System.out.println("- is the heap empty (enter the letter e)");
        System.out.println("- size of the collection (enter the letter s)");
        System.out.println("- print the collection (enter the letter p)");
        System.out.println("- Quit (enter the letter q)");

        // cond is boolean for big while loop below
        boolean cond = true;

        while (cond)
        {
            System.out.println("Enter menu choice: ");
            // variable "in" will hold menu choice
            String in = sc.nextLine();
            // making sure menu choice was only a letter
            if (in.length() == 1)
            {
                switch (in.charAt(0))
                {
                    case 'a':
                        System.out.println("Insert value to be added: ");
                        // look for value
                        if (sc.hasNext())
                        {
                            // get value, store in temp
                            String temp = sc.next();
                            // insert temp in heap
                            heap.insert(temp);
                            System.out.println(temp + " added.");
                        }
                        // handle when user did not input appropriate value
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
            // handle invalid menu choice
            else
            {
            System.out.println("Invalid menu choice.");
            }
        }
    }
}