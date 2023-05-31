import java.util.*;
class prob_2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] heights=new int[n];
        for(int i=0;i<n;i++) heights[i]=sc.nextInt();
        int maxAmt=maxWater(heights);
        System.out.println(maxAmt);
    }
    public static int maxWater(int[] heights){
        int maxAmt=0;
        int left=0;
        int right=heights.length-1;
        while(left<right){
            int width=right-left;
            maxAmt=Math.max(maxAmt, Math.max(heights[left],heights[right])*width);
            if(heights[left]<=heights[right]){
                left++;
            }
            else right--;
        }
        return maxAmt;
    }
}