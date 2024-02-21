//Problem Link:  https://bit.ly/4aqvKa0 

class Solution {
    void mirror(Node root) 
    {
        if(root == null) return ;
        
        Node temp = root.left;
        
        root.left = root.right;
        
        root.right = temp;
        
        mirror(root.left);
        mirror(root.right);
    }
}
