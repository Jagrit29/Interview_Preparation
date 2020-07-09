class Solution
{
 
  public int kosaraju(ArrayList<ArrayList<Integer>> g, int N)
    {
        // Write your code here
        Stack<Integer> stack=new Stack<>();
        
        //first we will perform dfs and store elements in stack;
        
        
        //Performing dfs on graph and putting elements once they are explored in stack
        boolean visited[]=new boolean[N];
        for(int i=0;i<N;i++)
        {
            if(visited[i]==false)
            {
                //solveOne puts them in stack.
                solveOne(g,i,visited,stack);
            }
        }
        
        //Part 2.
        //Creating reverse Edge.
        ArrayList<ArrayList<Integer>> g2=new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            g2.add(new ArrayList<>());
        }
        
        for(int i=0;i<N;i++)
        {
            int v=i; //this is our source in previous graph;
            for(int j: g.get(v))
            {
                //here j is neigh of source of prev graph
                //so in this graph this j becomes main node and i becomes its neighbour;
                g2.get(j).add(v);
            }
        }
        Arrays.fill(visited,false);
        int count=0;
        while(stack.size()>0)
        {
            int i=stack.pop();
            if(visited[i]==false)
            {
                solveTwo(g2,i,visited);
                count++;
            }
        }
        
        return count;
        
    }
    
    public void solveTwo(ArrayList<ArrayList<Integer>> g2, int i, boolean visited[])
    {
        if(visited[i]==true)
        {
            return;
        }
        
        visited[i]=true;
        
        for(int j: g2.get(i))
        {
            if(visited[j]==false)
            {
                solveTwo(g2,j,visited);
            }
        }
    }
    
    
    
    public void solveOne(ArrayList<ArrayList<Integer>> g,int i,boolean visited[],Stack<Integer> stack)
    {
        if(visited[i]==true)
        {
            return;
        }
        visited[i]=true;
        ArrayList<Integer> neigh=g.get(i);
        for(int n:  neigh)
        {
            if(visited[n]==false)
            {
                solveOne(g,n,visited,stack);
            }
        }
        stack.push(i);  //jab pura explor hogea;
        
        
        //Now g2 is transpose;
        
    }
}
