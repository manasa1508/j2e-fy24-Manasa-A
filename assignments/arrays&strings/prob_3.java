import java.util.*;
class prob_3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int target=sc.nextInt();
        int res=closestSum(arr,target);
        System.out.println(res);
    }
    public static int closestSum(int[] arr,int target){
        int diff=Integer.MAX_VALUE;
        int res=0;
        int sum=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            int left=i+1;
            int right=arr.length-1;
            while(left<right){
                sum=arr[left]+arr[right]+arr[i];
                if(sum==target) return sum;
                else{
                    if(sum<target) left++;
                    else right--;
                }
                if(diff>Math.abs(sum-target)){
                    diff=Math.abs(sum-target);
                    res=sum;
                }
            }
        }
        return res;
    }
}