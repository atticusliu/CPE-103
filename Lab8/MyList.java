import java.util.*;

public class MyList
{
    //instance variable head
    private Node head;
    //nested Node class
    private class Node
    {
        //holds list element
        public int elem;
        //Node link
        public Node next;

        public Node()
        {
            head = null;
        }
    }

    //method that adds to the front of the list
    public void add(int item)
    {
        Node temp = new Node();
        temp.elem = item;

        head.next = temp.next;
        head.next = temp;

    }
    //method that finds the element searching for
    public boolean find(int item)
    {
        return find(item, head);
    }
    //private method that finds the element searching for recursively
    private boolean find(int item, Node head)
    {
	//base case
        if (head.elem == item)
	    return true;
        if (head.next == null)
            return false;
    	return find(item, head.next);  
    }

    //method that prints out linked list
    public void print()
    {
        print(head);
    }

    //private method that prints out the linked list recursively
    private void print(Node head)
    {
        if (head.next == null)
            System.out.print(head.elem + " ");
        else
            print(head.next);
    }
   
    //method that adds up all the elements in the list
    public int sum()
    {
        return sum(head);
    }

    //private method that adds up all the elements in the list
    private int sum(Node head)
    {
        if (head.next == null)
            return head.elem;
        else
        {
            return (sum(head.next) + head.elem);
        }
    }

}
