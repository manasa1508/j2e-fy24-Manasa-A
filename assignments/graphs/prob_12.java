/*
 Implement a function to find the minimum number of steps required to reach the end of an array of non-negative
integers, where each element of the array represents the maximum number of steps that can be taken forward from
that position.
Example:
Input:
nums = [2,3,1,1,4]
Output:
2
*/
import java.util.*;
class prob_12{
    public static int minJumps(int arr[],int l,int h){
        if(h==l) return 0;
        if(arr[l]==0) return Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=l+1;i<=h && i<=l+arr[l];i++){
            int jumps=minJumps(arr,i,h);
            if (jumps!=Integer.MAX_VALUE && jumps+1<min)
                min=jumps+1;
        }
        return min;
    }
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    //int n=sc.nextInt();
    String[] st=sc.nextLine().split(" ");
    int[] arr=new int[st.length];
    for (int i=0;i<st.length;i++){
      arr[i]=Integer.parseInt(st[i]);
    }
    System.out.println(minJumps(arr,0,arr.length-1));
  }
}