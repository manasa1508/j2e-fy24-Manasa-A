/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
original list. Return the linked list sorted as well.
Example 1:
Input: head = [1,2,3,3,4,4,5]Output: [1,2,5]
Example 2:
Input: head = [1,1,1,2,3]Output: [2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.*/


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
    Node* deleteDuplicates(Node* head){
        if(head==NULL || head->next==NULL) return head;
        Node* temp=new Node(0);
        temp->next=head;
        Node* curr=head;
        Node* prev=temp;
        while(curr!=NULL){
            if(curr->next!=NULL && curr->data==curr->next->data){
                while(curr->next!=NULL && curr->data==curr->next->data){ //skip all duplicates
                    curr=curr->next;
                }
                prev->next=curr->next; //establish link between previous non-duplicate number to the next one
            }
            else{
                prev=curr;
            }
            //traverse to the next node
            curr=curr->next;
        }
        return temp->next;
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
    List noDuplicates;
    noDuplicates.hptr=ll.deleteDuplicates(ll.hptr);
    noDuplicates.display();
}