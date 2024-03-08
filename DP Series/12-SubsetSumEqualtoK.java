//Problem Link : https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?

//Memoization 

public class Solution {
    public static boolean solve(int ind, int k, int arr[],int[][] dp)
    {
        if(k == 0) return true;
        if(ind == 0) return arr[0] == k;

        if(dp[ind][k] != -1)
        {
            if(dp[ind][k] == 0) return false;
            return true;
        }
        
        boolean take = false;
        if(arr[ind] <= k) take = solve(ind-1,k-arr[ind],arr,dp);
        boolean nottake = solve(ind-1,k,arr,dp);

        if(take | nottake) dp[ind][k] = 1;
        else dp[ind][k] = 0;
        if(dp[ind][k] == 0) return false;
        return true;
    }
    public static boolean subsetSumToK(int n, int k, int arr[])
    {
        int dp[][] = new int[n+1][k+1];
        for(int rows[] : dp)
            Arrays.fill(rows,-1);
        if(solve(n-1,k,arr,dp)) return true;
        return false;
    }
}

//Tabulation

public class Solution 
{
    public static boolean subsetSumToK(int n, int k, int arr[]) 
    {
        boolean dp[][] = new boolean[n][k + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) 
        {
            for (int j = 1; j <= k; j++) 
            {
                dp[i][j] = dp[i - 1][j];
                if (arr[i] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i]];
            }
        }
        return dp[n - 1][k];
    }
}


