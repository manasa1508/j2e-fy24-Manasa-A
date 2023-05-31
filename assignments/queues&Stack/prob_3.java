/*PROBLEM 3. GIVEN AN ARRAY ARR[] OF SIZE N AND AN INTEGER K. FIND THE MAXIMUM FOR EACH AND EVERY
CONTIGUOUS SUBARRAY OF SIZE K.
Example 1:
Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output:
3 3 4 5 5 5 6
Explanation:
1st contiguous subarray = {1 2 3} Max = 3
2nd contiguous subarray = {2 3 1} Max = 3
3rd contiguous subarray = {3 1 4} Max = 4
4th contiguous subarray = {1 4 5} Max = 5
5th contiguous subarray = {4 5 2} Max = 5
6th contiguous subarray = {5 2 3} Max = 5
7th contiguous subarray = {2 3 6} Max = 6
*/
import java.util.*;
class prob_3{
    public static List<Integer> maxOfSubarrs(int[] arr,int n,int k){
        List<Integer> res=new ArrayList<>();
        Deque<Integer> deque=new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && arr[i]>=arr[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for(int i=k;i<n;i++){
            res.add(arr[deque.peekFirst()]);
            while(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[i]>=arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        res.add(arr[deque.peekFirst()]);
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        List<Integer> maxs=maxOfSubarrs(arr,n,k);
        System.out.println(maxs);
    }
}