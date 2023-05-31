/*

Question 5:
Given an integer array input = nums of unique elements, return all possible
Subsets (the power set)
The solution set must not contain duplicate subsets. Return the solution in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
*/
import java.util.*;
public class prob_5{
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> subsets = new ArrayList<>();
        helper(subsets,new ArrayList<>(),nums,0);
        return subsets;
    }
    public static void helper(List<List<Integer>> subsets, List<Integer> curr,int[] nums,int start){
        subsets.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            curr.add(nums[i]);
            helper(subsets,curr,nums,i+1);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}
