//Problem Link: https://www.codingninjas.com/studio/problems/partition-equal-subset-sum-_892980

//Memoization

public class Solution 
{
	public static boolean solve(int ind,int[] arr,int k,int[][] dp)
	{
		if(ind == 0) return arr[0] == k;
		if(k == 0) return true;
		if(dp[ind][k] != -1){
			if(dp[ind][k] == 1) return true;
			return false;
		}

		boolean notTake = solve(ind-1,arr,k,dp);
		boolean take = false;
		if(arr[ind] <= k) take = solve(ind-1,arr,k-arr[ind],dp);

		if(take|notTake) dp[ind][k] = 1;
		else dp[ind][k] = 0;

		if(dp[ind][k] == 1) return true;
		return false;
	}

	public static boolean canPartition(int[] arr, int n) 
	{
		int sum = 0;
		for(int i = 0 ; i < n ; i ++) sum += arr[i];
		if(sum%2 != 0) return false;

		int dp[][] = new int[n+1][sum/2+1];
		for(int rows[] : dp) Arrays.fill(rows,-1);

		return solve(n-1,arr,sum/2,dp);
	}
}

//Tabulation
public class Solution 
{
	public static boolean canPartition(int[] arr, int n) 
	{
		int sum = 0;
		for(int i = 0 ; i < n ; i ++) sum += arr[i];
		if(sum%2 != 0) return false;
		int k = sum/2;
		boolean dp[][] = new boolean[n+1][sum/2+1];
		for(int i = 0 ; i < n ; i ++)
		{
			dp[i][0] = true;
		}
		if(arr[0] <= k) dp[0][arr[0]] = true;
		
		for(int ind = 1 ; ind < n ; ind ++)
		{
			for(int target = 1 ; target <= k ; target ++) {
				boolean notTake = dp[ind-1][target];
				boolean take = false;
				if(arr[ind] <= target) take = dp[ind-1][target-arr[ind]];
				dp[ind][target] = take|notTake;
			}
		}
		return dp[n-1][k];
	}
}
