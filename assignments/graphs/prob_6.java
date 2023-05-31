/*
 Implement a function to find the number of ways to reach the bottom-right corner of a m x n grid from the top-left
corner, where each cell contains a non-negative integer representing the cost to traverse it. You can only move
down or right at each step.
Example:
Input:
grid = [[1,3,1],
[1,5,1],
[4,2,1]]
Output:
7*/
import java.util.*;
class prob_6{
    public static int uniquePaths(int[][] grid){
        if (grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for (int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for (int i=1;i<m;i++) {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] grid=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        int res=uniquePaths(grid);
        System.out.println(res);
    }
}