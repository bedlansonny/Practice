//13 min 47 sec
import java.io.*;
import java.util.*;
public class ParallelogramWords
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);
		
		int amount = kb.nextInt();
			kb.nextLine();
		
		for(int i = 0; i < amount; i++)
		{
			String word = kb.nextLine();
			char[] chars = word.toCharArray();
			
			for(int a = 1; a <= chars.length; a++)
			{	
				for(int spaceNum = chars.length - a; spaceNum > 0; spaceNum--)
					System.out.print(" ");
				for(int b = 0; b < a; b++)
					System.out.print(chars[b]);
				System.out.println();
			}
			
			for(int a = 1; a <= chars.length; a++)
			{
				for(int b = 0; b < chars.length - a; b++)
				{
					System.out.print(chars[b + a]);
				}
				System.out.println();
			}
			
		}
	}
}
