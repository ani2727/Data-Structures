
//Tabulation
public class Solution 
{
	public static long solve(int n,ArrayList<Integer> nums)
	{
		long prev = nums.get(0);
		long prev2 = 0;

		for(int i = 1 ; i < n ;i ++)
		{
			long pick = nums.get(i);
			if(i > 1) pick += prev2;

			long notpick = prev;

			long curr = Math.max(pick,notpick);

			prev2 = prev;
			prev = curr;
		}
		return prev;
	}
	public static long houseRobber(int[] house) 
	{
		int n = house.length;
		if(n == 1) return house[0];
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		for(int i = 0 ; i < n; i ++)
		{
			if(i != 0) list1.add(house[i]);
			if(i != n-1) list2.add(house[i]);
		}

		return Math.max(solve(n-1,list1),solve(n-1,list2));

	}
}