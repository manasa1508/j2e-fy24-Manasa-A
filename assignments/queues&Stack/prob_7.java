/*
PROBLEM 7. GIVEN AN ARRAY, FIND THE NEXT GREATER ELEMENT (NGE) FOR EVERY ELEMENT IN THE ARRAY. THE
NEXT GREATER ELEMENT FOR AN ELEMENT X IS THE FIRST GREATER ELEMENT ON THE RIGHT SIDE OF X IN THE
ARRAY. IF THERE IS NO GREATER ELEMENT ON THE RIGHT SIDE, THEN THE OUTPUT FOR THAT ELEMENT SHOULD
BE -1.
Example input: [4, 5, 2, 25]
Expected output: [5, 25, 25, -1]
Example input: [13, 7, 6, 12]
Expected output: [-1, 12, 12, -1]
Expected Time Complexity: O(n), where n is the length of the input array.
*/
import java.util.*;
class prob_7{
    public static int[] nextLargerElement(int[] arr, int n){ 
        int[] arr1=new int[n];
        Stack<Integer> stack=new Stack<Integer>();
        //arr1[0]=-1;
        int k=0;
        for(int i=n-1;i>=0;i--){
                while(!stack.isEmpty() && arr[i]>=stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()) arr1[i]=-1;
                else arr1[i]=stack.peek();
                stack.push(arr[i]);
        }
        return arr1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int[] res=nextLargerElement(arr,n);
        for(int i=0;i<n;i++) System.out.print(res[i]+" ");
    }
}