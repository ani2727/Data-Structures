//Problem Link: https://www.codingninjas.com/studio/problem-of-the-day/moderate

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<ArrayList<Integer>> findGoodMatrix(ArrayList<ArrayList<Integer>> arr) 
	{
			int n = arr.size();
			int m = arr.get(0).size();
			int mat[][] = new int[n][m];

			int col0 = 1;
			for(int i = 0 ; i < n ; i ++)
			{
				for(int j = 0 ; j < m ; j ++)
				{
					if(arr.get(i).get(j) == 0)
					{
						arr.get(i).set(0,0);
						if(j != 0) arr.get(0).set(j,0);
						else col0 = 0;
					}
				}
			}

			for(int i = 1 ; i < n ; i ++)
			{
				for(int j = 1 ; j < m ; j ++)
				{
					if(arr.get(i).get(j) != 0)
					{
						if(arr.get(i).get(0) == 0 || arr.get(0).get(j) == 0)
						{
							arr.get(i).set(j,0);
						}
					}
				}
			}

			if(arr.get(0).get(0) == 0) 
			{
				for(int i = 0 ; i < m ; i ++)
				{
					arr.get(0).set(i,0);
				}
				
			}
			if(col0 == 0) 
			{
				for(int j = 0 ; j < n ; j ++)
				{
					arr.get(j).set(0,0);
				}
			}

			return arr;
	}
}
