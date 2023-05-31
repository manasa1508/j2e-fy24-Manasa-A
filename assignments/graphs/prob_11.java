/*
Implement a function to find the length of the longest increasing path in a matrix of integers, where a path is
defined as a sequence of cells that are adjacent horizontally or vertically and whose values are in strictly increasing
order.
Example:
Input:
matrix = [[9,9,4],
[6,6,8],
[2,1,1]]
Output:
4
*/
import java.util.*;
class prob_11{
    public static final int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    public static int longestIncreasingPath(int[][] matrix){
        if(matrix.length==0) return 0;
        int m = matrix.length,n=matrix[0].length;
        int[][] cache=new int[m][n];
        int max=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int len=dfs(matrix,i,j,m,n,cache);
                max=Math.max(max,len);
            }
        }   
        return max;
    }
    public static int dfs(int[][] matrix,int i,int j,int m,int n,int[][] cache){
        if(cache[i][j]!=0) return cache[i][j];
        int max=1;
        for(int[] dir:dirs) {
            int x=i+dir[0],y=j+dir[1];
            if(x<0 || x >= m || y<0 || y>=n || matrix[x][y]<=matrix[i][j]) continue;
            int len=1+dfs(matrix,x,y,m,n,cache);
            max=Math.max(max,len);
        }
        cache[i][j]=max;
        return max;
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
        int res=longestIncreasingPath(grid);
        System.out.println(res);
    }
}