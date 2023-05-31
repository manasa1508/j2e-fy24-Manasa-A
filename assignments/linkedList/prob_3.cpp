/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the
values in the list's nodes (i.e., only nodes themselves may be changed.)
Example 1:
Input: head = [1,2,3,4] Output: [2,1,4,3]
Example 2:
Input: head = [] Output: []
Example 3:
Input: head = [1] Output: [1]

Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
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
class List{
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
    Node* swapTwoNodes(Node* head){
        if(head==NULL || head->next==NULL) return head; //if the list is empty or has one node, return the same
        Node* temp;
        temp=head->next;
        //recursively swap the links
        head->next=swapTwoNodes(head->next->next);
        //reverse the link of every second node
        temp->next=head;
        return temp;
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
    List ll;
    int n,no;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>no;
        ll.append(no);
    }
    List swappedList;
    swappedList.hptr=ll.swapTwoNodes(ll.hptr);
    swappedList.display();
}