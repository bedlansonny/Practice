import java.util.*;
import java.io.*;
public class EvenOdd
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter an integer: ");
			int num = kb.nextInt();
		String evenodd;
		if(num % 2 == 0)
			evenodd = "even";
		else
			evenodd = "odd";
		System.out.printf("The integer %d is %s.%n", num, evenodd);
	}
}