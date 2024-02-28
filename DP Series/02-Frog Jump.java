//Problem Link: https://www.codingninjas.com/studio/problems/frog-jump_3621012?

//Recursion (Leads to TLE incase of high inputs)
import java.util.* ;
public class Solution 
{
    
    
    public static int frogJump(int n, int arr[]) 
    {
        int prev = 0;
        int prev2 = 0;

        for(int i = 1 ; i < n ; i ++)
        {
            int one_step = prev + Math.abs(arr[i]-arr[i-1]);
            int two_step = Integer.MAX_VALUE;
            if(i > 1)
            {
                two_step = prev2 + Math.abs(arr[i] - arr[i-2]);
            }

            int curr = Math.min(one_step,two_step);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}

//Memoization

import java.util.* ;
public class Solution 
{
    
    public static int solve(int index,int[] arr,int[] dp)
    {
        if(index == 0) return 0;

        if(dp[index] != -1) return dp[index];

        int left = solve(index-1,arr,dp) + Math.abs(arr[index] - arr[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1)
            right = solve(index-2,arr,dp) + Math.abs(arr[index] - arr[index-2]);

        return dp[index] = Math.min(left,right);
    }
    public static int frogJump(int n, int arr[]) 
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n-1,arr,dp);
    }
}

//Tabulation
    
    public static int frogJump(int n, int arr[]) 
    {
        int dp[] = new int[n+1];
        dp[0] = 0; //base condition

        for(int i = 1 ; i < n ; i ++)
        {
            int one_step = dp[i-1]+Math.abs(arr[i] - arr[i-1]);
            int two_step = Integer.MAX_VALUE;
            if(i > 1)
            {
                two_step =dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            }
            dp[i] = Math.min(one_step,two_step);
        }
        return dp[n-1];
    }
}
