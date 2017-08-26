//started 10/29/16 11:24am
//finished 10/29/16 1:24 PM
//http://www.hpcodewars.org/past/cw14/problems/ProblemSet2011Final.pdf
//Where's my WYSIWYG?

import java.io.*;
import java.util.*;

public class prob11
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);

		//stores the original text in an arraylist (dynamic)
		ArrayList<String> text = new ArrayList<String>();
		int textLineCount = sc.nextInt();
			sc.nextLine();
		int n = 0;
		while(n < textLineCount)
		{
			text.add(sc.nextLine().trim());
			n++;
		}

		//stores the commands in an array (static)
		String[] commands = new String[sc.nextInt()];
			sc.nextLine();
		for(int i = 0; i < commands.length; i++)
			commands[i] = sc.nextLine();


		for(int i = 0; i < commands.length; i++)
		{
			sc = new Scanner(commands[i]);
			String ind1 = sc.next();

			if(ind1.equalsIgnoreCase("a"))
			{
				int lineNum = sc.nextInt();
				String message = sc.nextLine().trim();

				text.add(lineNum, message);
			}
			else if(ind1.equalsIgnoreCase("d"))
			{
				int lineNum;

				if(commands[i].trim().length() > 1)
				{
					lineNum = sc.nextInt();
				}
				else
				{
					lineNum = 1;
				}

				text.remove(lineNum-1);
			}
			else if(Character.isDigit(ind1.charAt(0)))
			{
				int lineNum = Integer.parseInt(ind1);
				String command = sc.nextLine().trim();
					command = command.substring(command.indexOf("/") + 1);
				String original = command.substring(0, command.indexOf("/"));
				String replacement = command.substring(original.length()+1, command.lastIndexOf("/"));

				text.set(lineNum - 1, text.get(lineNum - 1).replace(original, replacement));

			}
			else
			{
				String command = (ind1 + sc.nextLine()).trim();
					command = command.substring(command.indexOf("/") + 1);
				String original = command.substring(0, command.indexOf("/"));
				String replacement = command.substring(original.length()+1, command.lastIndexOf("/"));

				for(int x = 0; x < text.size(); x++)
				{
					text.set(x, text.get(x).replace(original, replacement));
				}

			}
		}

		for(String str : text)
			System.out.println(str);
	}
}