import java.util.*;
class prob_1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] candies=new int[n];
        for(int i=0;i<n;i++){
            candies[i]=sc.nextInt();
        }
        int extraCandies=sc.nextInt();
        List<Boolean> maxCandiesKidList=maxNumOfCandies(candies,extraCandies);
        System.out.println(maxCandiesKidList);
    }
    public static List<Boolean> maxNumOfCandies(int[] candies,int extraCandies) {
        int max=0;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>max){
                max=candies[i];
            }
        }
        List<Boolean> res=new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;
    }
}
