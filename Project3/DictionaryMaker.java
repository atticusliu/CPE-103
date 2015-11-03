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
            sc.nextLine();
            // create a PrintWrite object that will write to the output file
            PrintWriter out = new PrintWriter(outputFile);
            // BST object containing all the distinct words in collection
            BST<String> wordTree = new BST<String>();
            // create a string array to store all the words
            String[] collectionWords = new String[100];
            // creating an array of all the words in the input file
            String temp = "";

            while (s.hasNextLine())
            {
                temp = temp + " " + s.nextLine();
            }
            // split the words into the array collectionWords
            collectionWords = temp.split("\\s+");

            // finding if the word is in the tree, if not add to tree
            for (int i = 0; i < collectionWords.length; i++)
            {
                if (!wordTree.find(collectionWords[i]))
                    wordTree.insert(collectionWords[i]);
            }

            Iterator<String> i = wordTree.iteratorIn();
            while (i.hasNext())
            {
                out.println(i.next());
            }

            // when finished writing to the file, close the PrintWriter
            out.close();
        } catch(IOException ex)
        {
            System.out.println("Error processing file: " + ex);
        }
    }
}