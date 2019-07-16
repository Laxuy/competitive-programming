import java.util.*;
import java.io.*;

public class Gates
{
   public static int findAnswer(ArrayList<Integer> a, int key)
   {  
      int low = 0, high = a.size();
      while (low <= high)
      {
         int mid = (low + high)/2;
         if (a.get(mid) == key)
         {
            return mid;
         }
         else if (a.get(mid) < key)
         { 
            if (mid < a.size() - 1)
            {
               if (a.get(mid + 1) > key)
                  return mid;
               else
                  low = mid + 1;
            }
            else 
               return mid;
         }
         else if (a.get(mid) > key)
         {
            if (mid > 0)
            {
               if (a.get(mid - 1) < key)
                  return mid - 1;
               else
                  high = mid - 1;
            }
            else
               return -1;
         }             
      }
      return -1;
   
   }

   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int gates = Integer.parseInt(br.readLine());
      int numPlanes = Integer.parseInt(br.readLine());
      ArrayList<Integer> visited = new ArrayList<Integer>();
      int[] planes = new int[numPlanes];
      int counter = 0;
      
      for (int i = 0; i < numPlanes; i++)
      {
         planes[i] = Integer.parseInt(br.readLine());
      }
      for (int j = 1; j <= gates; j++)
      {
         visited.add(j);
      }
      
      boolean keep = true;
      for (int plane = 0; plane < numPlanes; plane++)
      {
         int indexToRemove = findAnswer(visited, planes[plane]);
         if (indexToRemove > -1)
         {  
            visited.remove(indexToRemove);
            counter++;
         }
         else
            break;    
      }
      
      System.out.println(counter);
   
   }

}