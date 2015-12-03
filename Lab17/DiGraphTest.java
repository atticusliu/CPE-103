import java.lang.RuntimeException;
import java.util.*;

public class DiGraphTest
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of vertices: ");
        int verticesNum = sc.nextInt();
        sc.nextLine();
        DiGraphAM table = new DiGraphAM(verticesNum);

        System.out.println("Choose one of the following operations by entering provided letter: ");
        System.out.println("     a - add edge ");
        System.out.println("     d - delete edge");
        System.out.println("     e - edge count");
        System.out.println("     v - vertex count");
        System.out.println("     p - print");
        System.out.println("     t - topological sort");
        System.out.println("     q - quit ");

        boolean cond = true;
        while(cond)
        {
            System.out.print("Enter menu choice: ");
            String in = sc.nextLine();
            if(in.length() == 1)
            {
                switch(in.charAt(0))
                {
                    case 'a':
                        System.out.print("Vertex numbers: ");
                        int v1 = sc.nextInt();
                        int v2 = sc.nextInt();
                        sc.nextLine();
                        table.addEdge(v1, v2);
                        break;
                    case 'd':
                        System.out.print("Vertex numbers: ");
                        int v3 = sc.nextInt();
                        int v4 = sc.nextInt();
                        sc.nextLine();
                        table.deleteEdge(v3, v4);
                        break;
                    case 'e':
                        System.out.println("Number of edges is: " + table.edgeCount());
                        break;
                    case 'v':
                        System.out.println("Number of vertices is: " + table.vertexCount());
                        break;
                    case 'p':
                        table.print();
                        break;
                    case 't':
                        try
                        {
                            int[] result = table.topSort();
                            for(int i = 0; i < result.length; i++)
                            {
                                System.out.print(result[i] + " ");
                            }
                            System.out.println();
                        } catch (RuntimeException ex){
                            System.out.println("Can't do topological sort - graph is cyclic");
                        }
                        break;
                    case 'q':
                        cond = false;
                        System.out.println("Bye");
                        break;
                    default:
                        System.out.println("Invalid menu choice.");
                }
            } else {
            System.out.println("Invalid menu value");
        }
        }
    }
}