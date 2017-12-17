import java.util.*;
public class QueenAnn
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        
        int lineNum = kb.nextInt();
            kb.nextLine();
        
        for(int i = 0; i < lineNum; i++)
        {
            String word = kb.nextLine();
            char[] letters = word.toCharArray();
            String likes = "hates ";
            
            for(int x = 1; x < letters.length; x++)
            {
                if(letters[x] == letters[x-1])
                {
                    likes = "likes ";
                    break;
                }
            }
            
            System.out.println(likes + word);
        }
    }
}
    