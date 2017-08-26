//from CSP, took 5 min
import java.io.*;
import java.util.*;
public class Tribonacci
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNext())
		{
			int num = kb.nextInt();
			
			if(num == -1)
				break;
			
			System.out.println(f(num));
		}
	}
	
	public static int f(int index)
	{
		if(index == 0)
			return 0;
		else if(index == 1 || index == 2)
			return 1;
		else
			return f(index-3) + f(index-2) + f(index-1);
	}
}