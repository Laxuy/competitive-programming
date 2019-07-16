import java.io.*;
import java.util.*;

public class TandemBicycle
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int question = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int[] country1 = new int[num];
      int[] country2 = new int[num];
      for (int i = 0; i < num; i++)
      {
         country1[i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < num; i++)
      {
         country2[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(country1);
      Arrays.sort(country2);
      int sum = 0;
      if (question == 1)
      {
         for (int i = 0; i < num; i++)
         {
            if (country1[i] <= country2[i])
               sum += country2[i];
            else
               sum += country1[i];
         }
      }
      else if (question == 2)
      {
         int country1Index = num-1, country2Index = num-1;
         for (int i = 0; i < num; i++)
         {
            if (country1[country1Index] > country2[country2Index])
            {
               sum+= country1[country1Index];
               country1Index--;
            }
            else 
            {
               sum+= country2[country2Index];
               country2Index--;
            }
         }
      }
      System.out.println(sum);
      
   }


}