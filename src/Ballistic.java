//7 min
import java.io.*;
import java.util.*;
public class Ballistic
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);
		
		double v = kb.nextDouble();
		double deg = kb.nextDouble();
		double w = Math.PI * deg / 180;
		
		System.out.printf("%.2f%n", (Math.pow(v,2)*Math.sin(2*w)/9.80665));
	}
}
