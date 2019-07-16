import java.util.*;
import java.io.*;

public class HighTideLowTide
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int[] waves = new int[num];
      for (int i = 0; i < num; i++)
         waves[i] = Integer.parseInt(st.nextToken());
      Arrays.sort(waves);
      if (num%2 == 0)
      {
         int startingIndex = num/2 - 1;
         for (int i = 0; i < num/2; i++)
         {
            System.out.print(waves[startingIndex - i] + " ");
            System.out.print(waves[startingIndex + 1 + i] + " ");
         }
      }
      else
      {
         int startingIndex = num/2;   
         System.out.print(waves[startingIndex] + " ");
         for (int i = 0; i < num/2; i++)
         {
            System.out.print(waves[startingIndex + 1 + i] + " ");
            System.out.print(waves[startingIndex - 1 - i] + " ");
         }
      }
   }


}