class Solution
{
    class Orange
    {
        int x;
        int y;
        int level;
        public Orange(int x,int y,int level)
        {
            this.x=x;
            this.y=y;
            this.level=level;
        }
    }
    public int x1[]={0,0,1,-1};
    public int y1[]={1,-1,0,0};
    
    public boolean isSafe(int x,int y,int n,int m)
    {
        if(x<0 || x>=n)
        {
            return false;
        }
        if(y<0 || y>=m)
        {
            return false;
        }
        return true;
    }
    
    public int rotOranges(int a[][],int r, int c)
    {
    
        Queue<Orange> q=new LinkedList<>();
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(a[i][j]==2)
                {
                    q.add(new Orange(i,j,0));
                }
            }
        }
        
        int max=0;
        //is level pe ja ke expire hoga
        while(q.size()>0)
        {
            Orange curr=q.poll();
            max=Math.max(max,curr.level);
            
            //Ab check krna hai iske saath wolo ko
            for(int i=0;i<4;i++)
            {
                int r1=curr.x+x1[i];
                int c1=curr.y+y1[i];
                if(isSafe(r1,c1,r,c) && a[r1][c1]==1)
                {
                    //ye rot krege aur next level pe;
                    q.add(new Orange(r1,c1,curr.level+1));
                    a[r1][c1]=2; //rotted;
                }
            }
        }
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(a[i][j]==1)
                {
                    return -1;
                }
            }
        }
        return max;
        
    }
}
      
