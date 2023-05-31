/*Question 9:
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, return the Hamming distance between them.
Example 1:
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:
Input: x = 3, y = 1
Output: 1
*/
import java.util.*;
class prob_9{
    public static int hammDist(int x,int y){
        int xor=x^y;
        //xor of same number becomes 0 and xor of anumber with 0 gives the numner itself
        int dist=0;
        //counting the number of ones in the xor
        while(xor!=0){
            dist++;
            xor &=xor-1; //clearing the least significant one
        }
        return dist;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        System.out.println(hammDist(x,y));
    }
}