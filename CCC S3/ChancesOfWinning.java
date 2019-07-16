import java.util.*;
import java.io.*;

public class ChancesOfWinning
{
   int numberOfWins(int gamesLeft, int[] points, ArrayList<Integer> playAgainst)
   {
      int wins = 0;
      if (gamesLeft == 0)
         return 0;
      return numberOfWins(gamesLeft - 1, points) + wins;   
   
   }

   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      ArrayList<String> playAgainst = new ArrayList<String>();;
      for (int i = 0; i < 4; i++)
      {
         for (int j = i + 1; j < 4; j++)
         {
            playAgainst.add(Integer.toString(i) + " " + Integer.toString(j)); 
         }
      }
      int fave = Integer.parseInt(br.readLine());
      int games = Integer.parseInt(br.readLine());
      int[] points = new int[4];
      for (int i = 0; i < games; i++)
      {
         String[] input = br.readLine().split(" ");
         int team1 = Integer.parseInt(input[0]);
         int team2 = Integer.parseInt(input[1]);
         int score1 = Integer.parseInt(input[2]);
         int score2 = Integer.parseInt(input[3]);
         if (score1 == score2)
         {
            points[team1]++;
            points[team2]++;
         }
         else if (score1 > score2)
            points[team1]+=3;
         else
            points[team2]+=3;
         playAgainst.remove(Integer.toString(Math.min(team1, team2)) + " " + Integer.toString(Math.max(team1, team2)));      
      }
   
   }


}