import java.util.*;
import java.io.*;

public class MultipleChoice
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int num = Integer.parseInt(br.readLine());
      int correct = 0;
      String[] answers = new String[2 * num];
      
      for (int i = 0; i < 2 * num; i++)
      {
         answers[i] = br.readLine();
      }
      for (int i = 0; i < num; i++)
      {
         if (answers[i].equals(answers[i+num]))
            correct++; 
      }
      System.out.println(correct);
   
   
   }

}