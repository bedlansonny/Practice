//Codewars 2015 prob18, took way too long but was fun
import java.io.*;
import java.util.*;

public class DownhillMaze2
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);

		Tile[][] tiles = new Tile[kb.nextInt()][kb.nextInt()];

		Tile startTile = new Tile();
		Tile endTile = new Tile();
		
		String output = "";

		for(int y = 0; y < tiles.length; y++)
		{
			for(int x = 0; x < tiles[0].length; x++)
			{
				String temp = kb.next();

				tiles[y][x] = new Tile();
				tiles[y][x].setCoordinates(x,y);

				if(temp.equals("S"))
				{
					startTile = tiles[y][x];
					tiles[y][x].setHeight(9);
				}
				else if(temp.equals("X"))
				{
					endTile = tiles[y][x];
					tiles[y][x].setHeight(0);
				}
				else
				{
					tiles[y][x].setHeight(Integer.parseInt(temp));
				}
			}
		}

		ArrayList<Tile> path = new ArrayList<Tile>();
		boolean success = false;

		while(!success)
		{
			path = new ArrayList<Tile>();
				path.add(startTile);

			Tile currentTile = new Tile();

			while(!success && currentTile.isGood)
			{
				currentTile = path.get(path.size()-1);

				if (currentTile.x > 0 &&
					tiles[currentTile.y][currentTile.x - 1].height <= currentTile.height &&
					tiles[currentTile.y][currentTile.x - 1].isGood &&
					!path.contains(tiles[currentTile.y][currentTile.x - 1]))
				{
					if(endTile == tiles[currentTile.y][currentTile.x - 1])
						success = true;
					path.add(tiles[currentTile.y][currentTile.x - 1]);
				}
				else if(currentTile.y > 0 &&
						tiles[currentTile.y - 1][currentTile.x].height <= currentTile.height &&
						tiles[currentTile.y - 1][currentTile.x].isGood &&
						!path.contains(tiles[currentTile.y - 1][currentTile.x]))
				{
					if(endTile == tiles[currentTile.y - 1][currentTile.x])
						success = true;
					path.add(tiles[currentTile.y - 1][currentTile.x]);
				}
				else if(currentTile.x < tiles[0].length-1 &&
						tiles[currentTile.y][currentTile.x + 1].height <= currentTile.height &&
						tiles[currentTile.y][currentTile.x + 1].isGood &&
						!path.contains(tiles[currentTile.y][currentTile.x + 1]))
				{
					if(endTile == tiles[currentTile.y][currentTile.x + 1])
						success = true;
					path.add(tiles[currentTile.y][currentTile.x + 1]);
				}
				else if(currentTile.y < tiles.length-1 &&
						tiles[currentTile.y + 1][currentTile.x].height <= currentTile.height &&
						tiles[currentTile.y + 1][currentTile.x].isGood &&
						!path.contains(tiles[currentTile.y + 1][currentTile.x]))
				{
					if(endTile == tiles[currentTile.y + 1][currentTile.x])
						success = true;
					path.add(tiles[currentTile.y + 1][currentTile.x]);
				}
				else
				{
					currentTile.isBad();
				}
			}
		}

		for(int y = 0; y < tiles.length; y++)
		{
			for(int x = 0; x < tiles[0].length; x++)
			{
				if(tiles[y][x] == startTile)
					output += "S ";
				else if(tiles[y][x] == endTile)
					output += "X ";
				else if(path.contains(tiles[y][x]))
					output += ". ";
				else
					output += "# ";

			}
			output += "\n";
		}
		
		System.out.println(output);

	}
}

class Tile
{
	public boolean isGood;
	public int height;
	public int x, y;

	public Tile()
	{
		isGood = true;
		height = 666;
		x = 666;
		y = 666;
	}

	public void setHeight(int num)
	{
		height = num;
	}

	public void setCoordinates(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void isBad()
	{
		isGood = false;
	}

}