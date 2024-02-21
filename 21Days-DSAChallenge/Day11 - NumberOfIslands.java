//Problem Link: https://bit.ly/3RFQEcr 

class pair
{
    int first,second;
    
    public pair(int first,int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Solution 
{
    public boolean isSafe(char[][] grid,boolean[][] vis,int x, int y,int R,int C)
    {
        return (x >= 0) && (x < R) && (y >= 0) && (y < C) && grid[x][y] == '1' && !vis[x][y];
    }
    
    public void BFS(char[][] grid,boolean[][] vis,int R,int C, int i, int j)
    {
        
        int row[] = {-1,-1,-1,0,0,1,1,1};
        int col[] = {-1,0,1,-1,1,-1,0,1};
        
        Queue<pair> q = new LinkedList<>();
        
        q.add(new pair(i,j));
        vis[i][j] = true;
        
        while(!q.isEmpty())
        {
            int x = q.peek().first;
            int y = q.peek().second;
            q.poll();
            
            for(int k = 0 ; k < 8 ; k ++)
            {
                if(isSafe(grid,vis,x+row[k],y+col[k],R,C))
                {
                    vis[x+row[k]][y+col[k]] = true;
                    q.add(new pair(x+row[k],y+col[k]));
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) 
    {
        int R = grid.length;
        int C = grid[0].length;
        boolean vis[][] = new boolean[R][C];
        
        int res = 0;
        
        for(int i = 0 ; i < R ; i ++)
        {
            for(int j = 0 ; j < C ; j ++)
            {
                if(grid[i][j] == '1' && !vis[i][j])
                {
                    BFS(grid,vis,R,C,i,j);
                    res ++;
                }
            }
        }
        return res;
    }
}
