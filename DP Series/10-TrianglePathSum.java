//Problem Link: https://www.codingninjas.com/studio/problems/triangle_1229398?

//Memoization
public class Solution {
    public static int solve(int i,int j,int[][] arr,int n,int[][] dp)
    {
        if(i == n-1) return arr[i][j];

        if(dp[i][j] != -1) return dp[i][j];


        int down = arr[i][j]+solve(i+1,j,arr,n,dp);
        int down_right = arr[i][j]+solve(i+1,j+1,arr,n,dp);

        return dp[i][j] = Math.min(down,down_right);
    }
    public static int minimumPathSum(int[][] arr, int n) 
    {
        int dp[][] = new int[n][n];
        for(int row[] : dp) Arrays.fill(row,-1);
        return solve(0,0,arr,n,dp);
    }
}

//Tabulation
public class Solution {
    
    public static int minimumPathSum(int[][] arr, int n) 
    {
        int dp[][] = new int[n][n];
        for(int j = 0 ; j < n ; j ++)
        {
            dp[n-1][j] = arr[n-1][j];
        }
        for(int i = n-2; i >= 0 ; i --)
        {
            for(int j = 0 ; j <= i ; j ++)
            {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+arr[i][j];
            }
        }
        return dp[0][0];
    }
}
