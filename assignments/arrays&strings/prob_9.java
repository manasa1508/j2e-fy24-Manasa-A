import java.util.*;
class prob_9{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        sortObjectsBasedOnColor(nums);
        List<Integer> res=new ArrayList<>();
        for(int i:nums) res.add(i);
        System.out.println(res);
    }
    public static void sortObjectsBasedOnColor(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){ //put the frequencies of all objects as values in a map
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int index=0;
        for(int i=0;i<=2;i++){
            int count=hm.get(i);
            for(int j=0;j<count;j++){
                //store the sorted objects in the array based on the frequency of the same
                nums[index]=i;
                index++;
            }
        }
    }
}