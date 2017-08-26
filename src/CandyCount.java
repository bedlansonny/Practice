//10 min 30 sec
import java.io.*;
import java.util.*;
public class CandyCount
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);
		
		int candyCount = kb.nextInt();
		int guessCount = kb.nextInt();
		
		int[] guesses = new int[guessCount];
		String[] guessers = new String[guessCount];
		int[] distances = new int[guessCount];
		
		int closestDistance = 999999;
		
		for(int i = 0; i < guessCount; i++)
		{
			guesses[i] = kb.nextInt();
			guessers[i] = kb.nextLine().trim();
			distances[i] = Math.abs(candyCount - guesses[i]);
			if(distances[i] < closestDistance)
			{
				closestDistance = distances[i];
			}
			

		}
		
		for(int i = 0; i < guessCount; i++)
		{
			if(distances[i] == closestDistance)
			{
				System.out.print(guessers[i] + " ");
			}
		}
		
		
		
	}
}
