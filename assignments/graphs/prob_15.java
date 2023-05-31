/*
 Implement a function to find the number of ways to decode a message encoded as a string of digits, where each
digit can be mapped to a character in the alphabet (1 → 'A', 2 → 'B', ..., 26 → 'Z').
Example:
Input:
s = "226"
Output:
3*/
import java.util.*;
class prob_15{
    public static int numDecodings(String s){
        int [] dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return DFS(s,0,dp);
    }
    public static int DFS(String s,int index,int [] dp){
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        if(dp[index]!=-1) return dp[index];
        int count=DFS(s, index + 1,dp);
        if(index<s.length()-1 && (s.charAt(index)=='1' || s.charAt(index)=='2' && s.charAt(index+1)<'7')){
            count+=DFS(s,index+2,dp);
        }
        dp[index]=count;
        return dp[index];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int res=numDecodings(str);
        System.out.println(res);
    }
}