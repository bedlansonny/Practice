import java.io.*;
import java.util.*;

public class Histogram2
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(new File("input.txt"));

		//collecting the data
		int[] counts = new int[26];
		String[] letters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

		String input = "";
		while(kb.hasNext())
			input += kb.next().replace(".", "");

		input = input.toUpperCase();

		for(int i = 0; i < input.length(); i++)
		{
			counts[Arrays.asList(letters).indexOf(input.substring(i,i+1))]++;
		}

		//printing the data
		int largest = 0;
		for(int n : counts)
			if(n > largest)
				largest = n;

		String output;

		for(int y = largest-1; y >= 0; y--)
		{
			output = "";

			for(int x = 0; x < 26; x++)
			{
				if(counts[x] >= y+1)
					output += "*";
				else
					output += " ";
			}
			System.out.println(output);
		}

		System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

	}
}