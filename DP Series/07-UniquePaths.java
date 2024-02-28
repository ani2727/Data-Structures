//Problem Link: https://www.codingninjas.com/studio/problems/unique-paths_1081470?

//Memoization
public class Solution 
{
	public static int solve(int row,int col,int[][] dp)
	{
		if(row==0 && col==0) return 1;
		if(row<0 || col<0) return 0;
		if(dp[row][col] != -1) return dp[row][col];
		int up = solve(row-1,col,dp);
		int left = solve(row,col-1,dp);

		return dp[row][col] = up+left;
	}
	public static int uniquePaths(int m, int n) 
	{
		int dp[][] = new int[m][n];
		for(int row[]: dp)
		{
			Arrays.fill(row,-1);
		}

		return solve(m-1,n-1,dp);
	}
}


//Tabulation
public class Solution 
{
	
	public static int uniquePaths(int m, int n) 
	{
		int dp[][] = new int[m][n];
		
		dp[0][0] = 1;

		for(int i = 0 ; i < m ; i ++)
		{
			for(int j = 0 ; j < n ; j ++)
			{
				if(i==0 && j== 0) continue;
				
				int up = 0;
				int left = 0;
				if(i > 0) up = dp[i-1][j];
				if(j > 0) left = dp[i][j-1];

				dp[i][j] = up+left;
			}
		}
		return dp[m-1][n-1];
	}
}