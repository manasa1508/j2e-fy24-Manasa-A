/*
PROBLEM 5. GIVEN A SORTED DECK OF CARDS NUMBERED 1 TO N.
1) We pick up 1 card and put it on the back of the deck.
2) Now, we pick up another card, it turns out to be card number 1, we put it outside the deck.
3) Now we pick up 2 cards and put it on the back of the deck.
4) Now, we pick up another card and it turns out to be card numbered 2, we put it outside the deck. ...
We perform this step until the last card.
If such an arrangement of decks is possible, output the arrangement, if it is not possible for a particular value of N then output
-1.
Example 1:
Input:
N = 4Output: 2 1 4 3Explanation:
We initially have [2 1 4 3]
In Step1, we move the first card to the end.
Deck now is: [1 4 3 2]
In Step2, we get 1. Hence we remove it. Deck
now is: [4 3 2]
In Step3, we move the 2 front cards ony by one 
to the end  ([4 3 2] -> [3 2 4] -> [2 4 3]).
Deck now is: [2 4 3]
In Step4, we get 2. Hence we remove it. Deck
now is: [4 3]
In Step5, the following sequence follows:
[4 3] -> [3 4] -> [4 3] -> [3 4]. Deck now
is: [3 4]
In Step6, we get 3. Hence we remove it. Deck
now is: [4] Finally, we're left with a single
card and thus, we stop. 
*/
import java.util.*;
class prob_5{
    public static ArrayList<Integer> cardArrangement(int N){
       int n=N;
       ArrayList<Integer> res = new ArrayList<Integer>();
       int[] arr = new int[1001];
       Queue<Integer> q = new LinkedList<>();
       for(int i=1;i<=n;i++){
           q.add(i);
       }
       int i=1;
       while(!q.isEmpty()){
           int j=0;
           while(j<i){
               int x=q.peek();
               q.poll();
               q.add(x);
               j++;
           }
           int x = q.peek();
           if(arr[x] != 0){
               res.add(-1);
               return res;
           }
           arr[x] = i;
           q.poll();
           i++;
       }
       for(i=1; i<=n; i++)
           res.add(arr[i]);
       return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> res=cardArrangement(n);
        System.out.println(res);
    }
}