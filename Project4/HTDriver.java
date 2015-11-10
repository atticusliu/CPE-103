/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 4 November 2015
 * Project 4
 */

import java.util.*;
import java.io.*;
import java.util.Hashtable;

public class HTDriver
{
    // private helper method that checks if a string is a long
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

    private static boolean isStudent(String rawStudent)
    {
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
                ret = true;
        }
        return ret;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("What is the name of the input file?: ");
            // gets name for output file and sets up file for outputting
            String inputFile = sc.next();
            sc.nextLine();
            // create a reader object that will read  from the input file
            FileReader reader = new FileReader(inputFile);
            // create a scanner object which will read each text from the input file
            Scanner in = new Scanner(reader);

            int N = in.nextInt();
            //HashTable<Student> ht = new HashTable<Student>(N);
            int counter = 0;
            while(counter < N)
            {
                // rawRecord reads single line from inputted file
                String inputStu = in.nextLine();
                // create temporary recordArray of an arbitrary size
                String[] recordArray = new String[10];
                // split the rawRecord at white spaces, write to recordArray
                recordArray = inputStu.split("\\s+");
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
                        // create student object
                        Student stu = new Student(id, name);
                        // insert student object into heap
                        //ht.insert(stu);
                    }
                }
                counter++;
            }

        } catch(IOException ex)
        {
            System.out.println("Error processing file: " + ex);
        }

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
                        System.out.print("Add student element: ");
                        String rawStudent = sc.nextLine();
                        if(isStudent(rawStudent))
                            System.out.println("Student added.");
                        else
                            System.out.println("Invalid record.");
                        break;

                    // DELETE AN ELEMENT
                    case 'd':
                        System.out.print("Insert number: ");
                        String inputId = sc.nextLine();
                        if(isLong(inputId))
                        {
                            long longInputId = Long.parseLong(inputId);
                        }

                        else
                        {
                            System.out.println("Invalid ID.");
                            break;
                        }
                        Student stu = new Student(longInputId, "Randomlastname");
                        //ht.delete(stu);
                        System.out.println("Student " + longInputId + " deleted.");
                        break;

                    // FIND AN ELEMENT
                    case 'f':
                        System.out.print("Insert number: ");
                        String inputId = sc.nextLine();
                        if(isLong(inputId))
                        {
                            long longInputId = Long.parseLong(inputId);
                        }
                        else
                        {
                            System.out.println("Invalid ID.");
                            break;
                        }
                        Student stu = new Student(longInputId, "Randomlastname");
                        if(ht.find(stu))
                        {
                            System.out.println("Student with ID of " + longInputId + " found.");
                        }
                        else
                        {
                            System.out.println("Student with ID of " + longInputId + " not found.");
                        }
                        break;

                    // GET NUMBER OF ELEMENTS IN COLLECTION
                    case 'n':
                        System.out.println("The number of elements is: " + ht.elementCount());
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