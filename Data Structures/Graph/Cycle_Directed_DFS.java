class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        // add your code here
        boolean visited[]=new boolean[V];
        boolean stack[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                boolean check=dfs(adj,i,-1,visited,stack);
                if(check)
                {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> adj,int i,int parent,boolean visited[],boolean stack[])
    {
        if(stack[i]==true)
        {
            return true; //this is in stack;
        }
        if(visited[i]==true)
        {
            return false; //if its already visited;
        }
        stack[i]=true;
        visited[i]=true;
        ArrayList<Integer> neigh=adj.get(i);
        for(int to:neigh)
        {
            if(dfs(adj,to,parent,visited,stack))
            {
                return true;
            }
            
        }
        stack[i]=false; //remove out of stack;
        return false;
    }
}
