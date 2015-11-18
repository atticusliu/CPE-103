import java.util.*;

public class AVLTest {

    public static void main(String[] args) {

        BasicAVL tree = new BasicAVL();
        // new scanner object
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose one of the following operations by entering provided letter: ");
        System.out.println("     a - add ");
        System.out.println("     p - print");
        System.out.println("     q - quit ");

        // boolean value to run through while loop below
        boolean cond = true;

        while (cond) {
            System.out.print("Enter menu choice: ");
            String in = sc.nextLine();

            if (in.length() == 1) {
                switch (in.charAt(0)) {

                    // ADD AN ELEMENT
                    case 'a':
                        System.out.print("Value: ");
                        if (sc.hasNextInt()) {
                            // new integer temp to hold inputted value
                            int temp = sc.nextInt();
                            sc.nextLine();
                            tree.insert(temp);
                            System.out.println(temp + " added.");
                        } else {
                            System.out.println("Invalid value for command.");
                            sc.nextLine();
                        }
                        break;
                    case 'p':
                        tree.printTree();
                        break;
                    // QUIT THE PROGRAM
                    case 'q':
                        // set cond to false to break out of loop
                        cond = false;
                        System.out.println("Farewell.");
                        break;
                    default:
                        System.out.println("Invalid menu choice.");
                }
            } else {
                System.out.println("Invalid menu choice.");
            }
        }
    }
}