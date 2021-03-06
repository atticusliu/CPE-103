/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 29 October 2015
 * Project 3
 */


import java.io.*;
import java.lang.System;
import java.util.*;

// class to implement DictionaryMaker, which takes in an input text file
// and writes all unique values to outputted text file
public class DictionaryMaker
{
    // main function to perform all necessary operations for DictionaryMaker
    public static void main(String[] args)
    {
        // asking user for input file and saving the file in a temp variable inputFile
        System.out.println("What is the name of the input file?: ");
        // create a scanner that reads in what user gave
        Scanner sc = new Scanner(System.in);
        // inputFile now contains the string of what file the user has to read from
        String inputFile = sc.next();
        sc.nextLine();

        try {
            // create a reader object that will read  from the input file
            FileReader reader = new FileReader(inputFile);
            // create a scanner object which will read each text from the input file
            Scanner s = new Scanner(reader);
            System.out.println("What is the name of the output file?: ");
            // gets name for output file and sets up file for outputting
            String outputFile = sc.next();

            // create a PrintWrite object that will write to the output file
            PrintWriter out = new PrintWriter(outputFile);
            // BST object containing all the distinct words in collection
            BST<String> wordTree = new BST<String>();


            // creating an array of all the words in the input file
            String temp = "";

            while (s.hasNext())
            {
                temp = s.next();
                if (!wordTree.find(temp))
                    wordTree.insert(temp);

            }


            Iterator<String> i = wordTree.iteratorIn();
            while (i.hasNext())
            {
                out.print(i.next() + "\n");
            }

            // when finished writing to the file, close the PrintWriter
            out.close();
        } catch(IOException ex)
        {
            System.out.println("Error processing file: " + ex);
        }
    }
}