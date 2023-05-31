/*
 * 
 * The head of a singly linked-list is given. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
The values in the list's nodes may not be modified, only nodes themselves may be changed.
Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 */
import java.util.*;
class Node{
    int val;
    Node next;

    Node(int val){
        this.val=val;
    }
}
public class prob_3{
    public static void reorderList(Node head){
        if(head==null || head.next==null) return;
        //find the middle of the list
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse the second half of the list
        Node prev=null;
        Node curr=slow.next;
        slow.next=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //merge the two halves of the list
        Node first=head;
        Node second=prev;
        while(second!=null) {
            Node firstNext=first.next;
            Node secondNext=second.next;
            first.next=second;
            second.next=firstNext;
            first=firstNext;
            second=secondNext;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //create the linked list
        int n=sc.nextInt(); //length of array
        int[] values =new int[n];
        for(int i=0;i<n;i++) values[i]=sc.nextInt(); //array input
        Node dummy=new Node(0);
        Node curr=dummy;
        for(int val:values){
            curr.next=new Node(val);
            curr=curr.next;
        }
        Node head=dummy.next;
        reorderList(head);
        //print the reordered list
        Node node = head;
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
    }
}
