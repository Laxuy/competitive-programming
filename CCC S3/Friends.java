import java.util.*;
import java.io.*;

public class Friends
{
   public static int goThroughFriends(ArrayList<Integer>[] adj, int start, int goal)
   {
      boolean[] visited = new boolean[adj.length];
      int current = start;
      int counter = 0;
      while (!visited[current])
      {
         visited[current] = true;
         current = adj[current].get(0);        
         if (goal == current)
         {
            return counter;
         }   
         counter++;     
      }
      return -1;
   }
   
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      String[] assignment;
      ArrayList<Integer>[] adj = new ArrayList[10000];
      for(int i = 0; i < 10000; i++)
      {
          adj[i] = new ArrayList<Integer>();
      }
      for (int i = 0; i < num; i++)
      {
         assignment = br.readLine().split(" ");
         adj[Integer.parseInt(assignment[0])].add(Integer.parseInt(assignment[1]));
      
      }
      boolean keep = true;
      int result;
      ArrayList<String> answers = new ArrayList<String>();
      while (keep)
      {
         assignment = br.readLine().split(" ");
         if (assignment[0].equals("0") && assignment[1].equals("0"))
         {
            keep = false;
         }
         else
         {
            result = goThroughFriends(adj, Integer.parseInt(assignment[0]), Integer.parseInt(assignment[1]));
            if (result == -1)
               answers.add("No");
            else
               answers.add("Yes " + result);
         }
      }
      for (int i = 0; i < answers.size(); i++)
      {
         System.out.println(answers.get(i));
      }  
      
   }


}