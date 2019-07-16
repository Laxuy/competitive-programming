import java.util.*;
import java.io.*;

public class BridgeTransport
{  
   public static void main(String[] args) throws IOException
   {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int maxWeight = Integer.parseInt(br.readLine());
      int numCars = Integer.parseInt(br.readLine());
      int[] weights = new int[numCars];
      for (int i = 0; i < numCars; i++)
      {
         weights[i] = Integer.parseInt(br.readLine());
      }
      int maxCars = 0;
      
      if (numCars > 3)
      {
         for (int i = 0; i < numCars - 3; i++)
         {
            if (i != numCars - 4 && weights[i] + weights[i+1] + weights[i+2] + weights[i+3] <= maxWeight)
            {
               maxCars++;
            }
            else if (i == numCars - 4 && weights[i] + weights[i+1] + weights[i+2] + weights[i+3] <= maxWeight)
            {
               maxCars+=4;
               break;
            }
            else if (weights[i] + weights[i+1] + weights[i+2] <= maxWeight)
            {
               maxCars+=3;
               break;
            } 
            else if (weights[i] + weights[i+1] <= maxWeight)
            {
               maxCars+=2;
               break;
            } 
            else if (weights[i] <= maxWeight)
            {
               maxCars++;
               break;
            } 
            else
            {
               break;
            }
         }
      }
      else if (numCars == 3)
      {
         if (weights[0] + weights[1] + weights[2] <= maxWeight)
         {
            maxCars+=3;
         } 
         else if (weights[0] + weights[1] <= maxWeight)
         {
            maxCars+=2;
         }
         else if (weights[0] <= maxWeight)
         {
            maxCars++;
         }
      }
      else if (numCars == 2)
      {
         if (weights[0] + weights[1] <= maxWeight)
         {
            maxCars+=2;
         }
         else if (weights[0] <= maxWeight)
         {
            maxCars++;
         }
      }
      else if (numCars == 1)
      {
         if (weights[0] <= maxWeight)
         {
            maxCars++;
         }
      }
      System.out.println(maxCars);
   
   
   }

}