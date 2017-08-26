//Codewars 2014 prob6, 22min 49sec I'm falling asleep....

import java.io.*;
import java.util.*;

public class Negatives
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(new File("input.txt"));

		String[] negatives =
		{
			"DON'T", "CAN'T", "ISN'T", "HAVEN'T", "CANNOT", "WOULDN'T", "COULDN'T",
			"WON'T", " NO ", " NOT ", "NEVER", "NOBODY", "NOWHERE", "NEITHER", "AIN'T"
		};

		while(kb.hasNext())
		{
			String input = kb.nextLine();
			if(input.equals("."))
				break;

			boolean done = false;
			String temp = input;
			int counter = 0;

			while(!done)
			{
				int counterTemp = counter;

				for(int i = 0; i < negatives.length; i++)
				{
					if(temp.contains(negatives[i]))
					{
						int index = temp.indexOf(negatives[i]);
						temp = temp.substring(0, index) + temp.substring(index + negatives[i].length());
						counter++;
						break;
					}
				}

				if(counterTemp == counter)
					done = true;
			}

			System.out.println(counter + ": " + input);
			System.out.println("\t" + temp);


		}
	}
}