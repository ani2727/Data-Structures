

//Approach 1 : Using BFS

class Solution{
    
    ArrayList<Integer> rightView(Node root) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        while(q.size() > 0)
        {
            int child = q.size();
            for(int i = 0 ; i < child ; i ++)
            {
                Node temp = q.peek();
                if(i == child - 1) list.add(temp.data);
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.offer(temp.right);
                
                q.poll();
            }
        }
        return list;
    }
}

//Approach 2 : Using DFS



class Solution{
    
    void binaryTree(Node root,ArrayList<Integer> list,int level)
    {
        if(root == null)
        {
            return ;
        }
        
        if(level == list.size()) list.add(root.data);
        
        binaryTree(root.right,list, level+1);
        binaryTree(root.left ,list, level+1);
    }
    
    ArrayList<Integer> rightView(Node root) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        binaryTree(root,list,0);
        return list;
    }
}

