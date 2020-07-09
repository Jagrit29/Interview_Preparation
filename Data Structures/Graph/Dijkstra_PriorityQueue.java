class Pair
{
    int ind;
    int cost;
    public Pair(int ind,int cost)
    {
        this.ind=ind;
        this.cost=cost;
    }
}

class Comp implements Comparator<Pair>
{
    public int compare(Pair p1, Pair p2)
    {
        return p1.cost-p2.cost;
    }
}
class Solution
{
    static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int V)
    {
        // Write your code here
        boolean visited[]=new boolean[V];
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comp());
        dist[src]=0;
        Pair p1=new Pair(src,0); //node and its cost;
        pq.add(p1);
        while(pq.size()>0)
        {
            Pair at=pq.poll(); //it has index and cost;
            visited[at.ind]=true; //we are at; we visited;
            ArrayList<Integer> adj=g.get(at.ind); //neighbours of at.ind;
            for(int i=0;i<adj.size();i++)
            {
                //this will tell cost to reach from at to all adj;
                int cost=adj.get(i);
                if(cost==0)
                {
                    //this is means its not adjacent;
                }
                else
                {
                    //here now to is our i;
                    //new distance can be distance to at + this cost of i;
                    
                    //it should not be visited;
                    if(visited[i]==false)
                    {
                        int newDist=dist[at.ind]+cost;
                        if(newDist<dist[i])
                        {
                            //System.out.println("Hello");
                            dist[i]=newDist; //dist to reach i is newDist;
                            //now to reach i is newDist;
                           //visited[i]=true; //now we cant do this here;  //because we need to consider this later;
                            pq.add(new Pair(i,newDist));
                        }
                    }
                }
            }
        }
        return dist;
        
    }
}

