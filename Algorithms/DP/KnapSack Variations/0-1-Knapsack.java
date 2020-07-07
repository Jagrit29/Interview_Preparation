import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws 
	IOException{
	    BufferedReader br =new BufferedReader(
	        new InputStreamReader(System.in));
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0)
	        {
	            int n=Integer.parseInt(br.readLine());
	            int W=Integer.parseInt(br.readLine());
	            String v[]=br.readLine().split(" ");
	            String w[]=br.readLine().split(" ");
	            int val[]=new int[n];
	            int wt[]=new int[n];
	            for(int i=0;i<n;i++)
	            {
	                val[i]=Integer.parseInt(v[i]);
	            }
	            for(int i=0;i<n;i++)
	            {
	                wt[i]=Integer.parseInt(w[i]);
	            }
	            
	            int dp[][]=new int[n+1][W+1];
	            
	            //now for each element we can take it or not;
	            for(int i=0;i<=n;i++)
	            {
	                for(int j=0;j<=W;j++)
	                {
	                    //if i means no element is there;
	                    if(i==0)
	                    {
	                        dp[i][j]=0;
	                    }
	                    
	                    if(j==0)
	                    {
	                        dp[i][j]=0;
	                    }
	                    
	                }
	            }
	            
	            for(int i=1;i<=n;i++)
	            {
	                for(int j=1;j<=W;j++)
	                {
	                    //here i is value index; and j is wt;
	                    if(wt[i-1]<=j)
	                    {
	                        //taking this with prev value;
	                        int option1=val[i-1]+dp[i-1][j-wt[i-1]];
	                        int option2=dp[i-1][j];
	                        dp[i][j]=Math.max(option1,option2);
	                    }
	                    else
	                    {
	                        dp[i][j]=dp[i-1][j];
	                    }
	                }
	            }
	            System.out.println(dp[n][W]);
	            
	        }
	}
}
