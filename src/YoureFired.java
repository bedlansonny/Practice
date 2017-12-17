//3:44 - 3:51
//prints first changed word between two sentences
import java.util.*;
public class YoureFired
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int problems = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < problems; i++)
        {
            System.out.print(sc.nextInt() + ": ");
            sc.nextLine();
            
            
            String[] line1 = sc.nextLine().split(" ");
            String[] line2 = sc.nextLine().split(" ");
            
            for(int w = 0; w < line1.length; w++)
            {
                if(!line1[w].equals(line2[w]))
                {
                    System.out.print(line1[w]);
                    break;
                }
            }
            
            System.out.println();
        }
    }
}
    