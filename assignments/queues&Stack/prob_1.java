/*
IMPLEMENT A STACK USING TWO QUEUES Q1 AND Q2.
Example 1:
Input:
push(2)
push(3)
pop()
push(4)
pop()
Output: 3 4
Explanation:
push(2) the stack will be {2}
push(3) the stack will be {2 3}
pop()   poped element will be 3 the
        stack will be {2}
push(4) the stack will be {2 4}
pop()   poped element will be 4  
Example 2:
Input:
push(2)
pop()
pop()
push(3)
Output: 2 -1
Your Task:
Expected Time Complexity: O(1) for push() and O(N) for pop() (or vice-versa).
Expected Auxiliary Space: O(1) for both push() and pop().
Constraints:
1 <= Number of queries <= 100
1 <= values of the stack <= 100
*/

import java.util.*;
public class prob_1{
    public static Queue<Integer> q1;
    public static Queue<Integer> q2;
    public prob_1(){
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    public void push(int x){
        q1.add(x);
    }
    public int pop(){
        if(q1.isEmpty()) return -1;
        while(q1.size()>1){
            q2.add(q1.poll());
        }
        int popEle=q1.poll();
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return popEle;
    }
    public static void main(String[] args){
        prob_1 stack=new prob_1();
        Scanner sc=new Scanner(System.in);
        int queries=sc.nextInt();
        while(queries>0){
            String operation=sc.next();
            if(operation.equals("push")){
                int value=sc.nextInt();
                stack.push(value);
            }
            else if(operation.equals("pop")){
                stack.pop();
            }
            queries--;
        }
        while(!stack.q1.isEmpty()){
            int ele=stack.q1.poll();
            System.out.print(ele+" ");
        }
    }
}
