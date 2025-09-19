import java.util.* ;
public class kpsack {
  //Recursion
  public static int KnapSack(int val[],int wt[],int W , int n){
    if(W== 0 || n == 0 ){
      return 0 ;
    }
    if (wt[n-1] <= W) { // valid
      //include 
      int ans1 = val[n-1]+ KnapSack(val,wt,W-wt[n-1],n-1) ;
      //exclude 
      int ans2 = KnapSack(val,wt,W,n-1) ;
      return Math.max(ans1,ans2);
    } else { 
      return KnapSack(val,wt,W,n-1) ;
    }
  }

  //Memoization

  public static int KnapSackM(int val[],int wt[],int W , int n, int dp[][]){
    if(W== 0 || n == 0 ){
      return 0 ;
    }
    if (dp[n][W] != -1) {
      return dp[n][W] ;
    }
    if (wt[n-1] <= W) { // valid
      //include 
      int ans1 = val[n-1]+ KnapSackM(val,wt,W-wt[n-1],n-1,dp) ;
      //exclude 
      int ans2 = KnapSackM(val,wt,W,n-1,dp) ;
      dp[n][W] = Math.max(ans1, ans2) ;
      return dp[n][W];
    } else { 
      dp[n][W] = KnapSackM(val,wt,W,n-1,dp) ;
      return dp[n][W] ;
    }
  }

  //Tabulation 

  public static int knapsackTab(int val[],int wt[],int W){
    int n = val.length  ;
    int dp[][] = new int[n+1][W+1] ;
    
    for(int i =0 ; i < dp.length ; i++){
       dp[i][0] = 0 ;
    }
    for(int j = 0 ; j < dp[0].length ; j++){
        dp[0][j] = 0 ;
      }
    for(int i = 1; i < n+1;i++){
      for(int j = 1 ; j < W+1; j++){
        int v = val[i-1];
        int w = wt[i-1];

        if (w <= j) { //valid
          int ans1 = v + dp[i-1][j-w]; //include
          int ans2 = dp[i-1][j] ;
          dp[i][j] = Math.max(ans1, ans2) ;
        } else {
          dp[i][j] = dp[i-1][j] ;
        }
      }
    }
    return dp[n][W] ;
  }

  public static void main(String args[]) {
    int val[] = {15,12,10,45,30} ;
    int wt[] = {2,5,1,3,4} ;
    int W = 7 ;
    int n = val.length ;
    int dp[][] = new int[val.length+1][W+1] ;
    for (int i = 0 ; i < dp.length; i++){
      for (int j = 0 ; j < dp[0].length ; j++){
        dp[i][j] = -1 ;
      }
    }

    System.out.println(KnapSackM(val, wt, W, n, dp));
    
    System.out.println(KnapSack(val,wt,W,n));

    System.out.println(knapsackTab(val,wt,W));
  }
}
