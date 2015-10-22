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

public class ListPrinter
{
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

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        BinHeap<Student> heap = new BinHeap<Student>();

        System.out.println("Type the name of the file where student records will be stored: ");
        String filename = sc.next();
        sc.nextLine();

        try
        {
            FileReader reader = new FileReader(filename);
            Scanner in = new Scanner(reader);

            // goes until end of file is reached
            while(in.hasNext())
            {
                String rawRecord = in.nextLine();
                String[] recordArray = new String[10];
                recordArray = rawRecord.split("\\s+");
                if(isLong(recordArray[0]) && recordArray.length == 2)
                {
                    long id = Long.parseLong(recordArray[0]);
                    String name = recordArray[1];
                    if(id > 0)
                    {
                        // READ SPEC AND GET BACK HERE
                        // create student object
                        Student stu = new Student(id, name);
                        System.out.println(stu.toString());
                    }

                }



            }

        } catch(IOException ex)
        {
            System.out.println("Error processing file: " + ex);
        }

    }


}