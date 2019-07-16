import java.util.*;
import java.io.*;

public class AssigningPartners
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine());
      String[] names1 = br.readLine().split(" ");
      String[] names2 = br.readLine().split(" ");
      String[] partners = new String[num];
      String result = "good";
      
      for (int i = 0; i < num; i++)
      {
         if (names1[i].equals(names2[i]))
            result = "bad";
         partners[i] = names1[i] + " " + names2[i];
      
      }
      for (int i = 0; i < num; i++)
      {
         for (int j = 0; j < num; j++)
         {
            if ((partners[j].contains(partners[i].split(" ")[0]) && !partners[j].contains(partners[i].split(" ")[1]))
               || (partners[j].contains(partners[i].split(" ")[1]) && !partners[j].contains(partners[i].split(" ")[0])))
            {
               result = "bad";
            }
         }
      }
      System.out.println(result);
      
   }


}