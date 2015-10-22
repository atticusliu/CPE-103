/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 19 October 2015
 * Project 2
 */

import java.util.*;

public class Student implements Comparable<Student>
{
    private long id;
    private String lastName;

    public Student(long id, String lastName)
    {
        this.id = id;
        this.lastName = lastName;
    }

    public int compareTo(Student other)
    {
        // if "this" id is SMALLER than other's id
        int ret = 0;
        if(this.id < other.id)
            ret = -1;
        else if(this.id > other.id)
            ret = 1;
        else if(this.id == other.id)
            ret = 0;
        return ret;
    }

    public String toString()
    {
        return "{ id: " + this.id + ", name: " + this.lastName + " }";
    }
}