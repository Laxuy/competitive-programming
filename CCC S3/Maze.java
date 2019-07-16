import java.util.*;
import java.io.*;

public class Maze
{
   public static int bfs(ArrayList<Integer>[] a, int s)
   {
      boolean[] visited = new boolean[a.length];
      int[] distances = new int[a.length];
      
      Queue<Integer> q = new LinkedList<Integer>();
      visited[s] = true;
      q.add(s);
      
      while (q.size() != 0)
      {
         s = q.poll();
         for (int i = 0; i < a[s].size(); i++)
         {
            int n = a[s].get(i);
            if (!visited[n])
            {
               visited[n] = true;
               q.add(n);
               distances[n] = distances[s] + 1;
            }
         }
      
      }
      if (visited[a.length - 1])
         return distances[a.length - 1] + 1;
      else
         return -1;
      
   }

   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      int[] answers = new int[num];
      for (int i = 0; i < num; i++)
      {
         int r = Integer.parseInt(br.readLine());
         int c = Integer.parseInt(br.readLine());
         ArrayList<Integer>[] adj = new ArrayList[r*c];
         
         for (int j = 0; j < adj.length; j++)
         {
            adj[j] = new ArrayList<Integer>();   
         }
         String[] next = {""};
         for (int j = 0; j < r; j++)
         {
            next = br.readLine().split("");
            for (int k = 0; k < c; k++)
            {
               if (next[k].equals("+"))
               {
                  if (k != 0)
                     adj[j*c + k].add(j*c + k - 1);
                  if (k != c - 1)
                     adj[j*c + k].add(j*c + k + 1);
                  if (j != 0)
                     adj[j*c + k].add((j - 1)*c + k);
                  if (j != r - 1)
                     adj[j*c + k].add((j + 1)*c + k);
               }
               else if (next[k].equals("|"))
               {
                  if (j != 0)
                     adj[j*c + k].add((j - 1)*c + k);
                  if (j != r - 1)
                     adj[j*c + k].add((j + 1)*c + k);
               }
               else if (next[k].equals("-"))
               {
                  if (k != 0)
                     adj[j*c + k].add(j*c + k - 1);
                  if (k != c - 1)
                     adj[j*c + k].add(j*c + k + 1);
               }
            }
         }
         if (next[c-1].equals("*"))
            answers[i] = -1;
         else
            answers[i] = bfs(adj, 0);
         
         
      }  
      
      for (int i = 0; i < num; i++)
      {
         System.out.println(answers[i]);
      }
   
   }

}