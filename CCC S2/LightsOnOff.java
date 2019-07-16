import java.util.*;
import java.io.*;

public class LightsOnOff
{
   public static void switchLights(int[][] lights, int rows, int columns, int switchedRow)
   {
      for (int i = 0; i < columns; i++)
      {
         if (lights[switchedRow][i] == lights[switchedRow - 1][i])
            lights[switchedRow][i] = 0;
         else
            lights[switchedRow][i] = 1;
      }
   }
   
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int rows = Integer.parseInt(br.readLine());
      int columns = Integer.parseInt(br.readLine());
      int switchedRow;
      String currentCombo = "";
      ArrayList<String> combos = new ArrayList<String>();
      int[][] lights = new int[rows][columns];
      int[][] newLights;
      for (int i = 0; i < rows; i++)
      {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < columns; j++)
         {
            lights[i][j] = Integer.parseInt(st.nextToken());   
         }
      }
      
      for (int k = 0; k < columns; k++)
      {
         currentCombo = currentCombo + lights[rows - 1][k] + " ";
      }
      combos.add(currentCombo);
      currentCombo = "";
      
      boolean flag;
      for (int i = 1; i < rows; i++)
      {
         newLights = new int[rows][columns];
         for (int n = 0; n < rows; n++)
         {
            System.arraycopy(lights[n], 0, newLights[n], 0, columns);
         }
         for (int j = i; j < rows; j++)
         {
            switchLights(newLights, rows, columns, j);
         }
         for (int k = 0; k < columns; k++)
         {
            currentCombo = currentCombo + newLights[rows - 1][k] + " ";
         }
         flag = true;
         for (int m = 0; m < combos.size(); m++)
         {
            if (currentCombo.equals(combos.get(m)))
            {
               flag = false;
               break;
            }
         }
         if (flag)
         {
            combos.add(currentCombo);
         }
         currentCombo = "";
         
      }
      System.out.println(combos.size());
      
   }
}