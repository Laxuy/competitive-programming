import java.util.*;
import java.io.*;

public class FloorPlan
{
   static boolean[] visited;
   public static int bfs(ArrayList<Integer>[] a, int s)
   {
      Queue<Integer> q = new LinkedList<Integer>();
      int counter = 0;
      
      visited[s] = true;
      q.add(s);
      
      while(q.size() != 0)
      {
         s = q.poll();
         counter++;
         
         for (int i = 0; i < a[s].size(); i++)
         {
            int n = a[s].get(i);
            if (!visited[n]) 
            {
               visited[n] = true;
               q.add(n);
            }   
         
         }   
      }
      return counter;  
   }
   
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int flooring = Integer.parseInt(br.readLine());
      int rows = Integer.parseInt(br.readLine());
      int cols = Integer.parseInt(br.readLine());
      ArrayList<Integer>[] adj = new ArrayList[rows*cols];
      for (int i = 0; i < adj.length; i++)
         adj[i] = new ArrayList<Integer>();
      String[][] grid = new String[rows][cols];
      ArrayList<Integer> floors = new ArrayList<Integer>();
      visited = new boolean[rows*cols];
      
      for (int i = 0; i < rows; i++)
      {
         String[] input = br.readLine().split("");
         for (int j = 0; j < cols; j++)
         {
            grid[i][j] = input[j];        
         }   
      }
      
      
      for (int i = 0; i < rows; i++)
      {
         for (int j = 0; j < cols; j++)
         {
            if (grid[i][j].equals("."))
            {
               if (i != 0)
               {
                  if (grid[i-1][j].equals("."))
                     adj[i*cols + j].add((i-1)*cols + j);
               }
               if (i != rows - 1)
               {
                  if (grid[i+1][j].equals("."))
                     adj[i*cols + j].add((i+1)*cols + j);
               }
               if (j != 0)
               {
                  if (grid[i][j - 1].equals("."))
                     adj[i*cols + j].add(i*cols + j - 1);
               }
               if (j != cols - 1)
               {
                  if (grid[i][j + 1].equals("."))
                     adj[i*cols + j].add(i*cols + j + 1);
               }
            
            }          
         }   
      }
      boolean keep = true;
      int start = 0;
      while (keep)
      {         
         for (int i = 0; i < adj.length; i++)
         {
            if (!visited[i] && !grid[i / cols][i % cols].equals("I"))
            {
               start = i;
               keep = true;
               break;
            }
            keep = false;
         }         
         if (keep)
            floors.add(bfs(adj, start));
      }
      Collections.sort(floors);
      int rooms = 0;
      for (int i = floors.size() - 1; i > -1; i--)
      {
         if (flooring - floors.get(i) >= 0)
         {
            rooms++;
            flooring -= floors.get(i);
         }
         else
            break;
      }
      if (rooms == 1)
         System.out.println(rooms + " room, " + flooring + " square metre(s) left over");
      else
         System.out.println(rooms + " rooms, " + flooring + " square metre(s) left over");
      
      
   }

}