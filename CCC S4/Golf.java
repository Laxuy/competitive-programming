import java.util.*;
import java.io.*;

public class Golf
{
   static int[] minStrokes;
   static int[] clubs;
   static boolean[] ready;
   public static int solve(int distance)
   {
      int min = Integer.MAX_VALUE - 2;
      if (distance < 0)
         return Integer.MAX_VALUE - 1;
      if (distance == 0)
         return 0;
      if (ready[distance])
         return minStrokes[distance];
      for (int i = 0; i < clubs.length; i++)
      {
         min = Math.min(min, solve(distance - clubs[i]) + 1);      
      }
      ready[distance] = true;
      minStrokes[distance] = min;
      return min;
   
   }
   
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int dist = Integer.parseInt(br.readLine());
      int num = Integer.parseInt(br.readLine());
      clubs = new int[num];
      ready = new boolean[dist + 1];
      minStrokes = new int[dist + 1];
      for (int i = 0; i < num; i++)
      {
         clubs[i] = Integer.parseInt(br.readLine());
      }
      int solution = solve(dist);
      if (solution != Integer.MAX_VALUE - 2)   
         System.out.println("Roberta wins in " + solution + " strokes.");
      else
         System.out.println("Roberta acknowledges defeat.");
   
   }

}