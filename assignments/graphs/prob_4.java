
/*
 Given a matrix of 0's and 1's, implement a function to find the number of islands in the matrix, where an island is a
group of connected 1's.
Example:
Input:
matrix = [[1,1,1,1,0],
[1,1,0,1,0],
[1,1,0,0,0],
[0,0,0,0,0]]
Output:
1

*/
import java.util.*;
class prob_4{
    public static int numIslands(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public static void bfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0)
            return;
        grid[i][j]=0;
        bfs(grid,i+1,j);
        bfs(grid,i-1,j);
        bfs(grid,i,j-1);
        bfs(grid,i,j+1);
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
        int res=numIslands(grid);
        System.out.println(res);
    }
}