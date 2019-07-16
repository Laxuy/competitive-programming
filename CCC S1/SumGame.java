import java.util.*;
import java.io.*;

public class SumGame
{
   public static void main (String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int num = Integer.parseInt(st.nextToken());
      int[] swifts = new int[num], semaphores = new int[num];
      int swiftSum = 0, semaphoreSum = 0, sameDay = 0;
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < num; i++)
      {
         swifts[i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < num; i++)
      {
         semaphores[i] = Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i < num; i++)
      {
         swiftSum += swifts[i];
         semaphoreSum += semaphores[i];
         if (swiftSum == semaphoreSum)
            sameDay = i+1;
      }
      System.out.println(sameDay);
   }

}