/*
 Implement a function to find the number of paths in a directed acyclic graph (DAG) from the source node to the
destination node.
Example:
Input:
graph = [[0,1],[0,2],[1,2],[1,3],[2,3]]
source = 0, destination = 3
Output:
2
*/
import java.util.*;
class prob_9{
    private int v;
    private ArrayList<Integer>[] adjList;
    public prob_9(int vertices){
        this.v = vertices;
        initAdjList();
    }
    private void initAdjList(){
        adjList = new ArrayList[v];
        for(int i = 0; i < v; i++){
            adjList[i] = new ArrayList<>();
        }
    }
    public void addEdge(int u, int v){
        adjList[u].add(v);
    }
    public void printAllPaths(int s, int d){
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(s);
        printAllPathsUtil(s, d, isVisited, pathList);
    }
    private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList){
        if (u.equals(d)) {
            System.out.println(localPathList);
            return;
        }
        isVisited[u] = true;
        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);
                localPathList.remove(i);
            }
        }
        isVisited[u] = false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        prob_9 graph=new prob_9(v);
        for(int i=0;i<e;i++){
            String[] str=sc.nextLine().split(" ");
            graph.addEdge(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
        }
        int src=sc.nextInt();
        int dest=sc.nextInt();
        graph.printAllPaths(src,dest);
    }
}