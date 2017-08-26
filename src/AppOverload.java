import java.io.*;
import java.util.*;
public class AppOverload
{
    public static void main(String args[]) throws FileNotFoundException
    {
        File file = new File(System.getProperty("user.dir")+"\\src\\input.txt");
        Scanner sc = new Scanner(file);

        //get computer info
        String compInfo = sc.nextLine();
        String[] elements = compInfo.split(",");
        double compCPU = Double.parseDouble(elements[1]);
        double compMemory = Double.parseDouble(elements[2]);

        //loop for n times
        int appCount = sc.nextInt();
            sc.nextLine();
        //total cpu and memory
        double appsCPU = 0;
        double appsMemory = 0;
        for(int i = 0; i < appCount; i++)
        {
            String appInfo = sc.nextLine();
            elements = appInfo.split(",");
            appsCPU += Integer.parseInt(elements[1]);
            appsMemory += Integer.parseInt(elements[2]);
        }

        //divide and print
        double cpuPercent = (appsCPU / compCPU) * 100;
        double memoryPercent = (appsMemory / compMemory) * 100;

        if(cpuPercent > 100 || memoryPercent > 100)
        {
            System.out.println("No");
        }
        else
        {
            System.out.println("Yes");
        }

        System.out.printf("%.2f%% CPU%n", cpuPercent);
        System.out.printf("%.2f%% memory%n", memoryPercent);
    }
}
