import java.util.*;
class prob_12{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] nums1=new int[m];
        int[] nums2=new int[n];
        for(int i=0;i<m;i++) nums1[i]=sc.nextInt();
        for(int i=0;i<n;i++) nums2[i]=sc.nextInt();
        double medianOfSortedArrays=median(nums1,nums2);
        System.out.println(medianOfSortedArrays);
    }
    //using extra space
    public static double median(int[] nums1, int[] nums2){
        int m=nums1.length;
        int n=nums2.length;
        int[] arr=new int[m+n];
        int i=0,j=0,k=0;
        while(i<=m && j<=n){ 
            if(nums1[i]<nums2[j]){
                arr[k++]=nums1[i++];
            }
            else{
                arr[k++]=nums2[j++];
            }
            if(i==m){
                while(j<n){
                    arr[k++]=nums2[j++];
                }
                break;
            }
            else if(j==n){
                while(i<m){
                    arr[k++]=nums1[i++];
                }
                break;
            }
        }
        if((m+n)%2==0) return (float)(arr[(m+n)/2-1] + arr[(m+n)/2])/2;
        else return arr[(m+n)/2];
    }
    //using no extra space
    public static int medianConstantSpace(int[] nums1, int[] nums2){
        //(refer ipad)
    }
}