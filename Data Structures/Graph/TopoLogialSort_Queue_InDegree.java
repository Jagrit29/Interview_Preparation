class TopologicalSort {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        // add your code here
        int inDegree[]=new int[N];
        //inDegree of each node;
        
        for(int i=0;i<adj.size();i++)
        {
            //Now I have all nodes;
            ArrayList<Integer> neigh=adj.get(i); 
            //all nodes neigh is connected to;
            for(int j:neigh)
            {
                //j another edje;
                inDegree[j]++;
            }
        }
        
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<N;i++)
        {
            if(inDegree[i]==0)
            {
                queue.add(i);
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        
        while(queue.size()>0)
        {
            int size=queue.size();
            for(int i=0;i<queue.size();i++)
            {
                int at=queue.poll();
                list.add(at);
                for(int to: adj.get(at))
                {
                    //removing at and all decreasing indegree
                    inDegree[to]--;
                    if(inDegree[to]==0)
                    {
                        queue.add(to);
                    }
                }
            }
        }
        int ans[]=new int[N];
        for(int i=0;i<N;i++)
        {
            ans[i]=list.get(i);
        }
        return ans;
    }
}
