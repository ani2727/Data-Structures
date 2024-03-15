//Problem Link: https://bit.ly/3tL452T 


class Solution 
{
    public void generate(int open,int close,StringBuilder sb,List<String> list,int n)
    {
        if(open+close == n*2)
        {
            list.add(sb.toString());
            return;
        }
        if(open < n)
        {
            sb.append('(');
            generate(open+1,close,sb,list,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open)
        {
            sb.append(')');
            generate(open,close+1,sb,list,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> AllParenthesis(int n) 
    {
        List<String> list = new ArrayList<>();
        generate(0,0,new StringBuilder(),list,n);
        return list;
    }
}
