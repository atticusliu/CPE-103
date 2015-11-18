import java.util.*;

public class GCDCalculator {

    public static int gcd(int x, int y)
    {
        int divisor;
        if(x == y)
        {
            divisor = x;
        }
        else
        {
            if(x > y)
            {
                x = x - y;
                divisor = gcd(x, y);
            }
            else
            {
                y = y - x;
                divisor = gcd(x
                        , y);
            }

        }
        return divisor;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        do
        {
            System.out.println("Enter 2 integers: ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("The greatest common divisor of " + x + " and " + y + " is " + gcd(x, y));
            System.out.println("Continue? Press n to stop ");
        } while(sc.hasNext());

        //sc.nextLine();

    }
}