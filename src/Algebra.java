import java.io.*;
import java.util.*;

public class Algebra
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);

		ArrayList<Integer> numbers;
		char[] symbols;
		int solution;

		while(kb.hasNext())
		{
			//takes input
			int numAmt = kb.nextInt();
				if(numAmt == 0)
					break;
			numbers = new ArrayList<Integer>();
			symbols = new char[numAmt-1];
			for(int i = 0; i < numAmt; i++)
				numbers.add(kb.nextInt());
			solution = kb.nextInt();
			kb.nextLine();
			symbols = kb.nextLine().replaceAll("a","").replaceAll("b","").replaceAll("c","").replaceAll("d","").replaceAll("e","").trim().toCharArray();

			//find *
			int multIndex = -1;
			for(int i = 0; i < symbols.length; i++)
			{
				if(symbols[i] == '*')
				{
					multIndex = i;
					break;
				}
			}

			while(multIndex > -1)
			{
				int temp1 = numbers.get(multIndex);
				int temp2 = numbers.get(multIndex + 1);
				numbers.remove(multIndex+1);
				numbers.set(multIndex, temp1*temp2);

				symbols[multIndex] = 'f';


				//find *
				multIndex = -1;
				for(int i = 0; i < symbols.length; i++)
				{
					if(symbols[i] == '*')
					{
						multIndex = i;
						break;
					}
				}
			}

			int total = 0;;
			for(Integer num : numbers)
				total += num;

			if(total == solution)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}