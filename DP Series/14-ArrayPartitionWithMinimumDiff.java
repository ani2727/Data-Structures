//Problem Link: https://www.codingninjas.com/studio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum._842494?

//Code
public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) 
    {
        int sum = 0;
		for(int i = 0 ; i < n ; i ++) sum += arr[i];
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
        int mini = Integer.MAX_VALUE;
        for(int target = 0 ; target <= k ; target ++)
        {
            if(dp[n-1][target] == true) {
                mini = Math.min(mini,Math.abs(sum-target)-target);
            }
        }
        return mini;
    }
}
