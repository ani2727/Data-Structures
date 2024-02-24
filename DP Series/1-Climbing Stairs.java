//Problem Link: https://www.codingninjas.com/studio/problems/count-ways-to-reach-the-n-th-stairs_798650?
//With Space
class Solution 
{
    public int climbStairs(int n) 
    {
        
        if(n == 0 || n == 1) return 1;
        
        int dp[] = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i<=n; i++) 
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}

//Without space

class Solution 
{
    public int climbStairs(int n) 
    {
        
        int prev2 = 1;
        int prev = 2;
        
        for(int i = 2; i < n; i ++) 
        {
            int ans = prev+prev2;
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }
}

