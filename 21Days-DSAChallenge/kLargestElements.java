

class Solution
{
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0 ; i < n ; i ++)
        {
            pq.offer(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ;i < k ; i ++)
        {
            list.add(pq.poll());
        }
        return list;
    }
}