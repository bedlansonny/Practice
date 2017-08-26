import java.io.*;
import java.util.*;

public class TextMe
{
    public static void main(String args[])
    {
    	Scanner kb = new Scanner(System.in);

    	char[] arr1 = {'@', '.', '?', '1'};
    	char[] arr2 = {'A', 'B', 'C', '2'};
    	char[] arr3 = {'D', 'E', 'F', '3'};
    	char[] arr4 = {'G', 'H', 'I', '4'};
    	char[] arr5 = {'J', 'K', 'L', '5'};
    	char[] arr6 = {'M', 'N', 'O', '6'};
    	char[] arr7 = {'P', 'Q', 'R', 'S', '7'};
    	char[] arr8 = {'T', 'U', 'V', '8'};
    	char[] arr9 = {'W', 'X', 'Y', 'Z', '9'};

    	String input = kb.nextLine();

    	int index = 0;
    	int counter = 0;
    	String temp;
    	String output = "";

    	while(index < input.length())
    	{
    		temp = input.substring(index, index+1);

    		if(Character.isDigit(temp.charAt(0)) && !temp.equals("0"))
    		{
    			while(input.substring(index, index+1).equals(temp))
	    		{
	    			if (temp.equals("7") || temp.equals("9"))
	    			{
						if(counter==5)
	    					counter = 1;
	    				else
	    					counter++;
	    			}
	    			else
	    			{
	    				if(counter == 4)
	    					counter = 1;
	    				else
	    					counter++;
	    			}

	    			index++;
	    		}

	    		switch(temp)
	    		{
	    			case "1":
	    				output += arr1[counter-1];
	    				break;
	    			case "2":
	    				output += arr2[counter-1];
	    				break;
	    			case "3":
	    				output += arr3[counter-1];
	    				break;
	    			case "4":
	    				output += arr4[counter-1];
	    				break;
	    			case "5":
	    				output += arr5[counter-1];
	    				break;
	    			case "6":
	    				output += arr6[counter-1];
	    				break;
	    			case "7":
	    				output += arr7[counter-1];
	    				break;
	    			case "8":
	    				output += arr8[counter-1];
	    				break;
	    			case "9":
	    				output += arr9[counter-1];
	    				break;
	    		}

	    		counter = 0;
    		}
    		else if(temp.equals("0"))
    		{
    			output += "0";
    			index++;
    		}
    		else if(temp.equals("#"))
    		{
    			output += " ";
    			index++;
    		}
    		else if(temp.equals("*"))
    		{
    			output += "\n";
    			index++;
    		}
    		else if(temp.equals(" "))
    		{
    			index++;
    		}

    	}

    	System.out.println(output);
    }
}