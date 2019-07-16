import java.util.*;
import java.io.*;

public class DegreesOfSeparation
{
   public static int findFriendsOfFriends(ArrayList<Integer>[] a, int s)
   {
      int counter = 0;
      int[] distances = bfs(a, s);
      for (int i = 0; i < a.length; i++)
      {
         if (distances[i] == 2)
            counter++;     
      }
      return counter;
   
   }
   
   public static int[] bfs(ArrayList<Integer>[] a, int s)
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
               q.add(n);
               visited[n] = true;
               distances[n] = distances[s] + 1;
            }
         }      
      
      }
      return distances;
   
   }

   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      ArrayList<String> answers = new ArrayList<String>();
      ArrayList<Integer>[] adj = new ArrayList[50];
      for (int i = 0; i < 50; i++)
         adj[i] = new ArrayList<Integer>();
      
      adj[1].add(6);
      adj[2].add(6);
      adj[3].add(4);
      adj[3].add(6);
      adj[3].add(15);
      adj[3].add(5);
      adj[4].add(3);
      adj[4].add(5);
      adj[4].add(6);
      adj[5].add(4);
      adj[5].add(6);
      adj[5].add(3);
      adj[6].add(1);
      adj[6].add(2);
      adj[6].add(3);
      adj[6].add(4);
      adj[6].add(5);
      adj[6].add(7);
      adj[7].add(6);
      adj[7].add(8);
      adj[8].add(7);
      adj[8].add(9);
      adj[9].add(10);
      adj[9].add(12);
      adj[9].add(8);
      adj[10].add(9);
      adj[10].add(11);
      adj[11].add(10);
      adj[11].add(12);
      adj[12].add(9);
      adj[12].add(11);
      adj[12].add(13);
      adj[13].add(12);
      adj[13].add(14);
      adj[13].add(15);
      adj[14].add(13);
      adj[15].add(3);
      adj[15].add(13);
      adj[16].add(17);
      adj[16].add(18);
      adj[17].add(16);
      adj[17].add(18);
      adj[18].add(16);
      adj[18].add(17);
      
      int x, y;
      String command = br.readLine();
      while (!command.equals("q"))
      {
         if (command.equals("i"))
         {
            x = Integer.parseInt(br.readLine());
            y = Integer.parseInt(br.readLine());
            if (!adj[x].contains(y))
            {
               adj[x].add(y);
               adj[y].add(x);
            }
         }
         else if (command.equals("d"))
         {
            x = Integer.parseInt(br.readLine());
            y = Integer.parseInt(br.readLine());
            adj[x].remove((Object)y);
            adj[y].remove((Object)x);
         }
         else if (command.equals("n"))
         {
            x = Integer.parseInt(br.readLine());
            answers.add(Integer.toString(adj[x].size()));        
         }
         else if (command.equals("f"))
         {
            x = Integer.parseInt(br.readLine());
            answers.add(Integer.toString(findFriendsOfFriends(adj, x)));
         }
         else if (command.equals("s"))
         {
            x = Integer.parseInt(br.readLine());
            y = Integer.parseInt(br.readLine());
            int distance = bfs(adj, x)[y];
            if (distance == 0)
               answers.add("Not connected");
            else
               answers.add(Integer.toString(distance));
         }
         
         command = br.readLine();
      }
      
      for (int i = 0; i < answers.size(); i++)
      {
         System.out.println(answers.get(i));
      }
   }



}