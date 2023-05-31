/*
2. Implement a function to find the minimum number of swaps required to sort an array using graph theory.
Example:
Input:
arr = [5,3,8,6,7]
Output:
2
*/
import java.util.*;
import java.io.*;
public class prob_2{
  public static int minSwaps(int[] arr1){
    int n=arr1.length;
    Pair[]arr=new Pair[n];
    for(int i=0;i<n;i++){
      arr[i]=new Pair(arr1[i], i);
    }
    Arrays.sort(arr);
    int ans=0;
    boolean[] vis=new boolean[n];
    for(int i=0;i<n;i++){
      if(vis[i]==true || arr[i].idx==i){
        continue;
      }
      int clen=0;
      int j=i;
      while(vis[j]==false){
        vis[j]=true;
        clen++;
        j=arr[j].idx;
      }
      ans+=(clen-1);
    }
    return ans;
  }
  public static class Pair implements Comparable< Pair> {
    int val;
    int idx;
    Pair(int val,int idx){
      this.val=val;
      this.idx=idx;
    }
    @Override
    public int compareTo(Pair o){
      return this.val-o.val;
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner sc=new Scanner(System.in);
    //int n=sc.nextInt();
    String[] st=sc.nextLine().split(" ");
    int[] arr=new int[st.length];
    for (int i=0;i<st.length;i++){
      arr[i]=Integer.parseInt(st[i]);
    }
    System.out.println(minSwaps(arr));
  }
}