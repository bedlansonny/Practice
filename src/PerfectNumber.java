import java.io.*;
import java.util.*;
public class PerfectNumber
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		int num;
		ArrayList<Integer> divisors;

			num = kb.nextInt();

		while(num != 0)
		{
			divisors = new ArrayList<Integer>();

			int temp = num-1;
			while(temp > 0)
			{
				if((double)num/temp == (int)num/temp)
					divisors.add(temp);
				temp--;
			}

			int total = 0;
			for(Integer i : divisors)
				total += i;

			if(num == total)
				System.out.println(num + " " + "IS perfect.");
			else
				System.out.println(num + " " + "IS NOT perfect.");

				num = kb.nextInt();
		}

	}
}