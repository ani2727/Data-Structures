//Problem Link:https://bit.ly/3Tsqahn 

class Solution
{
    static String removeChars(String string1, String string2)
    {
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < string1.length() ; i ++)
        {
            char ch = string1.charAt(i);
            if(!string2.contains(String.valueOf(ch)))
            {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
