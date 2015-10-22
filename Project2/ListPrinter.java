/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 19 October 2015
 * Project 2
 */

import java.lang.reflect.Array;
import java.util.*;

public class ListPrinter
{
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
                // make sure id is greater than 0
                // make sure there are only 2 values on a line

                long tempId = in.nextLong()
                if(tempId > 0 && )

            }

        } catch(IOException ex){
            System.out.println("Error processing file: " + ex);
        }

    }
}