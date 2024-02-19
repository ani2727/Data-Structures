class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) 
    {
       int dp[] = new int[n];
       Arrays.fill(dp,0);
       for(int i = 0 ; i < grid.size() ; i ++)
       {
           dp[i] = grid.get(n-1).get(i);
       }
       
       for(int i = n-2 ; i >= 0 ; i --)
       {
           for(int j = 0 ; j < grid.get(i).size() ; j ++)
           {
               dp[j] = Math.min(dp[j],dp[j+1]) + grid.get(i).get(j);
           }
       }
       
       return dp[0];
    }
}