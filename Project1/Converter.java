/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 8 October 2015
 * Project 1
 */

import java.util.*;

// Converter class
public class Converter
{
    // determine if a given character (read as a string) is an operator)
    private static boolean isOperator(String str)
    {
        return str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-") ||
               str.equals("(") || str.equals(")");
    }


    // get precedence of a given operator
    private static int getPrecedence(String op)
    {
        // ret is 0 to signify the default value
        // ret is also value of "+" and "-"
        int ret = 0;

        // "/" and "*" get next precedence
        if(op.equals("/") || op.equals("*"))
        {
            ret = 1;
        }

        // parentheses are exceptions to precedence rules, assigned -1
        if(op.equals("(") || op.equals(")"))
        {
            ret = -1;
        }
        return ret;
    }


    // evaluating to postfix expression given an infix expression
    public static String infixToPostfix(String expression)
    {
        // opStack is MyStack object created
        MyStack<String> opStack = new MyStack<String>();
        // "output" is empty string for concatenation
        // "output" is what will be returned at end
        String output = "";

        // "temp" is a new array to hold "expression" without whitespaces
        // allows for easy access to each value formerly in expression
        // 50 is an arbitrary number
        String[] temp = new String[50];

        // splitting by whitespaces, storing in temp
        temp = expression.split("\\s+");

        // counter for while loop on the next line
        int count = 0;

        while(count < temp.length)
        {
            // add to output if it isn't an operator
            if(!isOperator(temp[count]))
            {
                output = output + temp[count] + " ";
            }
            else
            {
                if(temp[count].equals("("))
                {
                    opStack.push(temp[count]);
                }

                // if stack is empty, push
                else if(!opStack.isEmpty() && temp[count].equals(")"))
                {
                    //opStack.push(temp[count]);
                    while (!opStack.isEmpty() && !opStack.peek().equals("(")) {
                            output = output + opStack.pop() + " ";
                    }

                    // to pop "("
                    if(!opStack.isEmpty())
                    {
                        System.out.println(opStack.pop());
                    }

                }


                // pop "("

                if(!opStack.isEmpty() && opStack.peek().equals("("))
                {
                    opStack.pop();
                }


                // curPrec is precedence value of the current value
                int curPrec = getPrecedence(temp[count]);

                //System.out.println(temp[count]);
                int peekPrec;
                // peekPrec is precedence value of value at top of stack (peek())

                if(!opStack.isEmpty())
                {
                    peekPrec = getPrecedence(opStack.peek());
                }
                else
                {
                    peekPrec = -10;
                }

                while(!opStack.isEmpty() && peekPrec >= curPrec)
                {
                    output = output + opStack.pop() + " ";
                    //opStack.pop();
                }

                // push whatever operator
                if(!temp[count].equals(")"))
                {
                    opStack.push(temp[count]);
                }

            }
            // increment count
            count++;
        }
        // empty rest of opStack
        while(!opStack.isEmpty()) {
            output = output + opStack.pop() + " ";
        }
        return output;
    }



    //returning a double given a postfix
    public static double postfixValue(String expression)
    {
        // numStack is MyStack object for this method
        MyStack<Double> numStack = new MyStack<Double>();

        // turn expression into doubles and strings

        // doublesOperations is new array created to hold expression without whitespaces
        // allows for easy access in while loop
        String[] doublesOperations = new String[50];

        // stores values into doublesOperations
        doublesOperations = expression.split("\\s+");

        // c1 is counter for while loop below
        int c1 = 0;

        while(c1 < doublesOperations.length)
        {
            if(!isOperator(doublesOperations[c1]))
            {
                numStack.push(Double.parseDouble(doublesOperations[c1]));
            }
            else
            {
                if(doublesOperations[c1].equals("+"))
                {
                    // sum is the sum of the two pops
                    double sum = numStack.pop() + numStack.pop();
                    numStack.push(sum);
                }
                if(doublesOperations[c1].equals("-"))
                {
                    // ORDER MATTERS
                    // temp1Sub is first number
                    // temp2Sub is what we're subtracting first number from
                    double temp1Sub = numStack.pop();
                    double temp2Sub = numStack.pop();
                    numStack.push(temp2Sub - temp1Sub);
                }
                if(doublesOperations[c1].equals("*"))
                {
                    //double product = numStack.pop() * numStack.pop();
                    numStack.push(numStack.pop() * numStack.pop());
                }
                if(doublesOperations[c1].equals("/"))
                {
                    // ORDER MATTERS
                    // temp1Div is dividend
                    // temp2Div is divisor
                    double temp1Div = numStack.pop();
                    double temp2Div = numStack.pop();
                    //double quotient = temp2Div / temp1Div;
                    numStack.push(temp2Div / temp1Div);
                }
            }
            //System.out.println(numStack.peek());
            // increment counter
            c1++;
        }
        return numStack.peek();
    }
}