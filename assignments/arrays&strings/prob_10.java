import java.util.*;
class prob_10{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] prices=new int[n];
        for(int i=0;i<n;i++) prices[i]=sc.nextInt();
        int res=maxProfit(prices);
        System.out.println(res);
    }
    public static int maxProfit(int[] prices){
        if(prices.length<=1 || prices==null) return 0; //to find profit, we need prices for atleast 2 days
        int totalProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]<prices[i]){ //check if theres profit from previous days price
                totalProfit=totalProfit+prices[i]-prices[i-1]; //if so, buy on prev day and sell on curr day and add all such profits
            }
        }
        return totalProfit;
    }
}