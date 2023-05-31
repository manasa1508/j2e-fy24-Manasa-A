import java.util.*;
class prob_6{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean[] vis=new boolean[n];
        Arrays.sort(arr);
        uniquePermutations(arr,vis,res,list);
        System.out.println(res);
    }
    public static void uniquePermutations(int[] nums,boolean[] vis,List<List<Integer>> res,List<Integer> list){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list)); //add new permutation to the result list when curr list reaches the length of array
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(vis[i]) continue; //skip to next iteration if element at index i is already visited
            if(i>0 && nums[i-1]==nums[i] && !vis[i-1]) continue; //skip duplicates
            vis[i]=true; //mark the element at i as visited
            list.add(nums[i]);
            uniquePermutations(nums,vis,res,list); //call the function recursively to generate unique permutations
            vis[i]=false; // Backtracks and marks the element as not visited
            list.remove(list.size()-1); //backtracks and removes the last added element from current permutation list 

        }
    }        
}