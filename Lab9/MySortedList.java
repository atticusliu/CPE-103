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
        Node temp = new Node();
        temp.ele = item;
        Node curr;

        // if list is empty
        if(head == null)
        {
            head = temp;
        }

        // if item should belong at front of list
        else if(item <= head.ele)
        {
            temp.next = head;
            head = temp;
        }

        // general case
        else
        {
            curr = head;
            while(curr.next != null)
            {
                if (curr.next.ele < item)
                    curr = curr.next;
                else
                    break;
            }

            if (curr.next == null)
            {
                curr.next = temp;
            }
            else
            {
                temp.next = curr.next;
                curr.next = temp;

                //temp = curr.next;
                //temp.next = curr.next.next;
            }
        }
    }

    public void delete(int item)
    {
        Node curr; //node pointer

        if (head!=null)
        {
            if (head.ele == item)
            {
                head = head.next;

            }
            else
            {
                curr = head;
                while (curr.next != null && curr.next.ele < item) {
                       curr = curr.next;
                   }
                if (curr.next!= null && curr.next.ele == item) {
                    curr.next = curr.next.next;
                }

            }


        }
    }

    public int max()
    {
        Node curr;
        curr = head;
        while (curr.next != null)
        {
            curr = curr.next;
        }
        return curr.ele;

    }

    public int min()
    {
        return head.ele;
    }

    public void print()
    {
        Node curr;
        curr = head;
        while (curr.next != null)
        {
            System.out.print(curr.ele + " ");
            curr = curr.next;
        }
        System.out.print(curr.ele);
        System.out.println();
    }

    public boolean isEmpty()
    {
        return (head == null);

    }
}
