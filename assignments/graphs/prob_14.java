/*
Implement a function to find the minimum number of swaps required to sort an array of integers in nondecreasing order.
Example:
Input:
nums = [4,3,1,2]
Output:
2

*/
import java.util.*;
class prob_14{
    public static int minSwaps(int arr[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        int copy[]=new int[n];
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
            copy[i]=arr[i];
        }
        Arrays.sort(copy);
        int count = 0;
        for(int i=0;i<n;i++){
            if(copy[i]!=arr[i]){
                count++;
                int ind=map.get(copy[i]);
                int x=arr[i];
                swap(arr,ind,i);
                map.put(copy[i],i);
                map.put(x,ind);
            }
        }
        return count;
    }
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
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