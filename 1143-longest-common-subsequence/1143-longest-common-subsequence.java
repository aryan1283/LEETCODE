class Solution {
    static int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();

        dp=new int[m+1][n+1];
        for(int[] arr: dp){
           Arrays.fill(arr,-1);
        }

        LCS(text1, text2, m, n);
        return dp[m][n];
    }
    int LCS(String text1, String text2, int m, int n){

        if(m==0 || n==0){
          return 0;
        }

        if(dp[m][n]!=-1){
           return dp[m][n];
        }

        if(text1.charAt(m-1)==text2.charAt(n-1)){
            return dp[m][n]= 1+LCS(text1,text2,m-1,n-1);
        }else{
            return dp[m][n]= Math.max(LCS(text1, text2, m-1, n), LCS(text1, text2, m, n-1));
        }

    }
}