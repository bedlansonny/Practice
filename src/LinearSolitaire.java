import java.util.*;
public class LinearSolitaire
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int caseNum = 0;
        
        while(in.hasNext())
        {
            caseNum++;
            char[] board = in.nextLine().toCharArray();
            
            System.out.printf("Case %d: ", caseNum);
            if(works(board))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
    
    public static boolean works(char[] board)
    {
        int oneCount = 0;
        for(int i = 0; i < board.length; i++)
            if(board[i] == '1')
                oneCount++;
        
        while(true)
        {
            //testing output
            /*
            for(int i = 0; i < board.length; i++)
            {
                System.out.print(board[i]);
            }
            System.out.println();
            */
            
            if(oneCount == 1)
                return true;
            
            //check each for a 'good' move
            boolean moved = false;
            boolean isGood = false;
            for(int i = 0; i < board.length; i++)
            {
                if(i>=2 && board[i]=='1' && board[i-1]=='1' && board[i-2]=='0')
                {
                    isGood = false;
                    for(int j = i-2; j >= 0; j--)
                    {
                        if(board[j]=='1')
                        {
                            isGood = true;
                            break;
                        }
                    }
                    if(isGood)
                    {
                        board[i] = '0';
                        board[i-1] = '0';
                        board[i-2] = '1';
                        oneCount--;
                        moved = true;
                        break;
                    }
                }
                
                if(i<board.length-2 && board[i]=='1' && board[i+1]=='1' && board[i+2]=='0')
                {
                    isGood = false;
                    for(int j = i+2; j < board.length; j++)
                    {
                        if(board[j]=='1')
                        {
                            isGood = true;
                            break;
                        }
                    }
                    if(isGood)
                    {
                        board[i] = '0';
                        board[i+1] = '0';
                        board[i+2] = '1';
                        oneCount--;
                        moved = true;
                        break;
                    }
                }
            }
            //if made, continue
            if(moved)
                continue;
            
            //if not, check each for a 'bad' move
            for(int i = 0; i < board.length; i++)
            {
                if(i>=2 && board[i]=='1' && board[i-1]=='1' && board[i-2]=='0')
                {
                    board[i] = '0';
                    board[i-1] = '0';
                    board[i-2] = '1';
                    oneCount--;
                    moved = true;
                    break;
                }
                
                if(i<board.length-2 && board[i]=='1' && board[i+1]=='1' && board[i+2]=='0')
                {
                    board[i] = '0';
                    board[i+1] = '0';
                    board[i+2] = '1';
                    oneCount--;
                    moved = true;
                    break;
                }
            }
            //if not made, return false
            if(!moved)
                return false;
            
            //definitions:
            //good means there is a 1 after i+-2
            //bad means there is not a 1 after i+-2 
        }
    }
    
}

/*
Instructions:

Given a peg board made up of a long sequence of equally spaced holes and some pegs initially placed in holes, can you reduce the board to a single peg by repeatedly applying the following move:

A peg at position i with a neighboring peg at position i + 1 and a gap at position i + 2 can be reduced to a single peg at position i + 2 by making the peg at position i jump over and take its immediate neighbor. The rule can equally be applied by making a peg jump over and take its immediate neighbor to the left if that neighbor has a gap to its left. These two situations are illustrated in the diagram below.
https://babelia.libraryofbabel.info/imagebookmark2.cgi?babelia_5209473...34309686

Input

There will be multiple board descriptions, each occupying a single line of text. A board description will be a binary sequence such as 0110100 where 0 means the absence of a peg and 1 means the presence of a peg. The board above would be described by the string 011100 and the two moves indicated would result in boards 100100 and 010010.

A board description will not be longer than 20 symbols.
Input is terminated by end of file.

1
0
1111
1110111
111110
0110
010111100
0110010110

Output

For each board description output the single line of text containing the case number, as shown below, ’yes’ if the board can be reduced to a single peg, and ’no’ if it cannot.

Case 1: yes
Case 2: no
Case 3: no
Case 4: no
Case 5: no
Case 6: yes
Case 7: yes
Case 8: yes
*/
