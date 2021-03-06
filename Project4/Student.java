/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 4 November 2015
 * Project 4
 */

import java.util.*;
import java.lang.*;

//represents a student's information record which contains a student's ID and their last name
public class Student
{
    //two private instance variables
    private long id;            //Student's id
    private String lastName;     //Student's last name with no spaces

    //constructor
    public Student(long id, String lastName)
    {
        this.id = id;
        this.lastName = lastName;
    }

    //methods
    //compares if the two id's are the same
    public boolean equals(Object other)
    {
        return this.id == ((Student) other).id;
    }

    //returns a string containing id and name of student
    public String toString()
    {
        return "{ id: " + id + ", name: " + lastName + " }";
    }

    //returns the hash code of the key of this object
    public int hashCode()
    {
        // temp holds the value of id, use it to call on hashCode()
        Long temp = id;
        return temp.hashCode();
    }

}

