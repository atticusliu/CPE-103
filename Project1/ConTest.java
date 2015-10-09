/*
 * @authors: Salonee Thanawala, Atticus Liu
 * @usernames: sthanawala@calpoly.edu, aliu44@calpoly.edu
 * CPE103-03
 * 8 October 2015
 * Project 1
 */

import java.util.*;

// class for ConTest
public class ConTest {

    // main function here for all user input/output
    public static void main(String[] args)
    {
        //declaring Scanner objet
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose one of the following operations:");
        System.out.println("-Infix to postfix conversion (enter the letter i)");
        System.out.println("-Postfix expression evaluation (enter the letter p)");
        System.out.println("-Arithmetic expression evaluation (enter the letter a)");
        System.out.println("-Quit the program (enter the letter q)");
        System.out.println();

        // cond is boolean value for while loop
        boolean cond = true;


        while(cond)
        {
            System.out.println("Enter menu choices");
            String in = sc.nextLine();

            if(in.length() == 1)
            {
                switch(in.charAt(0))
                {
                    case 'i':
                        System.out.println("Enter infix expression:");
                        if(sc.hasNext())
                        {
                            // input value
                            String input = sc.nextLine();
                            System.out.println("The postfix expression is: " + Converter.infixToPostfix(input));
                        }
                        break;
                    case 'p':
                        System.out.println("Enter postfix expression to be evaluated:");
                        if(sc.hasNext())
                        {
                            // input value
                            String input1 = sc.nextLine();
                            System.out.println("The postfix expression after postfix conversion is: " + Converter.postfixValue(input1));
                        }
                        break;
                    case 'a':
                        System.out.println("Enter the infix expression:");
                        if(sc.hasNext())
                        {

                            // input value
                            String input2 = sc.nextLine();

                            // postfix holds result of infixToPostFix
                            String postfix = Converter.infixToPostfix(input2);
                            System.out.println("The postfix expression after arithmetic evaluation is: " + Converter.postfixValue(input2));
                        }
                        break;
                    case 'q':
                        cond = false;
                        System.out.println("Farewell.");
                        break;
                    default:
                        System.out.println("Invalid menu choice");
                }
            }
        }



        /*
        String temp = "a + b * c + ( d * e + f ) * g";
        System.out.println("Input: " + temp);
        System.out.println("Answer: a b c * + d e * f + g * +");
        System.out.println("Result: " + Converter.infixToPostfix(temp));
        */


    }
}