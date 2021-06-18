package dynamicProgramming;

public class Rod_Cutting_problm {

	public static void main(String[] args) {
		// same as unbounded knapsack 
		      int price[] =  {1,5,8,9,10,17,17,20};
//		      int price[] = {5, 2, 7, 4, 9};
		      int n = price.length;
		      int length[] = new int[n];
			  for(int i = 0;i<n; i++){
				  length[i]=i+1;
			  }// if this one not given simply creat an array from 1 to n
			  
		   System.out.println(unboundedKnapsack(n, n, price, length));
	}
	static int unboundedKnapsack(int w,int n,int[] val,int[] wt) {
		int[][] dp = new int[n+1][w+1];
	    
	    for(int i = 0; i <= n; i++){
	     for(int j = 0; j <= w; j++){
	         if(i==0 || j==0)
	           dp[i][j]=0;
	      }
	    }
	    
	    for(int i = 1; i <= n; i++){
	     for(int j = 1; j <= w; j++){
	         if(wt[i-1]<=j){
	        	 dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
	         	// if its is knapsack 0 1 then statement  will be 
	         	// then replace this dp[i][j-wt[i-1]] with this dp[i-1][j-wt[i-1]]
	            }else{
	        	 dp[i][j]=dp[i-1][j];
	         }
	       }
	    }
	 
	    return dp[n][w];
	 }
}



