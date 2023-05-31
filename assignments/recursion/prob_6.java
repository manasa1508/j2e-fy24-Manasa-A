/*
 * Print sums of all subsets of a given set of size n.
Example 1:
Input: arr[] = {2, 3}
Output: 0 2 3 5
Example 2:
Input: arr[] = {2, 4, 5}
Output: 0 2 4 5 6 7 9 11
Constraints:
1 <= n <= 15

 */

import java.util.*;
class prob_6{
    public static void sumOfAllSubsets(int[] arr){
        List<Integer> subsets=new ArrayList<>();
        generateSubsets(arr,0,0,subsets);
        Collections.sort(subsets);
        for(int sum:subsets)
            System.out.print(sum+" ");
    }
    public static void generateSubsets(int[] arr,int index,int sum,List<Integer> subsets){
        if(index==arr.length){
            //when we reach the end of the array we add trhe current sum to the list
            subsets.add(sum);
            return;
        }
        //we either include the current element into the sum or not recursively
        generateSubsets(arr,index+1,sum+arr[index],subsets);
        generateSubsets(arr,index+1,sum,subsets);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        sumOfAllSubsets(arr);
    }
}
