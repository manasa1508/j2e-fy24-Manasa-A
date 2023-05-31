/*
Question 3:
There are n boxes with different quantities of candies in each of them. The i-th box has a[i] candies inside. You also
have n friends that you want to give the candies to, so you decided to give each friend a box of candies. But, you
don't want any friends to get upset so you decided to eat some (possibly none) candies from each box so that all
boxes have the same quantity of candies in them.
Note that you may eat a different number of candies from different boxes and you cannot add candies to any of the
boxes.
What's the minimum total number of candies you have to eat to satisfy the requirements?
Example 1:
Input: n = 5, a = [1,2,3,4,5]
Output: 10
Example 2:
Input: n = 10, a = [1, 2, 3, 5, 1, 2, 7, 9, 13, 5]
Output: 38
*/
import java.util.*;
public class prob_3{
    public static int minCandiesEaten(int n,int[] a){
        Arrays.sort(a);
        int min=a[0];
        int candiesEaten=0;
        for(int i=0;i<n;i++){
            //minimum number of candies tht must be eaten from the current box 
            candiesEaten+=Math.max(0,a[i]-a[0]);
        }
        return candiesEaten;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int result=minCandiesEaten(n,arr);
        System.out.println(result);
    }
}
