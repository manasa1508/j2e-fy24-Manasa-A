/*
Find the number of unique paths in a n X m grid, starting from [0,0] to [n-1,m-1], where movement is only allowed
either 1 cell down or 1 cell right at a time.
Example 1:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */

import java.util.*;
class prob_2{
    public static int uniquePaths(int m,int n) {
        // Base case: if only one row or one column is left, there is only one path
        if(m==1 || n==1) return 1;
        //recursive calls to find the number of unique paths
        int top=uniquePaths(m-1,n);  //move one row up
        int left=uniquePaths(m,n-1); //move one column to the left
        //return the sum of paths from top and paths from left
        return top+left;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt(); 
        int uniquePathsCount=uniquePaths(m,n);
        System.out.println(uniquePathsCount);
    }
}

