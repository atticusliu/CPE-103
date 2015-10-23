import java.util.*;

public class SeparateAndMerge
{
    //helper method
    public static boolean isFloat(String s)
    {
        try
        {
            //Integer.parseInt(s);
            Float.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isInt(String s)
    {
        try
        {
            //Integer.parseInt(s);
            Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }


    public static void main(String[] args)
    {
        LList<Integer> listInt = new LList<Integer>();
        LList<Float> listFloat = new LList<Float>();

        Iterator<Integer> intItr = listInt.iterator();
        Iterator<Float> floatItr = listFloat.iterator();

        Scanner sc = new Scanner(System.in);
        System.out.println("What numbers would you like to input?: ");
        String [] input = new String[50];


        int count = 0;
        while(sc.hasNext())
        {
            input[count] = sc.next();
            count++;
        }

        int count2 = 0;
        while (count2 < input.length)
        {
            if (isFloat(input[count2]))
            {
                listFloat.add(Float.parseFloat(input[count2]));
            }
            else if (isInt(input[count2]))
            {
                listInt.add(Integer.parseInt(input[count2]));
            }
            count2++;
        }

        System.out.println("intIter: " + intItr.next());
        System.out.println("Inputted values: ");

        while (intItr.hasNext() || floatItr.hasNext())
        {
            if (intItr.hasNext())
                System.out.println(intItr.next());
            if (floatItr.hasNext())
                System.out.println(floatItr.next());
        }


    }
}
