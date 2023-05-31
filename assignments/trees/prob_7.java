/*
 * 0/1 Knapsack Problem: We are given N items where each item has some weight and profit associated with it. We are also
given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. The target is to put the items into the bag such that
the sum of profits associated with them is the maximum possible.
The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of
an item into the bag].
Example 1:
Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we sele
Example 2:
Input: N = 3, W = 50, profit[] = {60, 100, 120}, weight[] = {10, 20, 30}
Output: 220
Constraints:
1 <= N <= 10
1 <= W <= 50

 */

import java.util.*;
public class prob_7{
    public static int knapsack(int[] weight,int[] profit,int capacity,int n){
        if(n==0 || capacity==0) return 0;
        if(weight[n-1]>capacity){
            return knapsack(weight,profit,capacity,n-1);
        }
        else{
            /*
              we either include the current item in the knapsack or exclude it. 
              If the weight of the current item is greater than the remaining capacity, 
              we can only exclude it.Otherwise, we calculate the maximum profit by either 
              including the item and reducing the capacity or excluding the item and keeping the
              capacity the saem.The result is the maximum of these two choices.
             */
            int include=profit[n-1]+knapsack(weight,profit,capacity-weight[n-1],n-1);
            int exclude=knapsack(weight,profit,capacity,n-1);
            return Math.max(include,exclude);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] weight=new int[n];
        int w=sc.nextInt();
        int[] profit=new int[n];
        for(int i=0;i<n;i++) profit[i]=sc.nextInt();
        for(int i=0;i<n;i++) weight[i]=sc.nextInt();
        int maxProfit=knapsack(weight, profit,w,n);
        System.out.println(maxProfit);
    }
}
