//Problem Link: https://www.codingninjas.com/studio/problems/count-subsets-with-sum-k_3952532?

//Tabulation with space optimization
public class Solution {
    final static int mod = (int)1e9+7;

    public static int findWays(int arr[], int sum) {
        int n = arr.length;
        int dp[] = new int[sum + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] = (dp[j] + dp[j - arr[i]]) % mod;
            }
        }
        return dp[sum];
    }
}

//Memoization 

public class Solution 
{
    final static int mod = (int)1e9+7;
    public static int solve(int ind,int sum,int arr[],int[][] dp)
    {
        if(sum == 0) return 1;
        if(ind == 0) 
        {
            if(arr[ind] == sum) return 1;
            return 0;
        }
        if(dp[ind][sum] != -1) return dp[ind][sum]%mod;
        int notPick = solve(ind-1,sum,arr,dp)%mod;
        int pick = 0;
        if(arr[ind] <= sum) pick = solve(ind-1,sum-arr[ind],arr,dp)%mod;

        return dp[ind][sum] = (notPick%mod +pick%mod)%mod;
    }
    public static int findWays(int arr[], int sum) 
    {
        int n = arr.length;
        int dp[][] = new int[n][sum+1];
        for(int rows[] : dp) Arrays.fill(rows,-1);
        
        return solve(n-1,sum,arr,dp)%mod;
    }
}
