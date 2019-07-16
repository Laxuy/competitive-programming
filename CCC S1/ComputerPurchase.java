import java.util.*;
import java.io.*;

public class ComputerPurchase
{
   static class Pair implements Comparable<Pair> 
   {
      int value, shorterNum;
      String name, shorterString;
      
      public Pair(String name, int value)
      {
         this.name = name;
         this.value = value;
      }
      
      public int compareTo(Pair o)
      {
         if (o.value == value)
         {
            return name.compareTo(o.name);
         }
         else
            return o.value - value;
      }
   
   }
   
   public static void main (String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int a, b, c, value, num = Integer.parseInt(st.nextToken());
      if (num == 1) { 
          System.out.println(br.readLine().split(" ")[0]);
          System.exit(0);
      }
      if (num > 0)
      {
         Pair[] computers = new Pair[num];
         String name;
         for (int i = 0; i < num; i++)
         {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            value = 2*a + 3*b + c;
            computers[i] = new Pair(name, value);
            
         }
         Arrays.sort(computers);
         System.out.println(computers[0].name);
         System.out.println(computers[1].name);
      }
      System.out.println();
   }


}