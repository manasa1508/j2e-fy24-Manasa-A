/*
Given a list of airline tickets represented as pairs of origin and destination airports, implement a function to
reconstruct the itinerary in order, assuming that the itinerary starts from "JFK".
Example:
Input:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output:
["JFK", "MUC", "LHR", "SFO", "SJC"]*/
import java.util.*;
class prob_13{
    static List<String>  res= new ArrayList<>();
    public static List findItinerary(List<List<String>> tickets){
    HashMap<String,PriorityQueue<String>> map=new HashMap<>();
    for(int i=0;i<tickets.size();i++){
        String to = tickets.get(i).get(0);
        String from = tickets.get(i).get(1);
        if(!map.containsKey(to)){
            map.put(to,new PriorityQueue<>());
        }
        map.get(to).add(from);
    }
    dfs(map,"JFK");
    Collections.reverse(res);
    return res;
}
    public static void dfs(HashMap<String,PriorityQueue<String>> map,String source){
        PriorityQueue<String> temp = map.get(source);
        if(temp != null){
            while(!temp.isEmpty()){
                dfs(map,temp.poll());
            }
        }
        res.add(source);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<List<String>> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            String[] str=sc.nextLine().split(" ");
            l.get(i).add(str[0]);
            l.get(i).add(str[1]);
        }
        List<String> res=findItinerary(l);
        System.out.println(res);
    }
}