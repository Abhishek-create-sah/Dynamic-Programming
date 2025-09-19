import java.util.* ;

public class climb_stair {


  // Recursive time complex huge
   public static int ways(int n){
            if(n==0) return 1 ;
            if(n<1) return 0 ;
            
            return ways(n-1) + ways(n-2) ;
        }

// Memoization
public static int waysMm(int n , int dp[]){
  if (n == 0){
    return 1 ;
  }
  if (n < 0){
    return 0 ;
  }

  if (dp[n] != -1) {
    return dp[n] ;
  }
  dp[n] = waysMm(n-1, dp) + waysMm(n-2, dp) ;
  return dp[n] ;
}

//tabulization 

public static int wayTab(int n ) {
  int dp[] = new int[n+1] ;
  dp[0] = 1 ;
  for (int i = 1 ; i <= n ;i++){
    if( i == 1) {
      dp[i] = dp[i-1] ;
    } else {
      dp[i] = dp[i-1] + dp[i-2] ;
    }
    
  }
  return dp[n] ;
}

    public static void main(String args[]){
      int n = 5 ;
      int dp[] = new int[n+1] ;
      // for(int i = 0 ; i < dp.length ; i++){
      //    dp[i] = -1 ;
      // }
      Arrays.fill(dp , -1) ;
      System.out.println(waysMm(n, dp));
      System.out.println(ways(5)) ;
      System.out.println(wayTab(n));
    }
}