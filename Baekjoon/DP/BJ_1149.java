import java.util.*;
public class BJ_1149 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int[][] coin = new int[N+1][4];
      int[][] dp = new int[N+1][4];
      
      for (int i = 1; i <= N; i++) {
         for (int j = 1; j <= 3; j++) {
            coin[i][j] = sc.nextInt();
         }
      }   
      
      for (int i = 1; i <= N; i++) {
         dp[i][1] = Math.min(dp[i-1][2],dp[i-1][3]) + coin[i][1]; // R
         dp[i][2] = Math.min(dp[i-1][1],dp[i-1][3]) + coin[i][2]; // G
         dp[i][3] = Math.min(dp[i-1][1],dp[i-1][2]) + coin[i][3]; // B
      }
      
      System.out.println(Math.min(Math.min(dp[N][1],dp[N][2]), dp[N][3]));      
      
   }

}
