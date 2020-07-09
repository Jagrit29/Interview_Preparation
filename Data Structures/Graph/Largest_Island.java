class Area {
    public static int x[]={1,1,1,-1,-1,-1,0,0};
    public static int y[]={-1,0,1,-1,0,1,-1,1};
    static int findMaxArea(int N, int M, int A[][]) {
        
        int max=0;
        int curr=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(A[i][j]==1)
                {
                    //possiblitity of matrix;
                    curr=dfs(A,N,M,i,j);
                    max=Math.max(curr,max);
                }
            }
        }
        return max;
        
    }
    
    static int dfs(int A[][],int n,int m,int i,int j)
    {
        if(i<0 || j<0)
        {
            return 0;
        }
        if(i>=n || j>=m)
        {
            return 0;
        }
        if(A[i][j]==0)
        {
            return 0;
        }
        A[i][j]=0; //now if its counted onces means its counted;
        int count=1; //its one;; and look for more.
        for(int k=0;k<8;k++)
        {
            int newX=i+x[k];
            int newY=j+y[k];
            count+=dfs(A,n,m,newX,newY);
        }
        return count;
    }
}
