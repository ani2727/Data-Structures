//Problem Link: https://www.codingninjas.com/studio/problems/unique-paths-ii_977241?

//Memoization
public class Solution {
    final static int mod = (int)1e9+7;

    public static int solve(int row,int col,int[][] dp,ArrayList<ArrayList<Integer>> mat)
	{
        if(row>= 0 && col >= 0 && mat.get(row).get(col) == -1) return 0;
		if(row==0 && col==0) return 1;
		if(row<0 || col<0) return 0;
		if(dp[row][col] != -1) return dp[row][col];
		int up = solve(row-1,col,dp,mat);
		int left = solve(row,col-1,dp,mat);

		return dp[row][col] = (up+left)%mod;
	}
    public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) 
    {
        int dp[][] = new int[n][m];
		for(int row[]: dp)
		{
			Arrays.fill(row,-1);
		}

		return solve(n-1,m-1,dp,mat);
    }
}

//Tabulation
public class Solution {
    public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) 
    {
        int mod = (int)1e9+7;
        int dp[][] = new int[n][m];
		
		dp[0][0] = 1;

		for(int i = 0 ; i < n ; i ++)
		{
			for(int j = 0 ; j < m ; j ++)
			{
                if(mat.get(i).get(j) == -1) dp[i][j] = 0;
				else if(i==0 && j== 0) continue;
				else
                {
                    int up = 0;
                    int left = 0;
                    if(i > 0) up = dp[i-1][j];
                    if(j > 0) left = dp[i][j-1];

                    dp[i][j] = (up+left)%mod;
                }
			}
		}
		return dp[n-1][m-1];
    }

}
