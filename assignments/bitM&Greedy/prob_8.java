/*
Question 8: Single Integer II
Problem Description
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Problem Constraints
1 <= |A| <= 2000000
0 <= A[i] <= INTMAX
Input Format
The first and only argument of input contains an integer array A.
Output Format
Return a single integer denoting the single element.
Example Input
Input 1:
 A = [1, 2, 2, 3, 1]
Input 2:
 A = [1, 2, 2]
Example Output
Output 1:
3
Output 2:
1
Example Explanation
Explanation 1:
3 occurs once.
Explanation 2:
1 occurs once.*/
import java.util.*;
class prob_8{
    public static int singleNum2(int[] nums){
        int res=0;
        //xor of same number becomes 0 and xor of anumber with 0 gives the numner itself
        for(int i:nums){
            res^=i;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        int[] nums=new int[input.length];
        for(int i=0;i<input.length;i++){
            nums[i]=Integer.parseInt(input[i]);
        }
        System.out.println(singleNum2(nums));
    }
}