import java.util.*;
class prob_8{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        //int n=sc.nextInt();
        int[][] intervals=new int[m][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<2;j++){
                intervals[i][j]=sc.nextInt();
            }
        }
        int[][] res=merge(intervals);
        List<List<Integer>> resList=new ArrayList<>();
        for(int[] row:res){
            List<Integer> list=new ArrayList<>();
            for(int val:row) list.add(val);
            resList.add(list);
        }
        System.out.println(resList);
    }
    public static int[][] merge(int[][] intervals){
        List<int[]> merged=new ArrayList<>();
        if(intervals.length<=1 || intervals==null)
            return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0])); //sort the intervals based on the start time
        int[] currInterval=intervals[0];
        for(int i=1;i<intervals.length;i++){
            int[] interval=intervals[i];
            if(interval[0]<=currInterval[1]){ //for overlapping intervals, update the end time
                currInterval[1]=Math.max(currInterval[1],interval[1]);
            }
            else{ //for non-overlapping intervals, add the merged interval to the result
                merged.add(currInterval);
                currInterval=interval;
            }
        }
        merged.add(currInterval); //add the last merged interval
        return merged.toArray(new int[merged.size()][]);
    }
}