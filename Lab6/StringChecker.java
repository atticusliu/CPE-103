import java.util.*;

public class StringChecker
{
    public static boolean isBalanced(String s)
    {
        AStack<Character> stringStack = new AStack<Character>(15);
        int i = 0;
        while (i < s.length())
        {
            if (s.charAt(i) == ' ')
                i++;
            else if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
            {
                stringStack.push(s.charAt(i));
                i++;
            }
            else if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')')
            {
                if (stringStack.isEmpty())
                    return false;
                else
                {
                    if (s.charAt(i) == '{' && stringStack.pop() == '}')
                        i++;
                    else if (s.charAt(i) == '[' && stringStack.pop() == ']')
                        i++;
                    else if (s.charAt(i) == '(' && stringStack.pop() == ')')
                        i++;
                    else
                        return false;
                }
            }
            else
                i++;
        }
        if (stringStack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        sc.nextLine();
    }
}