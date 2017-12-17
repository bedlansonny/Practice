//finds how many trailing zeros there are in n! (n factorial)
import java.util.*;
import java.math.*;
public class TrailingZeros
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext())
        {
            int top = sc.nextInt();
            int zeroCount = 0;
            for(int i = 5; i <= top; i *= 5)
                zeroCount += top/i;
            System.out.println(zeroCount);
        }
    }
}