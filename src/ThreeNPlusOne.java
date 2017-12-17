import java.util.*;
import java.io.*;
public class ThreeNPlusOne
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext())
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int highest = 0;
            
            for(int start = Math.min(a,b); start <= Math.max(a,b); start++)
            {
                int n = start;
                int count = 1;
                
                while(n != 1)
                {
                    count++;
                    if(n % 2 == 1)
                        n = 3*n + 1;
                    else
                        n = n/2;
                }
                
                if(count > highest)
                    highest = count;
                
            }
            
            System.out.printf("%d %d %d%n", a, b, highest);
        }
    }

}