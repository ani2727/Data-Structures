//Problem Link: https://bit.ly/48r1hXl  

class Solution
{
    Node temp;
	Node lca(Node root, int n1,int n2)
	{
	   if(root==null || root.data==n1 || root.data==n2) return root;
	   
	   Node left = lca(root.left , n1 , n2);
	   Node right = lca(root.right , n1 , n2);
	   
	   if(left == null) return right;
	   if(right == null) return left;
	   
	   return root;
	}
}
