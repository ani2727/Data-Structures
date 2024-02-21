//Problem Link: https://bit.ly/48zyVdS  

class Solution {
    static int mod = (int)1e9+7;
    
    static int nthFibonacci(int n)
    {
        if(n <= 1) return n;
        int prev = 1;
        int nextprev = 0;
        for(int i = 2 ; i <= n ; i ++)
        {
           
            
            int current = (prev%mod + nextprev%mod)%mod;
            nextprev = prev%mod;
            prev = (current)%mod;
        }
        return prev%mod;
    }
}
