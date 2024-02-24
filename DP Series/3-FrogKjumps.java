//Memoization

import java.util.*;

public class Solution 
{
    public static int solve(int ind,int k,int[] heights,int dp[])
    {
        if(ind == 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int min_steps = Integer.MAX_VALUE;
        for(int i = 1 ; i <= k ; i ++)
        {
            if(ind - i >= 0)
            {
                int mini = solve(ind-i,k,heights,dp) + Math.abs(heights[ind]-heights[ind-i]);
                min_steps = Math.min(mini,min_steps);
            }
             
        }

        return dp[ind] = min_steps;
    }
    public static int minimizeCost(int n, int k, int []height)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n-1,k,height,dp);
    }
}

//Tabulation
import java.util.*;

public class Solution 
{
    
    public static int minimizeCost(int n, int k, int []heights)
    {
        int dp[] = new int[n+1];
        
        dp[0] = 0;

        
        for(int i = 1 ; i < n ; i ++)
        {
            int min_steps = Integer.MAX_VALUE;
            for(int j = 1 ; j <= k ; j ++)
            {
                if(i-j >= 0)
                {
                    int mini = dp[i-j] + Math.abs(heights[i]-heights[i-j]);
                    min_steps = Math.min(mini,min_steps);
                }
            }
            dp[i] = min_steps;
        }
        return dp[n-1];
    }
}