/*
Question 7: Min XOR value
Problem Description
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the
minimum XOR value.
Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 10
9
Input Format
First and only argument of input contains an integer array A.
Output Format
Return a single integer denoting minimum xor value.
Example Input
Input 1:
 A = [0, 2, 5, 7]
Input 2:
 A = [0, 4, 7, 9]
Example Output
Output 1:
2
Output 2:
3
Example Explanation
Explanation 1:
0 xor 2 = 2*/
import java.util.*;
class prob_7{
    public static int minXORval(int[] nums){
        int min_xor=Integer.MAX_VALUE;
        Arrays.sort(nums);
        //find the minimum XOR value by comparing adjacent elements
        for(int i=0;i<nums.length-1;i++){
            int xor=nums[i] ^ nums[i+1];
            min_xor=Math.min(min_xor,xor);
        }
        return min_xor;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        int[] nums=new int[input.length];
        for(int i=0;i<input.length;i++){
            nums[i]=Integer.parseInt(input[i]);
        }
        System.out.println(minXORval(nums));
    }
}