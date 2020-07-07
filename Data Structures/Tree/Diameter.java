class Tree {
    /* Complete the function to get diameter of a binary tree */
    public int res=0;
    int diameter(Node root) {
        // Your code here
        if(root==null)
        {
            return res;
        }
        solve(root);
        return res;
    }
    int solve(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=solve(root.left);
        int right=solve(root.right);
        
        int temp=Math.max(left,right)+1;
        int ans=Math.max(temp,left+right+1);
        res=Math.max(ans,res);
        
        return temp;
    }
}
