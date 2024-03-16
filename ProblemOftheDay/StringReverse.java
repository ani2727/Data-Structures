//Problem Link: https://www.codingninjas.com/studio/problem-of-the-day/easy

import java.util.* ;
import java.io.*; 

class Solution {

  public static String stringReverse(char[] arr) 
  {
          String s = new String(arr);
          StringBuilder ans = new StringBuilder(s);
          return ans.reverse().toString();
  }
}
