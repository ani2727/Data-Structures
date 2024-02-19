

class Solution 
{
    int getPairsCount(int[] arr, int n, int sum) 
    {
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < n ; i ++)
        {
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        
        int count = 0;
        for(int i = 0 ; i < n ; i ++)
        {
            if(mp.get(sum-arr[i]) != null)
            {
                count += mp.get(sum - arr[i]);
            }
            if(sum - arr[i] == arr[i]) count --;
        }
        return count/2;
    }
}