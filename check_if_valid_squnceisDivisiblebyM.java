
#include <bits/stdc++.h> 
using namespace std; 
  
const int MAX = 100; 
  
int isPossible(int n, int index, int modulo, 
            int M, int arr[], int dp[][MAX]) 
{ 
    // Calculate modulo for this call 
    modulo = ((modulo % M) + M) % M; 
  
    // Base case 
    if (index == n) { 
  
        // check if sum is divisible by M 
        if (modulo == 0) 
            return 1; 
        return 0; 
    } 
  
    // check if the current state is  
    // already computed 
    if (dp[index][modulo] != -1)  
        return dp[index][modulo]; 
  
    // 1.Try placing '+' 
    int placeAdd = isPossible(n, index + 1, 
            modulo + arr[index], M, arr, dp); 
  
    // 2. Try placing '-' 
    int placeMinus = isPossible(n, index + 1,  
            modulo - arr[index], M, arr, dp); 
  
    // calculate value of res for recursive 
    // case 
    bool res = (placeAdd || placeMinus); 
  
    // store the value for res for current  
    // states and return for parent call 
    dp[index][modulo] = res; 
    return res; 
} 
  
int main() 
{ 
    int arr[] = { 1, 2, 3, 4, 6 }; 
    int n = sizeof(arr)/sizeof(arr[0]); 
    int M = 4; 
  
    // MAX is the Maximum value M can take 
    int dp[n + 1][MAX]; 
    memset(dp, -1, sizeof(dp)); 
  
    bool res; 
    res = isPossible(n, 1, arr[0], M, arr, dp); 
  
    cout << (res ? "True" : "False") << endl; 
    return 0; 
} 