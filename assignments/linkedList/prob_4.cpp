/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list
sortedas well.
Example 1:
Input: head = [1,1,2]Output: [1,2]
Example 2:
Input: head = [1,1,2,3,3]Output: [1,2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

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
    Node* deleteDuplicates(Node* head){
        if(head==NULL || head->next==NULL) return head;
        Node* curr=head;
        //traverse though the list
        while(curr->next!=NULL && curr!=NULL){
            if(curr->data==curr->next->data){
                //when the current nodes data is equal to the next nodes data, we change the link so that the duplicates are skipped
                curr->next=curr->next->next;    
            }
            else curr=curr->next;
        }
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