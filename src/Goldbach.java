//Finds the two closest prime numbers that add up to any number above 2
//took 11 minutes

import java.io.*;
import java.util.*;
public class Goldbach
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNext())
		{
			int sum = kb.nextInt();
			if(sum == 0)
				break;
			
			for(int h = sum/2; h < sum; h++)
			{
				if(isPrime(h) && isPrime(sum-h))
				{
					System.out.printf("%d + %d = %d%n", sum-h, h, sum);
					break;
				}
			}
		}
	}
	
	public static boolean isPrime(int num)
	{
		boolean prime = true;
		for(int t = 2; t < num; t++)
		{
			if(num%t==0)
			{
				prime = false;
				break;
			}
		}
		
		return prime;
	}
}