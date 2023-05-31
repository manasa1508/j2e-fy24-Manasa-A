/*
 IMPLEMENT A QUEUE USING 2 STACKS S1 AND S2 .
A Query Q is of 2 Types
(i) 1 x (a query of this type means pushing 'x' into the queue)
(ii) 2 (a query of this type means to pop element from queue and print the poped element)
Example 1:
Input:5
1 2 1 3 2 1 4 2
Output: 2 3
Explanation: In the first testcase
1 2 the queue will be {2}
1 3 the queue will be {2 3}
2   poped element will be 2 the queue
    will be {3}
1 4 the queue will be {3 4}
2   poped element will be 3.*/

import java.util.*;
class prob_2{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    void enqueue(int x){
        s1.push(x);
    }
    int dequeue(){
        if(s1.isEmpty() && s2.isEmpty()){
            return -1;
        }
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int queries=sc.nextInt();
        prob_2 q=new prob_2();
        while(queries>0){
            int operation=sc.nextInt();
            if(operation==1){
                int value=sc.nextInt();
                q.enqueue(value);
            }
            else if(operation==2){
                int res=q.dequeue();
                System.out.print(res+" ");
            }
            queries--;
        }
    }
}
