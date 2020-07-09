class Islands {

    // Function to find the number of island in the given list A
    // N, M: size of list row and column respectively
    public static int x[]={1,1,1,-1,-1,-1,0,0};
    public static int y[]={-1,0,1,-1,0,1,-1,1};
    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {

        int count=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(A.get(i).get(j)==1)
                {
                    //there is island;
                    //connect all islands and make them 0;
                    //increase count as we found one island;
                    dfs(A,N,M,i,j);
                    count++;
                    
                    
                    //Another way is to return 1 from dfs function;
                }
            }
        }
        return count;
        
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> mat, int n,int m,int i,int j)
    {
        if(i<0 || j<0)
        {
            return;
        }
        if(i>=n || j>=m)
        {
            return;
        }
        
        if(mat.get(i).get(j)==0)
        {
            return;
        }
        
        mat.get(i).set(j,0); //making it 0 or visited;
        for(int k=0;k<8;k++)
        {
            int newX=i+x[k];
            int newY=j+y[k];
            dfs(mat,n,m,newX,newY);
        }
    }
}
