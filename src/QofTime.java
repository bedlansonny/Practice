//Codewars 2013 prob7, took 13 min
import java.io.*;
import java.util.*;

public class QofTime
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(new File("input.txt"));

		int minAfter;
		int hour = 0;
		String min;

		while(kb.hasNext())
		{
			minAfter = kb.nextInt();
			if(minAfter == -1)
				break;

			if(minAfter == 0 || minAfter > 55)
				hour = 12;
			else if(minAfter > 0 && minAfter <= 5)
				hour = 11;
			else if(minAfter > 5 && minAfter <= 10)
				hour = 10;
			else if(minAfter > 10 && minAfter <= 15)
				hour = 9;
			else if(minAfter > 15 && minAfter <= 20)
				hour = 8;
			else if(minAfter > 20 && minAfter <= 25)
				hour = 7;
			else if(minAfter > 25 && minAfter <= 30)
				hour = 6;
			else if(minAfter > 30 && minAfter <= 35)
				hour = 5;
			else if(minAfter > 35 && minAfter <= 40)
				hour = 4;
			else if(minAfter > 40 && minAfter <= 45)
				hour = 3;
			else if(minAfter > 45 && minAfter <= 50)
				hour = 2;
			else if(minAfter > 50 && minAfter <= 55)
				hour = 1;

			if(minAfter < 10)
				min = "0" + Integer.toString(minAfter,10);
			else
				min = Integer.toString(minAfter,10);

			System.out.println(hour + ":" + min);

		}
	}
}