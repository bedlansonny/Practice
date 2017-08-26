//Codewars 2002 problem 4, took 8 min 15 sec
import java.io.*;
import java.util.*;
public class Hangman
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(new File("`input.txt"));
		
		System.out.print("Please enter solution: ");
			String solution = kb.nextLine().toLowerCase().trim();
		System.out.print("Please enter your guesses: ");
			String guesses = kb.nextLine().trim();
		
		int wrongCount = 0;
		
		String[] bodyParts = {" O\n", "/", "|", "\\\n", "/ ", "\\\n"};
		
		for(char c : guesses.toCharArray())
		{
			if(!solution.contains("" + c))
			{
				wrongCount++;
			}
		}
		
		if(wrongCount > 6)
			wrongCount = 6;
		
		if(wrongCount == 6)
			System.out.println("You Lost!");
		else
			System.out.println("You Won!");
		
		for(int i = 0; i < wrongCount; i++)
		{
			System.out.print(bodyParts[i]);
		}
		
		System.out.println();
	}
}
