/*
 * Given a string s, partition s such that every string of the partition is a palindrome. Return all possible palindrome partitioning
of s.
Example 1:
Input: s = "bcc"
Output: [["b", "c", "c"], ["b", "cc"]]
Example 2:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.
 */

import java.util.*;
public class prob_8{
    public static List<List<String>> partition(String s){
        List<List<String>> result=new ArrayList<>();
        List<String> current=new ArrayList<>();
        helper(s,0,current,result);
        return result;
    } 
    public static void helper(String s,int start,List<String> current,List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(current));
            return;
         }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                /*if a substring start to i is a palindrome, it adds the current partition to the list and 
                recursively does the same on the remaining string and thenm removes the substring from the curr position
                */
                String substring=s.substring(start,i+1);
                current.add(substring);
                helper(s,i+1,current,result);
                current.remove(current.size()-1);
            }
        }
    } 
    public static boolean isPalindrome(String s,int start,int end) {
        while(start < end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    } 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        List<List<String>> partitions=partition(s);
        System.out.println(partitions);
    }
}
 