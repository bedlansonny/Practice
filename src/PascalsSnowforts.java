import java.util.*;
import java.io.*;
public class PascalsSnowforts
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int testCaseCount = in.nextInt();

        for(int i = 0; i < testCaseCount; i++)
        {
            int n = in.nextInt() + 1; //idk why i have to add 1 but i do
            long[][] tri = new long[n][n];
            tri[0][0] = 1;

            //storing vals in tri
            for(int y = 1; y < n; y++)
            {
                for(int x = 0; x < y; x++)
                {
                    if(x==0 || x == y-1)
                        tri[y][x] = 1;
                    else
                    {
                        tri[y][x] = tri[y-1][x-1] + tri[y-1][x];
                    }
                }
            }

            //printing vals
            for(int y = 1; y < n; y++)  //have to start y at 1, idk why
            {
                for(int s = 0; s < n-y-1; s++)
                    System.out.print(" ");
                for(int x = 0; x < y; x++)
                {
                    System.out.print(tri[y][x] + " ");
                }
                System.out.println();
            }
        }
    }
}
