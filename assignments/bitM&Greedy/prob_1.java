/*
Question 1:
You are given N fruits.
The weight of the fruits is represented by an array A.
All those fruits which have the same weight can be sliced in one step.
Task:
Your task is to determine the number of steps to slice all the fruits.
Example 1:
Input: N = 4, A = [3, 6, 7, 7]
Output: 3
Example 2:
Input: N = 6, A = [20, 40, 30, 50, 40, 20]
Output: 4

*/
import java.util.*;
public class prob_1{
    public static int countSteps(int n,int[] arr) {
        Map<Integer,Integer> freqMap=new HashMap<>();
        int steps=0;
        for(int i=0;i<n;i++){
            int weight=arr[i];
            freqMap.put(weight,freqMap.getOrDefault(weight,0)+1);
        }
        for (int freq:freqMap.values()){
            steps+=(freq+1)/2; //round up to the nearest integer
        }
        return steps;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++) arr[i]=sc.nextInt();
        int steps=countSteps(n,arr);
        System.out.println(steps);
    }
}
