import java.util.*;

public class Converter
{

    private static boolean isOperator(String str)
    {
        return str == "*" || str == "/" || str == "+" || str == "-" ||
               str == "(" || str == ")";
    }

    private static boolean precedence(String oper1, String oper2)
    {
        switch (oper1)
        {
            case "*:
                return !(oper2 == '+' || oper2 == '-');
            case "/:
                return oper2 == '(';

            case "+":
                return !(oper2 == '+' || oper2 == '-');
            case "-":
                return !(oper2 == '+' || oper2 == '-');
            case '(':
                return true;
            default:
                return false;
        }
    }




    public static String infixToPostfix(String expression)
    {
        MyStack<String> s = new MyStack<String>();
        String output = "";

        String[] temp = new String[50];
        temp = expression.split("\\s+");

        int count = 0;
        while(count < temp.length)
        {
            // add to stack if operator
            if(isOperator(temp[count]))
            {
                output = output + temp[count] + " ";
            }
            else
            {

            }

















            /*
            if(!(temp[count].equals("*") || temp[count].equals("/") || temp[count].equals("+") ||
               temp[count].equals("-") || temp[count].equals("(") || temp[count].equals(")")))
            {
                output = output + temp[count] + " ";
            }
            if((temp[count].equals("*") || temp[count].equals("/") || temp[count].equals("+") ||
                    temp[count].equals("-") || temp[count].equals("(") || temp[count].equals(")")))
            {
                // if what's read has lower precedence, do nothing. Else, pop it
                if(s.isEmpty())
                {
                    s.push(temp[count]);
                }
                // parentheses--empty stack until end of parentheses
                if(temp[count].equals("("))
                {
                    while(!s.peek().equals(")"))
                    {
                        output = output + s.pop() + " ";
                    }
                }

                if(!s.isEmpty())
                {
                    if(precedence(temp[count]) < precedence(s.peek()))
                    {
                        s.push(temp[count]);
                    }
                    else
                    {
                        output = output + s.pop() + " ";
                    }
                }
            }
            // last iteration to clear stack
            if(count == temp.length-1)
            {
                while(!s.isEmpty())
                {
                    output = output + s.pop() + " ";
                }
            }
            else
            {
                output = output + temp[count] + " ";
            }
            count++;
            */
        }
        return output;
    }


    public static double postfixValue(String expression)
    {
        return 2.0;
    }

}