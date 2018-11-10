
// Java program to find minimum step to  
// delete a string 
public class GFG  
{                             
    /* method returns minimum step for deleting 
       the string, where in one step a 
       palindrome is removed 
     */
    static int minStepToDeleteString(String str) { 
        int N = str.length(); 
  
        // declare dp array and initialize it with 0s 
        int[][] dp = new int[N + 1][N + 1]; 
        for (int i = 0; i <= N; i++) 
            for (int j = 0; j <= N; j++) 
                dp[i][j] = 0; 
  
        // loop for substring length we are considering 
        for (int len = 1; len <= N; len++) { 
              
            // loop with two variables i and j, denoting 
            // starting and ending of substrings 
            for (int i = 0, j = len - 1; j < N; i++, j++) { 
      
                // If substring length is 1, then 1 step 
                // will be needed 
                if (len == 1) 
                    dp[i][j] = 1; 
                      
                else { 
                    // delete the ith char individually 
                    // and assign result for  
                    // subproblem (i+1,j) 
                    dp[i][j] = 1 + dp[i + 1][j]; 
  
                    // if current and next char are same, 
                    // choose min from current and  
                    // subproblem (i+2, j) 
                    if (str.charAt(i) == str.charAt(i + 1)) 
                        dp[i][j] = Math.min(1 + dp[i + 2][j],  
                                               dp[i][j]); 
  
                    /* loop over all right characters and  
                      suppose Kth char is same as ith  
                      character then choose minimum from  
                      current and two substring after  
                      ignoring ith and Kth char 
                     */
                    for (int K = i + 2; K <= j; K++) 
                        if (str.charAt(i) == str.charAt(K)) 
                            dp[i][j] = Math.min( 
                                         dp[i + 1][K - 1] + 
                                        dp[K + 1][j], dp[i][j]); 
                } 
            } 
        } 
  
        /* Uncomment below snippet to print actual dp tablex  
           
           for (int i = 0; i < N; i++){ 
           System.out.println();  
           for (int j = 0; j < N; j++)  
           System.out.print(dp[i][j] + " "); 
           } 
            */
              
        return dp[0][N - 1]; 
    } 
  
    // Driver code to test above methods 
    public static void main(String args[]) { 
        String str = "2553432"; 
        System.out.println(minStepToDeleteString(str)); 
    } 
} 