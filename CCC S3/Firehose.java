import java.util.*;
import java.io.*;

public class Firehose
{
   public static int hydrantsNeeded(int length, int[] houses)
   {
      int min = houses.length;
      length = 2 * length;
      int counter = 0;
      for (int i = 0; i < houses.length; i++)
      {
         if (houses[0] + length < houses[i])
         {
            break;
         }
         counter = 1;
         int start = houses[i];
         for (int j = i + 1; j < houses.length; j++)
         {
            if ((houses[j] + length)%1000000 < houses[i])
               break;
            if (houses[j] > start)
            {
               counter++;
               start = houses[j] + length;
            }
         
         
         }
         min = Math.min(min, counter);
      }
      return min;
   }

   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      int[] houses = new int[num];
      int answer;
      for (int i = 0; i < num; i++)
      {
         houses[i] = Integer.parseInt(br.readLine());
      }
      Arrays.sort(houses);
      int hydrants = Integer.parseInt(br.readLine());
      int low = 0, high = 1000000, mid = 0;
      while (low <= high)
      {
         mid = (low + high)/2;
         int needed = hydrantsNeeded(mid, houses);
         if (needed <= hydrants)
         {
            high = mid - 1;
         }
         else if (needed > hydrants)
         {
            low = mid + 1;
         }
      
      }
      System.out.println(mid);
      
      
   }

}