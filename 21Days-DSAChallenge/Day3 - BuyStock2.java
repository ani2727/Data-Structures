//Problem Link:https://bit.ly/48uaNZM

class Solution{
    public long maximumProfit(long prices[], int n)
    {
        int start = 0;
        int end = 0;
        long max_profit = 0;
        for(int i = 1 ; i < n ; i++)
        {
            if(prices[i] > prices[i-1])
            {
                end = i;
            }
            else
            {
                max_profit += prices[end] - prices[start];
                start = i;
                end = i;
            }
        }
        max_profit += prices[end] - prices[start];
        return max_profit;
    }
}
