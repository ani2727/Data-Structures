//Problem Link: https://bit.ly/48k0Iz1 

class Solution
{
    static ArrayList<Integer> spirallyTraverse(int arr[][], int r, int c)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        int m = arr[0].length;
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right  = m-1;
        while(top <= bottom && left <= right)
        {
            for(int i = left; i <= right ; i ++)
            {
                list.add(arr[top][i]);
            }
            top ++;
            
            for(int i = top ; i <= bottom ; i ++)
            {
                list.add(arr[i][right]);
            }
            right --;
            
            if(top <= bottom)
            {
                for(int i = right ; i >= left ; i --)
                {
                    list.add(arr[bottom][i]);
                }
                bottom --;
            }
            if(left <= right)
            {
                for(int i = bottom ; i >= top ; i --)
                {
                    list.add(arr[i][left]);
                }
                left ++;
            }
        }
        return list;
    }
}