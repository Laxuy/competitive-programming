import java.util.*;
import java.io.*;

public class Ragaman {
   public static void main (String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      String first = st.nextToken();
      st = new StringTokenizer(br.readLine());
      String second = st.nextToken();
      int correct = 0;
      
      char[] firstArr = first.toCharArray();
      char[] secondArr = second.toCharArray();
      
      for (int i = 0; i < first.length(); i++)
      {  
         if (secondArr[i] != '*') {
            
            for (int j = 0; j < first.length(); j++)
            {
               if (secondArr[i] == firstArr[j]) {                  
                  correct++;
                  firstArr[j] = ' ';
                  break;
               }
            }
         }
         else 
            correct++;
      }
      if (correct == first.length())
         System.out.println("A");
      else   
         System.out.println("N");
   
   }


}