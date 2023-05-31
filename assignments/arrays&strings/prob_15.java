import java.util.*;
class prob_15{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        int k=sc.nextInt();
        int res=kthLargestInteger(nums,k);
        System.out.println(res);
    }
    public static int kthLargestInteger(int[] nums, int k){
        int res=0;
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}