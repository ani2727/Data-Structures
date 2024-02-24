//Memoization

public class Solution 
{
	public static int solve(int ind,ArrayList<Integer> nums,int dp[])
	{
		if(ind == 0) return nums.get(0);
		if(ind < 0) return 0;

		if(dp[ind] != -1) return dp[ind];

		int pick = nums.get(ind) + solve(ind-2,nums,dp);
		int notpick = solve(ind-1,nums,dp);

		return dp[ind] = Math.max(pick,notpick);
	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) 
	{
		int dp[] = new int[nums.size()+1];
		Arrays.fill(dp,-1);
		return solve(nums.size()-1,nums,dp);



    }
}

//Tabulation
public class Solution 
{
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) 
	{
		int n = nums.size();
		int dp[] = new int[nums.size()+1];
		dp[0] = nums.get(0);

		for(int i = 1 ; i < n ; i ++)
		{
			int pick = nums.get(i);
			if(i > 1)
				pick += dp[i-2];
			int notpick = dp[i-1];
			dp[i] = Math.max(pick,notpick);
		}
		return dp[n-1];
	}
}