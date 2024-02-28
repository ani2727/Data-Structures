//Problem Link: https://www.codingninjas.com/studio/problems/minimum-path-sum_985349?

//Memoization
public class Solution {
    public static int solve(int row,int col,int[][] grid,int dp[][])
    {
        if(row == 0 && col == 0) return grid[row][col];
        if(row < 0 || col < 0) return (int)1e7;

        if(dp[row][col] != -1) return dp[row][col];

        int up = grid[row][col] + solve(row-1,col,grid,dp);
        int left = grid[row][col] + solve(row,col-1,grid,dp);

        return dp[row][col] = Math.min(up,left);
        
    }
    public static int minSumPath(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int row[] : dp) 
        {
            Arrays.fill(row,-1);
        }
        return solve(m-1,n-1,grid,dp);
    }
}

//Tabulation

public class Solution 
{
    public static int minSumPath(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        
        for(int i = 0 ; i < m ; i ++)
        {
            for(int j = 0 ; j < n ; j ++)
            {
                if(i==0 && j == 0) dp[i][j] = grid[i][j];
                else
                {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i > 0) up = grid[i][j]+dp[i-1][j];
                    if(j > 0) left = grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
