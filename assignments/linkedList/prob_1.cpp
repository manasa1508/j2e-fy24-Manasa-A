/*
 Given the head of a linked list, remove the n
th node from the end of the list and return its head.
Example 1:
Input: head = [1,2,3,4,5], n = 2 Output: [1,2,3,5]
Example 2:
Input: head = [1], n = 1 Output: []
Example 3:
Input: head = [1,2], n = 1 Output: [1]
Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= s
*/
#include<iostream>
using namespace std;
class Node{
    public:
    int data;
    Node* next;
    Node(int val){
        data=val;
        next=NULL;
    }
    void display(){
        cout<<data<<" ";
    }

};
class SLL{
    public:
    Node* hptr=NULL;
    void append(int val){
        if(hptr==NULL){
            Node* nptr=new Node(val);
            hptr=nptr;

        }
        else{
            Node* temp=hptr;
            while(temp->next!=NULL){
                temp=temp->next;
            }
            Node* nptr=new Node(val);
            temp->next=nptr;
        }
    }
    Node* removeNthNodeFromEnd(Node* head, int n) {
        Node *fast=head,*slow=head;
        for(int i=0;i<n;i++){
            fast=fast->next;
        }
        if(!fast) return head->next; //when n is equal to length of linked list, then head will be the next node
        while(fast->next){
            fast=fast->next; 
            slow=slow->next;
            //slow and fast pointers are traversed until fast pointer reaches the end
        }
        //slow pointer points to node just before the node to be removed, so next pointer of slow is updated to skip the node to be removed
        slow->next = slow->next->next;
        return head;
    }
    void display(){
        Node* temp=hptr;
        while(temp!=NULL){
            temp->display();
            temp=temp->next;
        }
    }
};
int main(){
    SLL sll;
    int len,no,n;
    cin>>len;
    for(int i=0;i<len;i++){
        cin>>no;
        sll.append(no);
    }
    cin>>n; //input n, for which we will remove the nth node from the list
    Node* nodeToRemove=sll.removeNthNodeFromEnd(sll.hptr,n);
    sll.display();
}
