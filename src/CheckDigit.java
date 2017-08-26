//Codewars 2014 prob2, 8min40sec, I SUCK

import java.io.*;
import java.util.*;

public class CheckDigit
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);

		int amount = kb.nextInt();

		for(int i = 0; i < amount; i++)
		{
			int evens = 0, odds = 0;

			for(int x = 0; x < 11; x++)
			{
				int temp = kb.nextInt();
				System.out.print(temp + " ");

				if(x % 2 == 0)
					odds += temp;
				else
					evens += temp;
			}

			int result = (odds*3 + evens)%10;

			if(result != 0)
				result = 10 - result;

			System.out.println(result);
		}
	}
}