//Problem Link: https://www.codingninjas.com/studio/problems/new-position_975266?

import java.util.*;
import java.io.*; 

public class Solution {
	public static int findInteger(int n, int k) 
	{
			int mid = (int)Math.ceil(n/2.0);
			if(k <= mid)
			{
				return 2*(k-1)+1;
			}
			k = Math.abs(k-mid);
			return 2*k;
	}

}
