import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws 
	IOException {
	    BufferedReader br =new BufferedReader(
	        new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	    while(t-- > 0)
	    {
	        int n=Integer.parseInt(br.readLine());
	        String s[]=br.readLine().split(" ");
	        int a[]=new int[n];
	        for(int i=0;i<n;i++)
	        {
	            a[i]=Integer.parseInt(s[i]);
	        }
	        
	        int sum=0;
	        for(int i=0;i<n;i++)
	        {
	            sum=sum+a[i];
	        }
	        
	        if(sum%2!=0)
	        {
	            System.out.println("NO");
	            continue;
	        }
	        
	        sum=sum/2;
	        
	        boolean dp[][]=new boolean[n+1][sum+1];
	        
	        for(int i=0;i<=n;i++)
	        {
	            for(int j=0;j<=sum;j++)
	            {
	                //if j==0; always possible;
	                if(j==0 || i==0)
	                {
	                    dp[i][j]=true;
	                }
	                //if i is zero but j is not;
	                if(i==0 && j!=0)
	                {
	                    dp[i][j]=false;
	                }
	            }
	        }
	        
	        for(int i=1;i<=n;i++)
	        {
	            for(int j=1;j<=sum;j++)
	            {
	                //can be added sub from sum;
	                if(a[i-1]<=j)
	                {
	                    boolean option1=dp[i-1][j-a[i-1]]; //subtract this from sum and look for remaining;
	                    boolean option2=dp[i-1][j]; //don't take it;
	                    dp[i][j]=option1 || option2;
	                }
	                else
	                {
	                    dp[i][j]=dp[i-1][j];
	                }
	            }
	        }
	        if(dp[n][sum])
	        {
	            System.out.println("YES");
	        }
	        else
	        {
	            System.out.println("NO");
	        }
	    }
	}
}
