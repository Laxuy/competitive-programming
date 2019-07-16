import java.util.*;
import java.io.*;

public class Jerseys
{
   static class Pair implements Comparable<Pair>
   {
      int num;
      String size;
      public Pair(int num, String size) 
      {
         this.num = num;
         this.size = size;
      }
      
      public int compareTo(Pair o)
      {
         if (num == o.num)
         {
            if ((o.size.equals("L") && (size.equals("S") || size.equals("M"))) || (o.size.equals("M") && size.equals("S")))
               return 1;
            else if (o.size.equals(size))
               return 0;
            else 
               return -1;
         }
         return num - o.num;
      }
   
   }
      
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int numJerseys = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int numRequests = Integer.parseInt(st.nextToken());     
      String[] jerseys = new String[numJerseys];
      for (int i = 0; i < numJerseys; i++)
      {
         st = new StringTokenizer(br.readLine());
         jerseys[i] = st.nextToken();
      }
      Pair[] requests = new Pair[numRequests];
      int value;
      String size;
      for (int i = 0; i < numRequests; i++)
      {
         st = new StringTokenizer(br.readLine());
         size = st.nextToken();
         value = Integer.parseInt(st.nextToken());
         requests[i] = new Pair(value, size);
      }
      Arrays.sort(requests);
      int sum = 0;
      for (int i = 0; i < numRequests; i++)
      {
         if (requests[i].num <= numJerseys)
         {
            if (jerseys[requests[i].num-1].equals("L") || (jerseys[requests[i].num-1].equals("M") && (requests[i].size.equals("M")
               || requests[i].size.equals("S"))) || (jerseys[requests[i].num-1].equals("S") && requests[i].size.equals("S")))
            {
               sum++;
               jerseys[requests[i].num-1] = " ";
            }
         }
      }
      System.out.println(sum);
   
   }


}