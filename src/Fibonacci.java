import java.io.*;
import java.util.*;

public class Fibonacci
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);

		System.out.print("Enter an integer greater than 1: ");
			int amount = kb.nextInt();
			int[] fibArr = new int[amount];

		fibArr[0] = 0;
		fibArr[1] = 1;

		for(int i = 2; i < fibArr.length; i++)
			fibArr[i] = 0;


		for(int i = 2; i < fibArr.length; i++)
		{
			fibArr[i] = fibArr[i-2] + fibArr[i-1];
		}

		for(int num : fibArr)
			System.out.print(num + ", ");
	}
}