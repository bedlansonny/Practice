import java.io.*;
import java.util.*;


public class Checkerboard
{
    public static void main(String args[])
    {
        Scanner kb = new Scanner(System.in);

        int width = kb.nextInt();
        String symbol;

        while(width != 0)
        {
            for(int y = 0; y < 8; y++)
            {
            	for(int i1 = 0; i1 < width; i1++)
            	{
	                for(int x = 0; x < 8; x++)
	                {
	                    if((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1))
	                        symbol = "#";
	                    else
	                        symbol = ".";

	                    for(int i = 0; i < width; i++)
	                    {
	                        System.out.print(symbol);
	                    }

	                }
	                System.out.println();
            	}

            }

            width = kb.nextInt();
            System.out.println();
        }
    }
}
