import java.math.BigInteger;
import java.util.*;
public class Snowflakes
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        HashSet<BigInteger> nums = new HashSet<>();

        while(in.hasNext())
        {
            BigInteger num = new BigInteger(in.nextLine());
            if(nums.contains(num))
                System.out.println(num);
            else
                nums.add(num);
        }
    }
}
