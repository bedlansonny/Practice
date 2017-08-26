//10 min 25 sec
import java.io.*;
import java.util.*;
public class PerfectPainting
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);
		
		while(kb.hasNext())
		{
			int l = kb.nextInt();
			int w = kb.nextInt();
			int h = kb.nextInt();
			
			if(l == 0 && w == 0 && h == 0)
				break;
			
			int notPainted = ((l-2)*(w-2)*(h-2));
			int painted = (l*w*h) - notPainted;
			
			String rating = "";
			
			if(painted > notPainted)
			{
				rating = "MORE than Perfect";
			}
			else if(painted == notPainted)
			{
				rating = "PERFECT";
			}
			else if(painted < notPainted)
			{
				rating = "LESS than Perfect";
			}
			
			System.out.printf("A %dx%dx%d block is %s.%n", l, w, h, rating);
		}
	}
}
