//Problem Link:https://bit.ly/3TMU9ka

class Solution
{   
	static int findLongestConseqSubseq(int arr[], int n)
	{
	    Arrays.sort(arr);
	    int max_length = 1;
	    int ct = 1;
	    for(int i = 1 ; i < n ; i ++)
	    {
	        if(arr[i] == arr[i-1]+1) ct++;
	        else if(arr[i] == arr[i-1]) continue;
	        else
	        {
	            max_length = Math.max(max_length,ct);
	            ct = 1;
	        }
	    }
	    max_length = Math.max(max_length,ct);
	            ct = 1;
	    return max_length;
	}
}