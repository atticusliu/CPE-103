/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 19 October 2015
 * Project 2
 */

import java.util.*;

// create class for Student object, implement Comparable
public class Student implements Comparable<Student>
{
    // declare id
    private long id;
    // declare lastName
    private String lastName;

    // constructor that takes in id and lastName
    public Student(long id, String lastName)
    {
        // reaffirming, standard constructor operation
        this.id = id;
        // reaffirming, standard constructor operation
        this.lastName = lastName;
    }

    // method that compares current student to other student
    public int compareTo(Student other)
    {
        // if "this" id is SMALLER than other's id
        int ret = 0;
        if(this.id < other.id)
            ret = -1;
        // if "this" id is LARGER than other's id
        else if(this.id > other.id)
            ret = 1;
        // if "this" id is EQUAL to id
        else if(this.id == other.id)
            ret = 0;
        return ret;
    }

    // toString method that displays student information in manner specified
    public String toString()
    {
        return "{ id: " + this.id + ", name: " + this.lastName + " }";
    }
}