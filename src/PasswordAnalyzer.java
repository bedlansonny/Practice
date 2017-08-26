//from csp.reedyhighschool.com, took 11 min

import java.io.*;
import java.util.*;
public class PasswordAnalyzer
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNext())
		{
			String password = kb.nextLine().trim();
			int points = 0;
			String rating = "";
			
			if(password.contains(" ") || password.length() > 30)
			{
				rating = "INVALID";
			}
			else
			{
				boolean hasLetter = false;
				boolean hasNonLetter = false;
				
				for(char c : password.toCharArray())
				{
					if(Character.isLetter(c))
					{
						hasLetter = true;
					}
					
					if(!Character.isLetter(c))
					{
						hasNonLetter = true;
					}
				}
				
				if(password.length()>=8)
					points++;
				if(hasLetter && !password.equals(password.toLowerCase()) && !password.equals(password.toUpperCase()))
					points++;
				if(hasLetter && hasNonLetter)
					points++;
				
				switch(points)
				{
					case 0:
						rating = "WEAK";
						break;
					case 1:
						rating = "ACCEPTABLE";
						break;
					case 2:
						rating = "GOOD";
						break;
					case 3:
						rating = "STRONG";
						break;
				}
			}
			
			System.out.printf("This password is %s%n", rating);
			
		}
	}
}
