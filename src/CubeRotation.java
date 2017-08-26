//Codewars 2016 prob15, took an hour and 10 minutes
//still failed on the other datasets. Don't know how it failed, was too tired to check
import java.io.*;
import java.util.*;

public class CubeRotation
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(new File("input.txt"));

		char[][] front = new char[2][2];
		char[][] left = new char[2][2];
		char[][] right = new char[2][2];
		char[][] back = new char[2][2];
		char[][] up = new char[2][2];
		char[][] down = new char[2][2];

		for(int y = 0; y < 2; y++)
		{
			for(int x = 0; x < 2; x++)
			{
				front[y][x] = 'G';
				left[y][x] = 'O';
				right[y][x] = 'R';
				back[y][x] = 'B';
				up[y][x] = 'W';
				down[y][x] = 'Y';
			}
		}

		char temp1, temp2, temp3;

		//print
		System.out.println("Start");
		for(int y = 0; y < 2; y++)
		{
			for(int x = 0; x < 2; x++)
			{
				System.out.print(front[y][x] + " ");
			}
			System.out.println();
		}
		System.out.println();


		while(kb.hasNext())
		{
			char input = kb.next().charAt(0);
			if(input == '.')
				break;

			if(input == 'U')
			{
				temp1 = front[0][0];
				temp2 = front[0][1];
				front[0][0] = right[0][0];
				front[0][1] = right[0][1];
				right[0][0] = back[0][0];
				right[0][1] = back[0][1];
				back[0][0] = left[0][0];
				back[0][1] = left[0][1];
				left[0][0] = temp1;
				left[0][1] = temp2;

				temp3 = up[0][0];
				up[0][0] = up[1][0];
				up[1][0] = up[1][1];
				up[1][1] = up[0][1];
				up[0][1] = temp3;
			}
			else if(input == 'R')
			{
				temp1 = front[0][1];
				temp2 = front[1][1];

				front[0][1] = down[0][1];
				front[1][1] = down[1][1];
				down[0][1] = back[1][0];
				down[1][1] = back[0][0];
				back[1][0] = up[0][1];
				back[0][0] = up[1][1];
				up[0][1] = temp1;
				up[1][1] = temp2;

				temp3 = right[0][0];
				right[0][0] = right[1][0];
				right[1][0] = right[1][1];
				right[1][1] = right[0][1];
				right[0][1] = temp3;
			}
			else if(input == 'L')
			{
				temp1 = front[0][0];
				temp2 = front[1][0];

				front[0][0] = up[0][0];
				front[1][0] = up[1][0];
				up[0][0] = back[1][1];
				up[1][0] = back[0][1];
				back[1][1] = down[0][0];
				back[0][1] = down[1][0];
				down[0][0] = temp1;
				down[1][0] = temp2;

				temp3 = left[0][0];
				left[0][0] = left[1][0];
				left[1][0] = left[1][1];
				left[1][1] = left[0][1];
				left[0][1] = temp3;
			}
			else if(input == 'D')
			{
				temp1 = front[1][0];
				temp2 = front[1][1];

				front[1][0] = left[1][0];
				front[1][1] = left[1][1];
				left[1][0] = back[1][0];
				left[1][1] = back[1][1];
				back[1][0] = right[1][0];
				back[1][1] = right[1][1];
				right[1][0] = temp1;
				right[1][1] = temp2;

				temp3 = down[0][0];
				down[0][0] = down[1][0];
				down[1][0] = down[1][1];
				down[1][1] = down[0][1];
				down[0][1] = temp3;
			}
			else if(input == 'B')
			{
				temp1 = up[0][0];
				temp2 = up[0][1];

				up[0][0] = right[0][1];
				up[0][1] = right[1][1];
				right[0][1] = down[0][0];
				right[1][1] = down[0][1];
				down[0][0] = left[1][0];
				down[0][1] = left[0][0];
				left[1][0] = temp1;
				left[0][0] = temp2;

				temp3 = up[0][0];
				back[0][0] = back[1][0];
				back[1][0] = back[1][1];
				back[1][1] = back[0][1];
				back[0][1] = temp3;
			}
			else if(input == 'F')
			{
				temp1 = up[1][0];
				temp2 = up[1][1];

				up[1][0] = left[1][1];
				up[1][1] = left[0][1];
				left[1][1] = down[1][0];
				left[0][1] = down[1][1];
				down[1][0] = right[0][0];
				down[1][1] = right[1][0];
				right[0][0] = temp1;
				right[1][0] = temp2;

				temp3 = front[0][0];
				front[0][0] = front[1][0];
				front[1][0] = front[1][1];
				front[1][1] = front[0][1];
				front[0][1] = temp3;
			}

			System.out.println(input);
			for(int y = 0; y < 2; y++)
			{
				for(int x = 0; x < 2; x++)
				{
					System.out.print(front[y][x] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}