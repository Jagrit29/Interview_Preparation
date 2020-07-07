class Tree
{

/* If n1 and n2 are present, return reference
   to LCA. If both are not present, return 
   null,. Else if left subtree contains any 
   of them return pointer to left.*/
	Node lca(Node root, int n1,int n2)
	{
	    if(root==null)
	    {
	        return null;
	    }
	    if(root.data==n1 || root.data==n2)
	    {
	        //we have found any of them;
	        return root;
	    }
	    Node left=lca(root.left,n1,n2);
	    Node right=lca(root.right,n1,n2);
	    
	    //Now if we have found ans in left and right;
	    if(left!=null && right!=null)
	    {
	        return root; //this is the lca;
	    }
	    if(left==null)
	    {
	        //if left is null and means we have no ans from left;
	        return right;
	    }
	    else
	    {
	        return left; //if left is not null; means we have ans from left;
	    }
	}
}

