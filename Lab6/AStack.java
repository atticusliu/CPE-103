import java.util.*;

public class AStack<T>
{

    private T[] arr;
    private int top;

    public static class MyException extends RuntimeException
    {
        public MyException()
        { super(); }

        public MyException(String message)
        { super(message); }
    }

    public AStack(int size)
    {
        arr = (T[]) new Object[size];
        top = -1;
    }

    public void push(T value)
    {
        int arrlength = arr.length;
        if(top < arrlength - 1)
        {
            top++;
            arr[top] = value;
        }
        else
        {
            // new array double the size of arr
            T[] arr1;
            arr1 = (T[]) new Object[arrlength*2];
            // mapping to arr1
            int c = 0;
            while( c < arrlength)
            {
                arr1[c] = arr[c];
                c++;
            }
            arr = arr1;

            // adding fresh values to new array
            top++;
            arr[top] = value;
        }
    }

    public T pop()
    {
        if(top > -1)
        {
            T temp = arr[top];
            top--;
            return temp;
        } else {
            throw new MyException();
        }
    }

    public T peek()
    {
        if(top > -1)
            return arr[top];
        else
            throw new MyException();
    }

    public boolean isEmpty()
    {
        return top == -1;
    }

}