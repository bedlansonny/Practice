//Codewars 2013 prob11, took 9min
import java.io.*;
import java.util.*;

public class Argument
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);

		int amount = kb.nextInt();

		for(int i = 0; i <= amount; i++)
		{
			String str = kb.nextLine();
			String output = "";

			output = str.replaceAll(" is not","xxx");
				//System.out.println(output);
			output = output.replaceAll(" is"," is not");
				//System.out.println(output);
			output = output.replaceAll("xxx"," is");

			System.out.println(output);
		}
	}
}