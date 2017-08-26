import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        
        while(kb.hasNext())
        {
            int n1 = kb.nextInt();
            int n2 = kb.nextInt();
            
            System.out.println(n1 == 6 || n2 == 6 || Math.abs(n1-n2) == 6 || n1+n2 == 6);
        }
    }
}
    