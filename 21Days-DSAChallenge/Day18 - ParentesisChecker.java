
//Problem Link:https://bit.ly/3RIoaPl 

class Solution
{
    static boolean ispar(String x)
    {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < x.length() ; i ++)
        {
            char c = x.charAt(i);
            if(c == '(' || c == '[' || c == '{') st.push(c);
            else
            {
                if(st.isEmpty()) return false;
                char ch = st.peek();
                st.pop();
                if(ch == '(' && c == ')') continue;
                if(ch == '{' && c == '}') continue;
                if(ch == '[' && c == ']') continue;
                
                return false;
            }
        }
        return st.isEmpty();
    }
}