/*
 Print all possible strings of length k that can be formed from a set of n characters.
Example 1:
Input:
set[] = {'a', 'b'}, k = 3
Output:
aaa
aab
aba
abb
baa
bab
bba
bbb
 */

import java.util.*;
public class prob_1{
    public static void printStrings(char[] set,int k){
        int n=set.length;
        helper(set,"",n,k);
    }
    public static void helper(char[] set,String prefix,int n,int k){
        //It starts with an empty prefix and recursively appends each character
        // from the set to the prefix until the desired length k is reached
        if(k==0){
            System.out.println(prefix);
            return;
        }
        for(int i=0;i<n;i++){
            String newPrefix=prefix+set[i];
            helper(set,newPrefix,n,k-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[] set=new char[n];
        for(int i=0;i<n;i++){
            set[i]=sc.next().charAt(0);
        }
        int k=sc.nextInt();
        printStrings(set, k);
    }
}
