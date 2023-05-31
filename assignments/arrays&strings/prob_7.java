import java.util.*;
class prob_7{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        System.out.println(maxSubarraySum(nums));
    }
    public static int maxSubarraySum(int[] nums){
        int sum=0,maxi=Integer.MIN_VALUE;
        int i=0,j=0; //start and end indices of subarray
        while(j<nums.length){
            if(sum<0 && nums[j]>=sum){ 
                /*if sum is negetive or the current element is greater than or equal to sum, 
                starting a new subarray from the current element would get a higher sum, so 
                reset sum to 0 and update i to j
                */
                sum=0; 
                i=j;
            }
            //add the current elemetn to sum and update the maximum sum
            sum+=nums[j]; 
            maxi=Math.max(maxi,sum);
            j++;
        }
        return maxi;
    }
}