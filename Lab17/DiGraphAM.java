import java.lang.RuntimeException;

public class DiGraphAM
{
    private int[][] adjTable;

    public DiGraphAM(int N)
    {
        adjTable = new int[N][N];
    }

    public void addEdge(int from, int to)
    {
        adjTable[from][to] = 1;
    }

    public void deleteEdge(int from, int to)
    {
        adjTable[from][to] = 0;
    }

    public int edgeCount()
    {
        int count = 0;
        for(int i = 0; i < adjTable.length; i++)
        {
            for(int j = 0; j < adjTable.length; j++)
            {
                if(adjTable[i][j] == 1)
                {
                    count++;
                }
            }
        }
        return count;
    }

    public int vertexCount()
    {
        return adjTable.length;
    }

    public void print()
    {
        for(int i = 0; i < adjTable.length; i++)
        {
            System.out.print(i + " is connected to: ");
            for(int j = 0; j < adjTable.length; j++)
            {
                if(adjTable[i][j] == 1)
                {
                    System.out.print(j + ", ");
                }
            }
            System.out.println();
        }
    }

    private int[] indegrees()
    {
        int[] answer = new int[adjTable.length];
        for(int v = 0; v < adjTable.length; v++)
        {
            for(int j = 0; j < adjTable.length; j++)
            {
                if(adjTable[v][j] == 1)
                    answer[j]++;
            }
        }
        return answer;
    }

    public int[] topSort()
    {
        int[] temp = indegrees();
        int[] answer = new int[vertexCount()];
        LQueue<Integer> que = new LQueue<Integer>();
        int counter = 0;

        for(int v = 0; v < adjTable.length; v++)
        {
            if(temp[v] == 0)
            {
                que.enqueue(v);
            }
        }

        while(!que.isEmpty())
        {
            int v = que.dequeue();
            answer[counter] = v;
            counter++;
            for(int x = 0; x < adjTable.length; x++)
            {
                if(adjTable[v][x] == 1)
                {
                    temp[x]--;
                    if(temp[x] == 0)
                    {
                        que.enqueue(x);
                    }
                }
            }
        }
        if(counter != adjTable.length)
        {
            throw new LQueue.MyException();
        }
        return answer;
    }
}