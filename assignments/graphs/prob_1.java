/*
 * 1. Given a directed acyclic graph (DAG), implement a function to find the longest path between any two vertices in
the graph.
Example:
Input:
graph = [[1,2],[2,3],[3,4],[4,5],[5,6],[7,6]]
Output:
6

 */

import java.util.*;
public class prob_1{
    private static int findLongestPath(List<List<Integer>> graph,int source,int destination){
        Map<Integer, Integer> longestPaths = new HashMap<>();
        longestPaths.put(source,0);
        Queue<Integer> queue=new LinkedList<>(); //to store the vertices that have not been visited yet
        queue.add(source);
        while(!queue.isEmpty()){
            int currentVertex=queue.poll();
            for (int neighbor:graph.get(currentVertex)) {
                if(!longestPaths.containsKey(neighbor)){ //if the neighbor has not been visited yet
                    //find the length of the longest path from the source vertex to the neighbor
                    int longestPathToNeighbor=longestPaths.get(currentVertex)+1;
                    //update the map with the length of the longest path from the source vertex to the neighbor
                    longestPaths.put(neighbor, longestPathToNeighbor);
                    queue.add(neighbor);
                }
            }
        }
        return longestPaths.get(destination);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(Systme.in);
        int v=sc.nextInt();
        List<List<Integer>> alist=new ArrayList<>();
        for(int i=0;i<v;i++){
            alist.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++){
            String[] adjv=sc.nextLine().split(" ");
            for(String s:adjv.get(i)){
                int av=Integer.parseInt(s);
                alist.get(i).add(av);
            }
        }
        int src=sc.nextInt();
        int dest=sc.nextInt();
        int longestPath=findLongestPath(alist,src,dest);
        System.out.println(longestPath);
    }
}
