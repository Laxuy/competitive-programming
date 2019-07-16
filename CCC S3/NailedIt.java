import java.io.*;
import java.util.*;

public class NailedIt
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int num = Integer.parseInt(st.nextToken());
      int[] boards = new int[2001];
      int[] lengths = new int[4001];
      
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < num; i++)
      {
         boards[Integer.parseInt(st.nextToken())]++;
      }
      
      for (int j = 0; j < 2001; j++)
      {
         if (boards[j] > 0)
         {
            for (int k = j; k < 2001; k++)
            {
               if (j == k)
               {
                  lengths[j + k] += boards[j]/2;
               
               }
               else if (boards[k] > 0)
               {
                  lengths[j + k] += Math.min(boards[j], boards[k]); 
               }
            
            }
         
        
         }
      }
      Arrays.sort(lengths);
      int highestFreq = lengths[4000];
      int numberOfHighestFreq = 0;
      for (int i = 4000; i >= 0; i--)
      {
         if (lengths[i] == highestFreq)
            numberOfHighestFreq++;
         else
            break;
      
      }
      System.out.println(highestFreq + " " + numberOfHighestFreq);
      
   
   }


}