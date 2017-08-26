//converts normal calendar date to mayan calendar date
//task description of prob12 in 2006 codewars is wrong - 13.0.0.0.0 is 21 Dec. 2012

//Plan: convert to Mayan calendar based on days away from Dec 21, 2012
		//then create a calendar system that will calculate how many days away it is

import java.util.*;
import java.io.*;

public class MayanConverter
{
	public static void main(String args[]) throws FileNotFoundException
	{	
		Scanner kb = new Scanner(new File("`input.txt"));
		
		while(kb.hasNext())
		{	
			//finds how many days away it is from Dec 21, 2012
			int daysAway = 0;
			
			String input = kb.nextLine();
			String[] splitInput = input.split("/");
			int monthNum = Integer.parseInt(splitInput[0]);
				String monthString = Date.numToMonth(monthNum);
			int day = Integer.parseInt(splitInput[1]);
			int year = Integer.parseInt(splitInput[2]);
			
			Date base = new Date("December", 21, 2012);
			Date targetDate = new Date(monthString, day, year);
			
			if(base.comesBefore(targetDate))
			{
				daysAway = Date.findDaysBetween(base, targetDate);
			}
			else if(targetDate.comesBefore(base))
			{
				daysAway = -1 * Date.findDaysBetween(targetDate, base);
			}	
			
			//converts days away from date to Mayan date
			MayanCalendar mc = new MayanCalendar();
			
			if(daysAway < 0)
			{
				for(int d = 0; d > daysAway; d--)
				{
					mc.depleteKin();
				}
				
				System.out.println(mc.output());
			}
			else if(daysAway > 0)
			{
				for(int d = 0; d < daysAway; d++)
				{
					mc.addKin();
				}
				
				System.out.println(mc.output());
			}
			else
			{
				System.out.println(mc.output());
			}
			
		}
	}
}

public class MayanCalendar
{	
	int baktun;
	int katun;
	int tun;
	int unial;
	int kin;
	
	public MayanCalendar()
	{
		baktun = 13;
		katun = 0;
		tun = 0;
		unial = 0;
		kin = 0;
	}
	
	public void depleteKin()
	{
		if(kin == 0)
		{
			depleteUnial();
			kin = 19;
		}
		else
		{
			kin--;
		}
	}
	
	public void depleteUnial()
	{
		if(unial == 0)
		{
			depleteTun();
			unial = 17;
		}
		else
		{
			unial--;
		}
	}
	
	public void depleteTun()
	{
		if(tun == 0)
		{
			depleteKatun();
			tun = 19;
		}
		else
		{
			tun--;
		}
	}
	
	public void depleteKatun()
	{
		if(katun == 0)
		{
			depleteBaktun();
			katun = 19;
		}
		else
		{
			katun--;
		}
	}
	
	public void depleteBaktun()
	{
		baktun--;
	}
	
	public void addKin()
	{
		if(kin == 19)
		{
			addUnial();
			kin = 0;
		}
		else
		{
			kin++;
		}
	}
	
	public void addUnial()
	{
		if(unial == 17)
		{
			addTun();
			unial = 0;
		}
		else
		{
			unial++;
		}
	}
	
	public void addTun()
	{
		if(tun == 19)
		{
			addKatun();
			tun = 0;
		}
		else
		{
			tun++;
		}
	}
	
	public void addKatun()
	{
		if(katun == 19)
		{
			addBaktun();
			katun = 0;
		}
		else
		{
			katun++;
		}
	}
	
	public void addBaktun()
	{
		baktun++;
	}
	
	public String output()
	{
		return baktun + "." + katun + "." + tun + "." + unial + "." + kin;
	}
	
}

public class Date
{
	String month;
	int day;
	int year;

	int maxDay;

    public Date(String month, int day, int year)
    {
    	this.month = month;
    	this.day = day;
    	this.year = year;

    	updateMaxDay();
    }
	
	public boolean comesBefore(Date otherDate)
	{
		if(this.year < otherDate.year)
			return true;
		else if(this.year > otherDate.year)
			return false;
		else
		{
			if(monthToNum(this.month) < monthToNum(otherDate.month))
				return true;
			else if(monthToNum(this.month) > monthToNum(otherDate.month))
				return false;
			else
			{
				if(this.day < otherDate.day)
					return true;
				else if(this.day > otherDate.day)
					return false;
				else
					return false;
			}
		}
	}
	
	public static int findDaysBetween(Date d1, Date d2)
	{
		int dayCount = 0;
		while(!d1.equals(d2))
		{
			d1.incDay();
			dayCount++;
		}
		
		return dayCount;
	}
	
	public static int monthToNum(String mth)
	{
		switch(mth)
		{
			case "January":
				return 1;
			case "February":
				return 2;
			case "March":
				return 3;
			case "April":
				return 4;
			case "May":
				return 5;
			case "June":
				return 6;
			case "July":
				return 7;
			case "August":
				return 8;
			case "September":
				return 9;
			case "October":
				return 10;
			case "Novermber":
				return 11;
			case "December":
				return 12;
			default:
				return 0;
		}
	}
	
	public static String numToMonth(int num)
	{
		switch(num)
		{
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4:
				return "April";
			case 5:
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8:
				return "August";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11:
				return "November";
			case 12:
				return "December";
			default:
				return "ERROR";
		}
	}

	public boolean equals(Date otherDate)
	{
		if(this.year != otherDate.year)
			return false;
		if(!this.month.equals(otherDate.month))
			return false;
		if(this.day != otherDate.day)
			return false;
		return true;
	}

    private void updateMaxDay()
    {
		switch(month)
    	{
    		case "February":
    			if(!(year%100==0 && year%400!=0) && year%4==0)
    				maxDay = 29;
    			else
    				maxDay = 28;
    			break;
    		case "April":
    		case "June":
    		case "September":
    		case "November":
    			maxDay = 30;
    			break;
    		case "January":
    		case "March":
    		case "May":
    		case "July":
    		case "August":
			case "October":
    		case "December":
    			maxDay = 31;
    	};
    }

    public void incDay()
    {
    	if(day < maxDay)
    	{
    		day++;
    	}
    	else
    	{
    		day = 1;
    		incMonth();
    	}
    }

    public void incMonth()
    {
    	if(month.equals("January"))
    		month = "February";
    	else if(month.equals("February"))
    		month = "March";
    	else if(month.equals("March"))
    		month = "April";
    	else if(month.equals("April"))
    		month = "May";
    	else if(month.equals("May"))
    		month = "June";
    	else if(month.equals("June"))
    		month = "July";
    	else if(month.equals("July"))
    		month = "August";
    	else if(month.equals("August"))
    		month = "September";
    	else if(month.equals("September"))
    		month = "October";
    	else if(month.equals("October"))
    		month = "November";
    	else if(month.equals("November"))
    		month = "December";
    	else if(month.equals("December"))
    	{
    		month = "January";
    		incYear();
    	}

    	updateMaxDay();
    }

    public void incYear()
    {
    	year++;
    }
}