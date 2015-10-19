import java.util.*;

public class MySortedList
{
    private Node head;

    private class Node
    {
        public int ele;
        public Node next;
    }

    public MySortedList()
    {
        head = null;
    }

    // METHODS BELOW

    public void add(int item)
    {
        boolean done;
        Node temp;
        temp.ele = item;
        // list is empty
        if(head == null)
        {
            head = temp;
        }
        // when item is smaller than head.ele
        else if(item <= head.ele)
        {
            // do what's in spec
        }
        // general case
        else
        {
            // is there a next, first?
            Node curr = head;
            if(curr.next != null)
            {
                // do actual comparison
            }
        }
    }

    public void delete(int item)
    {

    }

    public int max()
    {

    }

    public int min()
    {

    }

    public void print()
    {

    }

    public boolean isEmpty()
    {

    }






}