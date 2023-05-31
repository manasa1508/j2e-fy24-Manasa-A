import java.util.*;
class prob_13{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] heights=new int[n];
        for(int i=0;i<n;i++) heights[i]=sc.nextInt();
        System.out.println(maxArea(heights));
    }
    public static int maxArea(int[] height){
        int maxarea=0;
        int left=0; 
        int right=height.length-1;
        while (left<right){
            int width=right-left;
            maxarea=Math.max(maxarea, Math.min(height[left], height[right])*width); //calculate the maximum area
            if(height[left]<=height[right]) left++;
            else right--;
        }
        return maxarea;
    }
}