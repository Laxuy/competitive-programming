import java.util.*;
import java.io.*;

public class HuffmanEncoding
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      String[][] codes = new String[2][num];
      String answer = "", current = "";
      StringTokenizer st;
      for (int i = 0; i < num; i++)
      {
         st = new StringTokenizer(br.readLine());
         codes[0][i] = st.nextToken();
         codes[1][i] = st.nextToken();
      }
      String[] word = br.readLine().split("");
      
      for (int i = 0; i < word.length; i++)
      {
         current = current + word[i];
         for (int j = 0; j < num; j++)
         {
            if (codes[1][j].equals(current))
            {
               answer = answer + codes[0][j];
               current = "";
            }
         }
      }
      System.out.print(answer);  
   }  

}