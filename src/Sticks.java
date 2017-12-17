import java.util.*;
public class Sticks
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int numsLength = sc.nextInt();
        
        while(numsLength != 0)
        {
            //get input
            ArrayList<Integer> nums = new ArrayList<>();
            for(int i = 0; i < numsLength; i++)
                nums.add(sc.nextInt());
            //sort input
            Collections.sort(nums);
            
            //get sum of array
            int sum = 0;
            for(int n : nums)
                sum += n;
            
            //come up with list of numbers n where n >= greatest num in array and sum % n == 0
            ArrayList<Integer> candidates = new ArrayList<>();
            for(int c = nums.get(nums.size()-1); c <= sum; c++)
            {
                if(sum % c == 0)
                    candidates.add(c);
            }

            //for each candidate, check possibility using isLength
            for(int c : candidates)
            {
                if(isLength(c, nums))
                {
                    System.out.println(c);
                    break;
                }
            }
            
            numsLength = sc.nextInt();
        }
        
    }
    
    public static boolean isLength(int candidate, ArrayList<Integer> nums2)
    {
        ArrayList<Integer> nums = (ArrayList<Integer>)nums2.clone(); //deep copy of array
        
        while(nums.size() > 0)
        {
            int temp = candidate;
            while(temp > 0)
            {
                boolean success = false;
                for(int i = nums.size()-1; i >= 0; i--)
                {
                    if(nums.get(i) <= temp)
                    {
                        temp -= nums.get(i);
                        nums.remove(i);
                        success = true;
                        break;
                    }
                }
                
                if(!success)
                    return false;
            }
        }
        return true;
        
    }
}
    