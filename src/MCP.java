//Codewars 2013 prob12, took 8min 45sec
import java.io.*;
import java.util.*;

public class MCP
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(new File("input.txt"));

		String[] letters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " "};

		String[] morse = new String[] {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ""};



		String input;
		String morseinput;
		boolean isMCP;

		while(kb.hasNext())
		{
			input = kb.nextLine().trim();
			if(input.equals("."))
				break;
			morseinput = "";
			isMCP = true;

			for(int i = 0; i < input.length(); i++)
			{
				morseinput += morse[Arrays.asList(letters).indexOf(input.substring(i,i+1))];
			}

			for(int i = 0; i < morseinput.length()/2; i++)
			{
				if(!morseinput.substring(i,i+1).equals(morseinput.substring(morseinput.length()-1-i,morseinput.length()-i)))
					isMCP = false;
			}

			if(isMCP)
				System.out.println(input + " is a MCP");
			else
				System.out.println(input + " is *not* a MCP");
		}
	}
}