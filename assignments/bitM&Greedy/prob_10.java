/*
Question 10: Reverse Bits
Problem Description
Reverse the bits of an 32 bit unsigned integer A.
Problem Constraints
0 <= A <= 2
32
Input Format
First and only argument of input contains an integer A.
Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.
Example Input
Input 1:
0
Input 2:
3
Example Output
Output 1:
0
Output 2:
3221225472
Example Explanation
Explanation 1:
        00000000000000000000000000000000
=>      00000000000000000000000000000000
Explanation 2:
        00000000000000000000000000000011    
=>      11000000000000000000000000000000
*/
import java.util.*;
class prob_10{
    public static long revBits(int x){
        long res=0;
        for(int i=0;i<32;i++){
            //shift the result to left by 1 bit
            res<<=1;
            //if least significant bit of x is 1, set the least sig bit of thr result
            if((x&1)==1){
                res|=1;
            }
            //shift x to right by 1 bit
            x>>=1;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        System.out.println(revBits(x));
    }
}