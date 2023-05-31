/*
Question 2:
You are given an integer array coins representing coins of different denominations and an integer amount
representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made
up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1
*/
import java.util.*;
class prob_2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] coins=new int[n];
        for(int i=0;i<n;i++) coins[i]=sc.nextInt();
        int amount=sc.nextInt();
        int minCoins=coinChange(coins,amount);
        System.out.println(minCoins);
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int coin:coins) {
            for (int i=coin; i<=amount;i++){
                //the below line means that we update the values by taking minimum 
                //of current and value and dp[i-coin]+1 that represents the fewest number of coins needed to make 
                //up the current amount by either including the current coin or excluding it
                dp[i]=Math.min(dp[i], dp[i-coin]+1);
            }
        }
        if(dp[amount]>amount) return -1; //this means the amount cannot be made from coins
        return dp[amount];
    }
}
