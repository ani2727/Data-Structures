//Problem Link:https://bit.ly/3H6DjoS 

class Solve{
    
    long maxArea(int arr[], int n)
    {
        long max_water = 0;
        
        int i = 0;
        int j = n-1;
        while(i < j)
        {
            int dist = j-i;
            max_water = Math.max(max_water,Math.min(arr[i],arr[j])*dist);
            if(arr[i] < arr[j]) i ++;
            else j --;
        }
        return max_water;
    }
    
}