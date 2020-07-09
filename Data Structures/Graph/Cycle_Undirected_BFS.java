//here we need to maintain extra parent.
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
       // add your code here
       
       boolean visited[]=new boolean[V];
       int parent[]=new int[V];  //here i will be the node and parent[i] will be the parnet value;
       Arrays.fill(parent,-1);
       
       //Now there is no start node so;
       
       for(int i=0;i<V;i++)
       {
           if(visited[i]==false)
           {
               boolean isCycle=bfs(g,i,visited,parent);
               if(isCycle)
               {
                   return true;
               }
           }
       }
       return false;
    }
    
    static boolean bfs(ArrayList<ArrayList<Integer>> g,int at,boolean visited[],int parent[])
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(at);
        visited[at]=true; //we visited it;
        parent[at]=-1; //no parent; as its start;
        
        while(queue.size()>0)
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                at=queue.poll();
                
                //now we need adj of this at;
                ArrayList<Integer> adj=g.get(at);
                for(int to: adj)
                {
                    //now we need to check if this to is vsitied; or not;
                    if(visited[to]==false)
                    {
                        //not visited;
                        //its parent is at;
                        parent[to]=at;  //parent of to is at;
                        visited[to]=true; //we will add it to queue so its visited;
                        queue.add(to);
                    }
                    else
                    {
                        //now its visited;
                        //to is already visited;
                        //now its visited; we know at's parent is visited;
                        if(to==parent[at])
                        {
                            //now if to is parent of at; its okay;
                            
                            
                        }
                        else
                        {
                            //now at is connected to some other thing which is already visited;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
        
    }
    
    
}
