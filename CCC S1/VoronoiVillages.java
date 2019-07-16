import java.io.*;
import java.util.*;

class VoronoiVillages
{
   public static void main (String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int num = Integer.parseInt(st.nextToken());   
      int[] locations = new int[num];
      
      for (int i = 0; i < num; i++)
      {
         st = new StringTokenizer(br.readLine());
         locations[i] = Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(locations);
      double min = locations[1] - (locations[0] + locations[1])/2.0 + (locations[1] + locations[2])/2.0 - locations[1];
      
      for (int i = 1; i < num - 1; i++)
      {
         double distance = locations[i] - (locations[i-1] + locations[i])/2.0 + (locations[i] + locations[i+1])/2.0 - locations[i];
         if (distance < min)
            min = distance;
      }
      System.out.printf("%.1f", min);
   
   }

}