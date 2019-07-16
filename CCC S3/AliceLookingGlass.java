import java.util.*;
import java.io.*;

public class AliceLookingGlass
{
   public static int blocksAbove(int mag, int x)
   {
      if (mag > 0)
      {
         int segment = (int)Math.pow(5, mag - 1);
         int place = x/segment;
         if (place == 0 || place == 4)
            return 0;
         else if (place == 1 || place == 3)
            return blocksAbove(mag - 1, x%segment) + 1 * segment;
         else if (place == 2)
            return blocksAbove(mag - 1, x%segment) + 2 * segment;
      }
      return 0;   
   }

   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      String[] answers = new String[num];
      
      for (int i = 0; i < num; i++)
      {
         String[] input = br.readLine().split(" ");
         int mag = Integer.parseInt(input[0]);
         int x = Integer.parseInt(input[1]);
         int y = Integer.parseInt(input[2]);
         if (blocksAbove(mag, x) > y)
            answers[i] = "crystal";
         else
            answers[i] = "empty";
      }
      
      for (int i = 0; i < num; i++)
      {
         System.out.println(answers[i]);
      }
   
   }


}