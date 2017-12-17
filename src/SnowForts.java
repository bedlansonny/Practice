import java.util.*;
import java.io.*;
public class SnowForts
{
    public static void main(String args[]) throws IOException
    {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Player> players;

        while(in.hasNext())
        {
            players = new PriorityQueue<>();

            //n = total inputs, k = total possible attacks
            int n = in.nextInt();
            int k = in.nextInt();

            for(int i = 0; i < n; i++)
            {
                Player player = new Player(in.next(), in.nextInt(), in.nextInt());
                players.offer(player);
            }

            for(int i = 0; i < k; i++)
            {
                System.out.println(players.poll().name);
            }
        }
    }

    public static class Player implements Comparable<Player>
    {
        String name;
        int distance;

        public Player(String name, int x, int y)
        {
            this.name = name;
            distance = (int)(Math.pow(x, 2) + Math.pow(y, 2));
        }

        public int compareTo(Player otherPlayer)
        {
            return (this.distance - otherPlayer.distance);
        }

        public String toString()
        {
            return name + ": " + distance;
        }
    }
}
