import java.io.*;
import java.util.*;

public class AbsolutelyAcidic
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      int[] readings = new int[1001];
      int highestFreq = 0, secondHighestFreq = 0;
      int difference;
      ArrayList<Integer> highestIndexes = new ArrayList<Integer>();
      ArrayList<Integer> secondHighestIndexes = new ArrayList<Integer>();
      for (int i = 0; i < num; i++)
      {
         int reading = Integer.parseInt(br.readLine());
         readings[reading]++;
      }
      for (int reading = 0; reading < 1001; reading++)
      {
         if (readings[reading] > highestFreq)
         {
            secondHighestFreq = highestFreq;
            secondHighestIndexes.clear();
            for (int j = 0; j < highestIndexes.size(); j++)
            {
               secondHighestIndexes.add(highestIndexes.get(j));
            }
            highestFreq = readings[reading];
            highestIndexes.clear();
            highestIndexes.add(reading);
         }
         else if (readings[reading] == highestFreq)
         {
            highestIndexes.add(reading);
         }
         else if (readings[reading] > secondHighestFreq)
         {
            secondHighestFreq = readings[reading];
            secondHighestIndexes.clear();
            secondHighestIndexes.add(reading);
         }
         else if (readings[reading] == secondHighestFreq)
         {
            secondHighestIndexes.add(reading);
         }
      }
      Collections.sort(highestIndexes);
      Collections.sort(secondHighestIndexes);
      if (highestIndexes.size() > 1)
      {
         difference = highestIndexes.get(highestIndexes.size() -1) - highestIndexes.get(0);
      }
      else if (secondHighestIndexes.size() > 1)
      {
         difference = Math.max(secondHighestIndexes.get(secondHighestIndexes.size() -1) - highestIndexes.get(0), 
               highestIndexes.get(0) - secondHighestIndexes.get(0)); 
      }        
      else
         difference = Math.abs(highestIndexes.get(0) - secondHighestIndexes.get(0));
        
      System.out.println(difference);
      
      
      
   
   
   }


}