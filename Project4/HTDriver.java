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

public class HTDriver
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        HashTable table;

        System.out.println("What is the name of the input file?: ");
        String inputFile = sc.next();
        sc.nextLine();
        Scanner in;
        try {
            in = new Scanner(new File(inputFile));
        } catch(FileNotFoundException ex) {
            System.out.println("Error processing file: " + ex);
            return;
        }

        int N = in.nextInt();
        in.nextLine();
        int counter = 0;
        table = new HashTable(N);
        while(counter < N)
        {
            // rawRecord reads single line from inputted file
            String inputStu = in.nextLine();
            isStudent(table, inputStu);
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


        boolean cond = true;

        while (cond) {
            System.out.print("Enter menu choice: ");
            String choice = sc.nextLine();

            if (choice.length() == 1) {
                switch (choice.charAt(0)) {

                    // ADD AN ELEMENT
                    case 'a':
                        System.out.print("Add student element: ");
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
                        String inputId = sc.nextLine();
                        if(isLong(inputId))
                        {
                            long longInputId = Long.parseLong(inputId);
                            Student stu = new Student(longInputId, "Randomlastname");
                            table.delete(stu);
                            System.out.println("Student " + longInputId + " deleted.");
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
                        //inputId = sc.nextLine();
                        if(sc.hasNextLong())
                        {
                            //long longInputId = Long.parseLong(inputId);
                            long longId = sc.nextLong();
                            sc.nextLine();
                            if(longId > 0)
                            {
                                Student stu = new Student(longId, "Randomlastname");
                                if(table.find(stu) != null)
                                {
                                    System.out.println("Student " + stu + " found.");
                                }
                                else
                                {
                                    System.out.println("Student " + longId + " not found.");
                                }
                            }
                            else
                            {
                                System.out.println("Invalid ID.");
                                break;
                            }
                        }
                        else
                        {
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
                        Iterator iter = table.iterator();
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
                    default:
                        System.out.println("Invalid menu choice.");
                }
            } else {
                System.out.println("Invalid menu choice.");
            }
        }

    }

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

    private static boolean isStudent(HashTable table, String rawStudent)
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
            {
                Student addStu = new Student(Long.parseLong(recordArray[0]), recordArray[1]);
                table.insert(addStu);
                ret = true;
            }
        }
        return ret;
    }
}