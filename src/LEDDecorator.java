//From CSP
//took about 2 hours

import java.io.*;
import java.util.*;
public class LEDDecorator
{
	static Integer[][] alphaList = 
	{
		{1, 2, 3, 4, 5, 7},
		{1, 2, 3, 4, 5, 6, 7},
		{4, 5, 6},
		{1, 5, 8, 0},
		{1, 2, 4, 5, 6},
		{1, 2, 4, 9},
		{1, 2, 5, 6, 9},
		{1, 3, 4, 5, 7},
		{3, 7},
		{3, 5, 6, 7},
		{1, 3, 4, 5, 9},
		{1, 5, 6},
		{1, 2, 3, 5, 7},
		{3, 5, 7, 9},
		{1, 2, 3, 5, 6, 7},
		{1, 4, 5, 8},
		{1, 2, 3, 4, 7},
		{1, 2, 3, 4, 5, 9},
		{1, 2, 4, 6, 7},
		{2, 7, 8},
		{1, 3, 5, 6, 7},
		{1, 3, 7, 9},
		{1, 3, 5, 7, 9, 0},
		{9, 0},
		{1, 3, 4, 7},
		{2, 3, 4, 5, 6}
	};
	
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNext())
		{
			String input = kb.nextLine();
			char[] chars = input.toCharArray();
			String output = "";
			ArrayList<Integer> nums = new ArrayList<Integer>();
			
			for(int i = 0; i < chars.length; i++)
			{
				if(Character.isLetter(chars[i]) || Character.isWhitespace(chars[i]))
				{
					if(nums.size() > 0)
					{
						output += getLetter(nums);
						nums = new ArrayList<Integer>();	
					}
					
					output += chars[i];
				}
				else
				{
					int num = Character.getNumericValue(chars[i]);
					
					if(nums.size() == 0)
					{
						if(num == 0)
						{
							output += " ";
						}
						else
						{
							nums.add(num);
						}
					}
					else
					{
						if(num < nums.get(nums.size()-1) && num > 0)
						{
							output += getLetter(nums);
							nums = new ArrayList<Integer>();
							nums.add(num);
						}
						else if(num == 0 && !works(nums, num))
						{
							output += getLetter(nums);
							nums = new ArrayList<Integer>();
							output += " ";
						}
						else
						{
							nums.add(num);
						}
					}
				}
				if(i == chars.length-1)
				{
					output += getLetter(nums);
				}

			}
			
			System.out.println(output);
		}

	}
	
	static boolean works(ArrayList<Integer> numArrayList, int num)
	{
		numArrayList.add(num);
		boolean output = Character.isLetter(getLetter(numArrayList));
		numArrayList.remove(numArrayList.size()-1);
		return output;
	}
	
	static char getLetter(ArrayList<Integer> numArrayList)
	{
		Integer[] numArray = numArrayList.toArray(new Integer[numArrayList.size()]);
		
		int alphaNum = -1;
		
		for(int y = 0; y < 26; y++)
		{
			if(Arrays.equals(alphaList[y], numArray))
			{
				alphaNum = y;
				break;
			}
		}
		
		if(alphaNum > -1)
		{
			alphaNum += 65;
			return (char)alphaNum;
		}
		else
		{
			return (char)37;
		}
		
	}
}
