/*PROBLEM 9. WRITE A CLASS STOCKSPANNER WHICH COLLECTS DAILY PRICE QUOTES FOR SOME STOCK, AND
RETURNS THE SPAN OF THAT STOCK'S PRICE FOR THE CURRENT DAY. THE SPAN OF THE STOCK'S PRICE TODAY IS
DEFINED AS THE MAXIMUM NUMBER OF CONSECUTIVE DAYS (STARTING FROM TODAY AND GOING BACKWARDS)
FOR WHICH THE PRICE OF THE STOCK WAS LESS THAN OR EQUAL TO TODAY'S PRICE.
Example input:
stockSpanner = StockSpanner()
stockSpanner.next(100) # returns 1
stockSpanner.next(80) # returns 1
stockSpanner.next(60) # returns 1
stockSpanner.next(70) # returns 2
stockSpanner.next(75) # returns 4
stockSpanner.next(85) # returns 6
Expected Time Complexity: O(n), where n is the number of calls to the next() method.
*/
import java.util.*;
class prob_9{
    Stack<Node> st;
    class Node{
    int val;
    int del;
    public Node(int val,int del){
        this.val = val;
        this.del = del;
    }
    }
    public prob_9() {
        st = new Stack<>();
    }
    public int next(int price){
        int count=0;
    while(!st.isEmpty() && st.peek().val<=price){
         count+=st.peek().del;
         st.pop();
    }
    count++;
    st.push(new Node(price,count));
    return count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //int price=sc.nextInt();
        prob_9 obj=new prob_9();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));

    }
}