import java.util.*;
import java.io.*;

public class AromaticNumbers
{
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int sum = 0;
      String[] word = br.readLine().split("");
      int[] numbers = new int[word.length];
      for (int i = 0; i < word.length; i++)
      {
         if (word[i].equals("I"))
            numbers[i] = 1;
         else if (word[i].equals("V"))
            numbers[i] = 5;
         else if (word[i].equals("X"))
            numbers[i] = 10;
         else if (word[i].equals("L"))
            numbers[i] = 50;
         else if (word[i].equals("C"))
            numbers[i] = 100;
         else if (word[i].equals("D"))
            numbers[i] = 500;
         else if (word[i].equals("M"))
            numbers[i] = 1000; 
         else
            numbers[i] = Integer.parseInt(word[i]);
      }
      for (int i = 0; i < word.length - 1; i+=2)
      {
         if (i == word.length - 2)
         {
            sum+= numbers[i+1] * numbers[i];
         }
         else if (numbers[i+1] >= numbers[i+3])
         {
            sum += numbers[i+1] * numbers[i];
         }
         else if (numbers[i+1] < numbers[i+3])
         {
            sum -= numbers[i+1] * numbers[i];
         }
      }
      System.out.println(sum);
   }
}