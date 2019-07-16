import java.util.*;
import java.io.*;

public class PartyInvitation {
   public static void main (String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int num = Integer.parseInt(st.nextToken()), removals, counter = 0;
      st = new StringTokenizer(br.readLine());
      removals = Integer.parseInt(st.nextToken());
      int[] friends = new int[num], removalArr = new int[removals];
      for (int i = 0; i < removals; i++) {
         st = new StringTokenizer(br.readLine());
         removalArr[i] =  Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i < num; i++) {
         friends[i] = i + 1;
      }  
      for (int i = 0; i < removals; i++) {
         for (int j = 0; j < num; j++) {
            if (friends[j] != 0)
               counter++;
            if (counter == removalArr[i]) {
               counter = 0;
               friends[j] = 0;
            }
         }
         counter = 0;
      }
      for (int i = 0; i < num; i++) {
         if (friends[i] != 0)
            System.out.println(friends[i]);
      }
   }
}