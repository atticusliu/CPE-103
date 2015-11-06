/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 4 November 2015
 * Project 4
 */

import java.util.*;

public class HTDriver
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the name of the input file?: ");
        //store name of input file
        String inputFile = sc.next();
        sc.nextLine();
        //make arrangements for File Input-defining scanner or file input stream

        //read integer stored on first line (N)

        //create a hash table with N elements in collection (not table size!)

        //read exactly N lines from file - not including first line

        //read line by line and creating student objects for each. insert each student into hash table (make sure valid choice)

        //Choose one of the following operations by entering provided letter: a - add the element
        System.out.println("Choose one of the following operations by entering provided letter: ");
        System.out.println("    a - add the element ");
        System.out.println("    d - delete the element");
        System.out.println("    f - find and retrieve the element");
        System.out.println("    n - get the number of elements in the collection");
        System.out.println("    e - check if the collection is empty");
        System.out.println("    k - make the hash table empty");
        System.out.println("    p - print the content of the hash table");
        System.out.println("    o - output the elements of the collection");
        System.out.println("    q - Quit the program");

        boolean cond = true;

        while (cond) {
            System.out.print("Enter menu choice: ");
            String in = sc.nextLine();

            if (in.length() == 1) {
                switch (in.charAt(0)) {

                    // ADD AN ELEMENT
                    case 'a':
                        System.out.print("Value: ");
                        break;

                    // DELETE AN ELEMENT
                    case 'd':
                        System.out.print("Value: ");
                        break;

                    // FIND AN ELEMENT
                    case 'f':
                        System.out.print("Value: ");
                        break;

                    // GET NUMBER OF ELEMENTS IN COLLECTION
                    case 'n':
                        break;

                    // CHECK IF COLLECTION IS EMPTY
                    case 'e':
                        break;

                    // MAKE HASH TABLE EMPTY
                    case 'k':
                        break;

                    // PRINT CONTENTS OF HASH TABLE
                    case 'p':
                        break;

                    // OUTPUT ELEMENTS OF COLLECTION
                    case 'o':
                        break;

                    // QUIT THE PROGRAM
                    case 'q':
                        // set cond to false to break out of loop
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