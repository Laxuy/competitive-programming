import java.util.*;
import java.io.*;

public class GenevaConfection
{  
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      Stack<Integer> st = new Stack<Integer>();
      String[] answers = new String[num];
      
      for (int i = 0; i < num; i++)
      {
         int numCars = Integer.parseInt(br.readLine());
         int[] cars = new int[numCars];
         int counter = 1;
         boolean yum = true;
         for (int j = 0; j < numCars; j++)
         {
            cars[j] = Integer.parseInt(br.readLine());
         }
         
         for (int k = numCars - 1; k >= 0; k--)
         {
            if (!st.empty())
            {
               while (st.peek() == counter)
               {
                  counter++;
                  st.pop();
               }
            }
            if (cars[k] == counter)
            {
               counter++;
            } 
            else
            {
               st.push(cars[k]);
            }
         }
         for (int m = 0; m < numCars; m++)
         {
            if (counter == numCars + 1 || st.empty())
            {
               break;
            }
            else if (st.peek() == counter)
            {
               counter++;
               st.pop();
            }
            else
            {
               yum = false;
               break;
            }
         }
         if (yum)
         {
            answers[i] = "Y";
         }
         else
            answers[i] = "N";
      
      }
      for (int i = 0; i < num; i++)
      {
         System.out.println(answers[i]);
      }
   
   
   
   }


}