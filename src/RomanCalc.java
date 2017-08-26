import java.util.*;
public class RomanCalc
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input Operand 1: ");
        int num1 = romToDec(sc.nextLine());

        System.out.print("Input Operator: ");
        char operator = sc.nextLine().charAt(0);

        System.out.print("Input Operand 2: ");
        int num2 = romToDec(sc.nextLine());

        //convert operator
        int result = 0;
        switch(operator)
        {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
        }

        System.out.printf("%nThe result is: %s", decToRom(result));

    }

    static String decToRom(int dec)
    {
        String rom = "";
        int temp = dec;

        int mCount = temp / 1000;
        for(int i = 0; i < mCount; i++)
        {
            rom += "M";
        }
        temp = dec % 1000;

        int cCount = temp / 100;
        if (cCount == 9)
        {
            rom += "CM";
        }
        else if (cCount == 4)
        {
            rom += "CD";
        }
        else
        {
            if (cCount >= 5)
            {
                rom += "D";
                cCount -= 5;
            }
            for(int i = 0; i < cCount; i++)
            {
                rom += "C";
            }
        }
        temp = dec % 100;

        int xCount = temp / 10;
        if(xCount == 9)
        {
            rom += "XC";
        }
        else if(xCount == 4)
        {
            rom += "XL";
        }
        else
        {
            if(xCount >= 5)
            {
                rom += "L";
                xCount -= 5;
            }
            for(int i = 0; i < xCount; i++)
            {
                rom += "X";
            }
        }
        temp = dec % 10;

        int iCount = temp;
        if(iCount == 9)
        {
            rom += "IX";
        }
        else if(iCount == 4)
        {
            rom += "IV";
        }
        else
        {
            if(iCount >= 5)
            {
                rom += "V";
                iCount -= 5;
            }
            for(int i = 0; i < iCount; i++)
            {
                rom += "I";
            }
        }

        return rom;
    }

    static int romToDec(String rom)
    {
        char[] romArr = rom.toCharArray();
        int dec = 0;
        for(int i = 0; i < romArr.length; i++)
        {
            if(romArr[i] == 'I')
            {
                if(i < romArr.length - 1 && romArr[i+1] == 'V')
                {
                    dec += 4;
                    i++;
                }
                else if(i < romArr.length - 1 && romArr[i+1] == 'X')
                {
                    dec += 9;
                    i++;
                }
                else
                {
                    dec += 1;
                }
            }
            else if(romArr[i] =='V')
            {
                dec += 5;
            }
            else if(romArr[i] == 'X')
            {
                if(i < romArr.length - 1 && romArr[i+1] == 'L')
                {
                    dec += 40;
                    i++;
                }
                else if(i < romArr.length - 1 && romArr[i+1] == 'C')
                {
                    dec += 90;
                    i++;
                }
                else
                {
                    dec += 10;
                }
            }
            else if(romArr[i] == 'L')
            {
                dec += 50;
            }
            else if(romArr[i] == 'C')
            {
                if(i < romArr.length - 1 && romArr[i+1] == 'D')
                {
                    dec += 400;
                    i++;
                }
                else if(i < romArr.length - 1 && romArr[i+1] == 'M')
                {
                    dec += 900;
                    i++;
                }
                else
                {
                    dec += 100;
                }
            }
            else if(romArr[i] == 'D')
            {
                dec += 500;
            }
            else if(romArr[i] == 'M')
            {
                dec += 1000;
            }
        }

        return dec;

    }
}
