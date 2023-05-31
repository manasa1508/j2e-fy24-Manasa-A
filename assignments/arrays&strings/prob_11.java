import java.util.*;
class prob_11{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        int res=peakElement(nums);
        System.out.println(res);
    }
    public static int peakElement(int[] nums){
        int max=nums[0];
        int index=0;
        for(int i=1;i<nums.length-1;i++){
            //keep track of the previous, current and next elements
            int prev=nums[i-1];
            int curr=nums[i];
            int next=nums[i+1];
            if(curr>prev && curr>next && curr>max){
                //if we fin our peak, we store the index if it and keep track of the max peak
                index=i;
                max=curr;
            }
        }
        if(nums[nums.length-1]>max) return nums.length-1;
        return index;
    }
}