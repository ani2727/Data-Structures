//Problem Link: https://www.codingninjas.com/studio/problems/maximum-path-sum-in-the-matrix_797998?

//Memoization

public class Solution 
{
	public static int solve(int i,int j,int matrix[][],int[][] dp)
	{
		if(j < 0 || j >= matrix[0].length) return (int)-1e8;
		if(i == 0) return matrix[i][j];
		if(dp[i][j] != -1) return dp[i][j];
		int up = matrix[i][j]+solve(i-1,j,matrix,dp);
		int left_diagonal = matrix[i][j]+solve(i-1,j-1,matrix,dp);
		int right_diagonal = matrix[i][j]+solve(i-1,j+1,matrix,dp);

		return dp[i][j]=Math.max(up,Math.max(left_diagonal,right_diagonal));
	}
	public static int getMaxPathSum(int[][] matrix) 
	{
		
		int n = matrix.length;
		int m = matrix[0].length;
		int dp[][] = new int[n][m];
		for(int rows[] : dp) Arrays.fill(rows,-1);
		int ans = Integer.MIN_VALUE;
		for(int j = 0 ; j < m ; j ++)
		{
			int maxi = solve(n-1,j,matrix,dp);
			ans = Math.max(ans,maxi);
		}
		return ans;
	}
}


//Tabulation

public class Solution 
{
	public static int getMaxPathSum(int[][] matrix) 
	{
		
		int n = matrix.length;
		int m = matrix[0].length;
		int dp[][] = new int[n][m];
		
		for(int j = 0 ; j < m ; j ++)
		{
			dp[0][j] = matrix[0][j];
		}
		for(int i = 1 ; i < n ; i ++)
		{
			for(int j = 0 ; j < m ; j ++)
			{
				int up = 0,ld = Integer.MIN_VALUE,rd = Integer.MIN_VALUE;
				up = dp[i-1][j] + matrix[i][j];
				if(j-1 >= 0) ld = dp[i-1][j-1] + matrix[i][j];
				if(j+1 < m) rd = dp[i-1][j+1] + matrix[i][j];

				dp[i][j] = Math.max(up,Math.max(ld,rd));
			}
		}

		int maxi = Integer.MIN_VALUE;
		for(int j = 0 ; j < m ; j ++)
		{
			maxi = Math.max(dp[n-1][j],maxi);
		}
		return maxi;
	}
}
