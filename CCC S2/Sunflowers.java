import java.util.*;
import java.io.*;

public class Sunflowers
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int num = Integer.parseInt(st.nextToken());
      int[][] flowers = new int[num][num];
      
      for (int i = 0; i < num; i++)
      {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < num; j++)
         {
            flowers[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      
      int startingPoint = 0;
      
      if (flowers[0][0] < flowers[1][0] && flowers[0][0] < flowers[0][1])
         startingPoint = 1;
      else if (flowers[0][num-1] < flowers[1][num-1] && flowers[0][num-1] < flowers[0][num-2])
         startingPoint = 2;
      else if (flowers[num-1][0] < flowers[num-2][0] && flowers[num-1][0] < flowers[num-1][1])
         startingPoint = 3;
      else if (flowers[num-1][num-1] < flowers[num-2][num-1] && flowers[num-1][num-1] < flowers[num-1][num-2])
         startingPoint = 4;
         
      if (startingPoint == 1)
      {
         for (int i = 0; i < num; i++)
         {
            for (int j = 0; j < num; j++)
            {
               System.out.print(flowers[i][j] + " ");
            }
            System.out.println();
         }
      }
      else if (startingPoint == 2)
      {
         for (int i = num - 1; i >= 0; i--)
         {
            for (int j = 0; j < num; j++)
            {
               System.out.print(flowers[j][i] + " ");
            }
            System.out.println();
         }
      
      }
      else if (startingPoint == 3)
      {
         for (int i = 0; i < num; i++)
         {
            for (int j = num-1; j >= 0; j--)
            {
               System.out.print(flowers[j][i] + " ");
            }
            System.out.println();
         }
      
      }
      else if (startingPoint == 4)
      {
         for (int i = num-1; i >= 0; i--)
         {
            for (int j = num-1; j >= 0; j--)
            {
               System.out.print(flowers[i][j] + " ");
            }
            System.out.println();
         }
      
      }
   }

}