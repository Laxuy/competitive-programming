import java.util.*;
import java.io.*;

public class EnglishFrench
{
   public static void main (String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine()), numS = 0, numT = 0;
      String str;
      
      for (int i = 0; i < num; i++)
      {
         char[] line = br.readLine().toCharArray();
         for (int j = 0; j < line.length; j++)
         {
            if (line[j] == 't' || line[j] == 'T')
               numT++;
            else if (line[j] == 's' || line[j] == 'S')
               numS++;
         }
      
      }
      if (numS >= numT)
         System.out.println("French");
      else
         System.out.println("English");
         
   }

}