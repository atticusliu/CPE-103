/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 4 November 2015
 * Project 4
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.util.*;
import java.io.*;

// class for the driver function of the project, contains main method and two helper functions
public class HTDriver
{
    public static void main(String[] args)
    {
        // declare/initialize scanner object for user interaction
        Scanner sc = new Scanner(System.in);
        // declare HashTable object
        HashTable table;

        System.out.println("What is the name of the input file?: ");
        // inputFile holds file name inputted by user
        String inputFile = sc.next();
        sc.nextLine();
        // declare another scanner object for stuff in filename
        Scanner in;
        try {
            // initialize scanner object. If this doesn't work, program will quit (hence the return in the catch)
            in = new Scanner(new File(inputFile));
        } catch(FileNotFoundException ex) {
            System.out.println("Error processing file: " + ex);
            return;
        }
        // N holds number of student objects in file
        int N = in.nextInt();
        in.nextLine();
        int counter = 0;
        // initialize table object now we know we have a valid file
        table = new HashTable(N);
        while(counter < N)
        {
            // rawRecord reads single line from inputted file
            String inputStu = in.nextLine();
            // check if this line holds a valid student object
            isStudent(table, inputStu);
            // increment counter to further the while loop
            counter++;
        }


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

        // boolean variable to continuously prompt user for input
        boolean cond = true;

        while (cond) {
            System.out.print("Enter menu choice: ");
            // choice holds user choice based on menu
            String choice = sc.nextLine();

            if (choice.length() == 1) {
                switch (choice.charAt(0)) {

                    // ADD AN ELEMENT
                    case 'a':
                        System.out.print("Add student element: ");
                        // rawStudent string holds inputted student element
                        String rawStudent = sc.nextLine();
                        if(isStudent(table, rawStudent))
                        {
                            System.out.println("Student added.");
                        }
                        else
                            System.out.println("Invalid record.");
                        break;

                    // DELETE AN ELEMENT
                    case 'd':
                        System.out.print("Insert number: ");
                        // if the user input is actually a long, go on
                        if(sc.hasNextLong())
                        {
                            // longId holds user input's long value
                            long longId = sc.nextLong();
                            sc.nextLine();
                            // stu is a dummy Student object with an id of longInputId, and an
                            // arbitrary last name
                            Student stu = new Student(longId, "Deletesrandomlastname");
                            table.delete(stu);
                            System.out.println("Student " + longId + " deleted.");
                        }
                        else
                        {
                            System.out.println("Invalid ID.");
                            break;
                        }
                        break;

                    // FIND AN ELEMENT
                    case 'f':
                        System.out.print("Insert number: ");
                        // if the user input is actually a long, go on
                        if(sc.hasNextLong())
                        {
                            // longId holds user input's long value
                            long longId = sc.nextLong();
                            sc.nextLine();
                            if(longId > 0)
                            {
                                // stu is a dummy Student object with an id of longInputId, and an
                                // arbitrary last name
                                Student stu = new Student(longId, "Findsrandomlastname");
                                if(table.find(stu) != null)
                                {
                                    System.out.println("Student " + longId + " found.");
                                }
                                else
                                {
                                    System.out.println("Student " + longId + " not found.");
                                }
                            }
                        }
                        else
                        {
                            sc.nextLine();
                            System.out.println("Invalid ID.");
                            break;
                        }

                        break;

                    // GET NUMBER OF ELEMENTS IN COLLECTION
                    case 'n':
                        System.out.println("The number of elements is: " + table.elementCount());
                        break;

                    // CHECK IF COLLECTION IS EMPTY
                    case 'e':
                        if(table.isEmpty())
                        {
                            System.out.println("Table is empty.");
                        }
                        else
                        {
                            System.out.println("Table is not empty.");
                        }
                        break;

                    // MAKE HASH TABLE EMPTY
                    case 'k':
                        table.makeEmpty();
                        System.out.println("Hash table emptied.");
                        break;

                    // PRINT CONTENTS OF HASH TABLE
                    case 'p':
                        table.printTable();
                        break;

                    // OUTPUT ELEMENTS OF COLLECTION
                    case 'o':
                        // create an Iterator object called iter
                        Iterator iter = table.iterator();
                        // while there is still a next element, print the next element
                        while (iter.hasNext())
                        {
                            System.out.println(iter.next());
                        }
                        break;

                    // QUIT THE PROGRAM
                    case 'q':
                        // set cond to false to break out of loop
                        cond = false;
                        System.out.println("Farewell.");
                        break;
                    // default case is to print "Invalid menu choice"
                    default:
                        System.out.println("Invalid menu choice.");
                }
            } else {
                System.out.println("Invalid menu choice.");
            }
        }

    }

    // private helper method that checks if a string is a long
    // if it throws an exception, the string is not a long
    private static boolean isLong(String s)
    {
        try
        {
            Long.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    // private helper method that checks if inputted string called rawStudent is a student
    // if it is  avalid student, the it will be inserted into the table
    private static boolean isStudent(HashTable table, String rawStudent)
    {
        // boolean value called ret is initially set to false, will be returned as true
        // if the string that the student is in is actually a student object
        boolean ret = false;

        String[] recordArray = new String[10];
        // split the rawRecord at white spaces, write to recordArray
        recordArray = rawStudent.split("\\s+");
        // recordArray's length is used in if statement below
        if(isLong(recordArray[0]) && recordArray.length == 2)
        {
            // create id of type long, instead of string
            long id = Long.parseLong(recordArray[0]);
            // create name of type string
            String name = recordArray[1];
            // if the id is valid, continue
            if(id > 0)
            {
                // create new student objected called addStu
                // addStu will be added to table
                Student addStu = new Student(Long.parseLong(recordArray[0]), recordArray[1]);
                table.insert(addStu);
                ret = true;
            }
        }
        return ret;
    }
}