public class DistinctSubsequences {
  public static int numDistinctSubsequence(String S, String T) {
    int m = S.length();
    int n = T.length();
    
    int[][] dp = new int[m + 1][n + 1];
    
    for (int i = 0; i <= m; i++) {
      dp[i][0] = 1;
    }
    
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (S.charAt(i - 1) == T.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }
        else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    
    return dp[m][n];
  }

  public static void main(String[] args) {
    String s = args[0];
    String t = args[1];
    System.out.println(numDistinctSubsequence(s, t));
  }
}
