//from csp.reedyhighschool.com, took 7 min
import java.io.*;
import java.util.*;
public class Parenthesis
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(new File("`input.txt"));
		
		int lineCount = kb.nextInt();
		kb.nextLine();
		
		for(int i = 0; i < lineCount; i++)
		{
			String line = kb.nextLine();
			
			int openPcount = 0;
			int closedPcount = 0;
			int openBcount = 0;
			int closedBcount = 0;
			
			for(char c : line.toCharArray())
			{
				switch(c)
				{
					case '(':
						openPcount++;
						break;
					case ')':
						closedPcount++;
						break;
					case '[':
						openBcount++;
						break;
					case ']':
						closedBcount++;
						break;
				}
				
			}
			
			if(openPcount==closedPcount && openBcount==closedBcount)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
