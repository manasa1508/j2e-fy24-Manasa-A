/*
Question 6: Single Number
Given an array of integers, every element appears thrice except for one, which occurs once.
Find that element that does not appear thrice.
NOTE: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
Problem Constraints
2 <= A <= 5*10
6
0 <= A <= INTMAX
Input Format
First and only argument of input contains an integer array A.
Output Format
Return a single integer.
Example Input
Input 1:
 A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2:
 A = [0, 0, 0, 1]
Example Output
Output 1:
4
Output 2:
1
Example Explanation
Explanation 1:
4 occurs exactly once in Input 1.
1 occurs exactly once in Input 2.*/
import java.util.*;
class prob_6{
    public static int singleNum(int[] nums){
        int ones=0, twos=0;
        for(int i:nums){
            //to clear the bits trhat have appeared twice
            //we update ones by XORing it with current num and do a bitwise AND eith the complement of twos
            ones=(ones^i) & ~twos;
            //we do the same for twos
            twos=(twos^i) & ~ones;

        }
        return ones;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        int[] nums=new int[input.length];
        for(int i=0;i<input.length;i++){
            nums[i]=Integer.parseInt(input[i]);
        }
        System.out.println(singleNum(nums));
    }
}