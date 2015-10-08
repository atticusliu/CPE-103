import java.util.*;

public class ConTest {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose one of the following operations:");
        System.out.println("-Infix to postfix conversion (enter the letter i)");
        System.out.println("-Postfix expression evaluation (enter the letter p");
        System.out.println("-Arithmetic expression evaluation (enter the letter a)");
        System.out.println("-Quit the program (enter the letter q");

        String temp = "a + b * c + (d * e + f) * g";
        System.out.println(Converter.infixToPostfix(temp));
    }
}