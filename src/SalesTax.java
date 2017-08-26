import java.io.*;
import java.util.*;

public class SalesTax
{
	public static void main(String args[])
	{
		Scanner kb = new Scanner(System.in);

		while(kb.hasNext())
		{
			double taxMult = kb.nextDouble()/100;
			double price = kb.nextDouble();
			double tax = taxMult * price;
			double total = price + tax;

			System.out.printf("Your sales tax is: $%.2f\n", tax);
			System.out.printf("The total cost of the item (including sales tax) is: $%.2f\n", total);
		}
	}
}