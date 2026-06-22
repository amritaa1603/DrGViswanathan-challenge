class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
               boolean[][] dp = new boolean[m + 1][n + 1];
                       dp[0][0] = true;
 
        for (int j = 0; j < n; j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '*') {
                   
                    boolean noRepeat = dp[i + 1][j - 1];
                    
                    boolean doRepeat = (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i][j + 1];
                    dp[i + 1][j + 1] = noRepeat || doRepeat;
                } else {
                                     if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}   