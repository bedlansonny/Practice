//Codewars 2014 prob5, 8min 25sec

import java.io.*;
import java.util.*;

public class Pangram
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(new File("input.txt"));

		String[] letters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		int[] occurances;
		String word;

		while(kb.hasNext())
		{
			word = kb.nextLine().trim();
			if(word.equals("."))
				break;

			occurances = new int[26];

			for(int i = 0; i < word.length(); i++)
			{
				if(Character.isLetter(word.substring(i,i+1).charAt(0)))
				{
					int index = Arrays.asList(letters).indexOf(word.substring(i,i+1));
					occurances[index]++;
				}

			}

			boolean isNeither = false;
			boolean isPerfect = true;

			for(int i = 0; i < occurances.length; i++)
			{
				if(occurances[i] == 0)
					isNeither = true;
				else if(occurances[i] > 1)
					isPerfect = false;
			}

			if(isNeither)
				System.out.println("NEITHER: " + word);
			else if(isPerfect)
				System.out.println("PERFECT: " + word);
			else
				System.out.println("PANGRAM: " + word);
		}

	}
}