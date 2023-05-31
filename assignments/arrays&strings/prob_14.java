import java.util.*;
class prob_14{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        int res=maxConsecutiveOnes(nums);
        System.out.println(res);
    }
    public static int maxConsecutiveOnes(int[] nums){
        int i=0, count=0, res=Integer.MIN_VALUE;
        while(i<nums.length){
            if(nums[i]==1) count++; //count the number of consecutive ones
            else count=0; //if ones are not consecutive, set the count to 0
            res=Math.max(res,count); //track the maximum of count
            i++;
        }
        return res;
    }
}