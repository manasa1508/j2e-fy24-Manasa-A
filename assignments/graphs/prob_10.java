/*
Implement a function to find the number of connected components in an undirected graph.
Example:
Input:
n = 5, edges = [[0,1],[1,2],[3,4]]
Output:
2
*/
import java.util.*;
class Solution{
    public int countComponents(int n, int[][] edges){
        if(n<=0 || edges==null || edges.length == 0){
            return n;
        }
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u=edge[0];
            int v=edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0; i<n;i++){
            if(!visited[i]){
                dfs(i,adjList,visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}
public class prob_10{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][] edges=new int[e][2];
        for(int i=0;i<e;i++){
            for(int j=0;j<2;j++){
                edges[i][j]=sc.nextInt();
            }
        }
        Solution sol=new Solution();
        int numComponents=sol.countComponents(v,edges);
        System.out.println(numComponents);
    }
}
