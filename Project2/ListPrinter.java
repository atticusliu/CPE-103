/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 19 October 2015
 * Project 2
 */

import java.lang.Long;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

// class that serves as client class--works with Student.jaa
public class ListPrinter
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

    // main method where file reading, client interaction, displaying student records happens
    public static void main(String[] args)
    {
        // new scanner object
        Scanner sc = new Scanner(System.in);
        // new heap of type Student
        BinHeap<Student> heap = new BinHeap<Student>();

        System.out.println("Type the name of the file where student records will be stored: ");
        // store name of file--if appropriate file name isn't inputted, error handled in catch
        String filename = sc.next();
        // just a next line
        sc.nextLine();

        try
        {
            // reader is FileReader object
            FileReader reader = new FileReader(filename);
            // scanner in is new Scanner that takes in reader
            Scanner in = new Scanner(reader);

            // goes until end of file is reached
            while(in.hasNext())
            {
                // rawRecord reads single line from inputted file
                String rawRecord = in.nextLine();
                // create temporary recordArray of an arbitrary size
                String[] recordArray = new String[10];
                // split the rawRecord at white spaces, write to recordArray
                recordArray = rawRecord.split("\\s+");
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
                        heap.insert(stu);
                    }
                }
            }
            // create count that is for display purposes
            int count = 1;
            // make sure heap is not empty
            while(heap.size() != 0)
            {
                System.out.println(count + ". " + heap.deleteMin());
                // increment count
                count++;
            }
        } catch(IOException ex)
        {
            System.out.println("Error processing file: " + ex);
        }
    }
}