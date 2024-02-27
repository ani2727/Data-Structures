//Problem Link: https://www.codingninjas.com/studio/problems/ninja%E2%80%99s-training_3621003?

//Memoization

import java.util.*;

public class Solution 
{
    public static int solve(int ind,int last_task,int[][] points,int dp[][])
    {
        if(ind == 0)
        {
            int maxi = 0;
            for(int i = 0 ; i < 3 ; i ++)
            {
                if(i != last_task)
                {
                    maxi = Math.max(maxi,points[0][i]);
                }
            }
            return maxi;
        }
        if(dp[ind][last_task] != -1) return dp[ind][last_task];
        int maxi = 0;
        for(int i = 0 ; i < 3 ; i ++)
        {
            if(i != last_task)
            {
                int val = points[ind][i]+solve(ind-1,i,points,dp);
                maxi = Math.max(val,maxi);
            }
        }
        return dp[ind][last_task] = maxi;
    }
    public static int ninjaTraining(int n, int points[][]) 
    {
        int[][] dp = new int[n][4];
        for (int[] row : dp) 
        {
            Arrays.fill(row, -1);
        }
        return solve(n - 1, 3, points, dp);
    }
}

//Tabulation with space

public class Solution
{
    public static int ninjaTraining(int n, int points[][]) 
    {
        int dp[][] = new int[n][4];

        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][1],points[0][0]);
        dp[0][3] = Math.max(points[0][1],Math.max(points[0][0],points[0][2]));
        for(int day = 1 ; day < n ; day ++)
        {
            for(int last = 0 ; last < 4 ; last ++)
            {
                dp[day][last] = 0;
                for(int i = 0 ; i <= 2 ; i ++)
                {
                    if(last != i)
                    {
                        dp[day][last] = Math.max(dp[day][last],points[day][i]+dp[day-1][i]);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
}

//Tabulation with o(4) space

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int prev[] = new int[3];

        prev[0] = points[0][0];
        prev[1] = points[0][1];
        prev[2] = points[0][2];

        for (int day = 1; day < n; day++) 
        {
            int temp[] = new int[3];

            for (int last = 0; last < 3; last++) 
            {
                temp[last] = 0;
                for (int i = 0; i < 3; i++) 
                {
                    if (i != last) 
                    {
                        temp[last] = Math.max(temp[last], points[day][i] + prev[i]);
                    }
                }
            }
            prev = Arrays.copyOf(temp, 3);
        }
        
        return Math.max(prev[0], Math.max(prev[1], prev[2]));
    }
}
