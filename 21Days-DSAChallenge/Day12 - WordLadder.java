//Problem Link: https://bit.ly/48pveY2 

class pair {
    String first;
    int second;
    
    public pair(String first,int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<pair> q = new LinkedList<>();
        
        q.add(new pair(startWord,1));
        
        Set<String> st = new HashSet<>(Arrays.asList(wordList));
        
        st.remove(startWord);
        boolean flag = false;
        while(!q.isEmpty())
        {
            String str = q.peek().first;
            StringBuilder sb = new StringBuilder(str);
            int level = q.peek().second;
            q.poll();
            if(sb.toString().equals(targetWord)) return level;
            for(int i = 0 ; i < str.length() ; i ++)
            {
                char original = sb.charAt(i);
                
                for(char ch = 'a'; ch <= 'z' ; ch ++)
                {
                    sb.setCharAt(i,ch);
                    if(st.contains(sb.toString()))
                    {
                        st.remove(sb.toString());
                        q.add(new pair(sb.toString(),level+1));
                    }
                }
                sb.setCharAt(i,original);
            }
        }
        return 0;
    }
}
