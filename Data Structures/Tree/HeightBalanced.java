boolean isBalanced(Node root)
    {
	// Your code here
	    solve(root);
	    if(ans==-1)
	    {
	        return false;
	    }
	    else
	    {
	        return true;
	    }
    }
    public int ans=0;
    int solve(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=1+solve(root.left);
        int right=1+solve(root.right);
        
        if(Math.abs(left-right)>1)
        {
            ans=-1;
        }
        return Math.max(left,right);
    }
