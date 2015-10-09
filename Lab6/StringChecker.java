import java.util.*;
import java.util.NoSuchElementException;

public class StringChecker
{
    public static boolean isBalanced(String s)
    {
        AStack<Character> stringStack = new AStack<Character>(15);
        int i = 0;
        while (i < s.length())
        {
            //if (s.charAt(i) == ' ')
            //    i++;
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
            {
                stringStack.push(s.charAt(i));
                //System.out.println(stringStack.peek());
                //i++;
            }
            else if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')')
            {
                if (stringStack.isEmpty())
                    return false;
                else
                {
                    if (s.charAt(i) == '}' && stringStack.pop() != '{')
                        return false;
                    else if (s.charAt(i) == ']' && stringStack.pop() != '[')
                        return false;
                    else if (s.charAt(i) == ')' && stringStack.pop() != '(')
                        return false;
                }
            }
            i++;
        }
        if (stringStack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        boolean cond = true;


        while(cond) {


            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a string");
            String input = "";
            try {
                input = sc.nextLine();
            }
            catch (NoSuchElementException e)
            {
                System.out.println("End program");
                break;
            }
            if (isBalanced(input)) {
                System.out.println("Input is balanced.");
            } else {
                System.out.println("Input is not balanced.");
            }
        }
    }
}