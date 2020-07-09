//dfs approach;
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
       // add your code here
       boolean visited[]=new boolean[V];
       int parent=-1;
       for(int i=0;i<V;i++)
       {
           if(visited[i]==false)
           {
               boolean isCycle=solve(g,i,parent,visited);
               if(isCycle)
               {
                   return true;
               }
           }
       }
       return false;
    }
    
    static boolean solve(ArrayList<ArrayList<Integer>> g,int at,int parent,boolean visited[])
    {
        visited[at]=true;
        ArrayList<Integer> adj=g.get(at);
        for(int to: adj)
        {
            if(visited[to])
            {
                //now to is already visited; 
                //now if to is its parent that is at comes after to its okay;
                if(to!=parent)
                {
                    //now to is anything other then its parent;
                    return true;
                }
            }
            else
            {
                if(solve(g,to,at,visited))  //aage check krege;
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    
}
