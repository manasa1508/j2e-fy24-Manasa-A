/*
You are given two linked lists: list1 and list2 of sizes n and m respectively.
Remove list1's nodes from the a
th node to the b
th node, and put list2 in their place.
The blue edges and nodes in the following figure indicate the result:
Build the result list and return its head

Example 1:
Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [0,1,2,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The

Example 2:
Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,100000
Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
Explanation: The blue edges and nodes in the above figure indicate the result.

Constraints:
3 <= list1.length <= 104
1 <= a <= b < list1.length - 1
1 <= list2.length <= 104
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
    Node* mergeBetweenNodes(Node* l1, Node* l2,int start,int end){
        Node* n1=l1;
        Node* n2=l2;
        //n1 is moved start-1 steps to reach the node just before the starting index
        for(int i=0;i<start-1;i++){
            n1=n1->next;
        }
        //n2 is moved 'end' steps to reach the node at the ending index in l2
        for(int i=0;i<end;i++){
            n2=n2->next;
        }
        n1->next=l2;
        //temp is set as head of l2
        Node* temp=l2;
        //temp is traversed to end of l2
        while(temp->next!=NULL){
            temp=temp->next;
        }
        //the next pointer of temp is pointed to next node in l2 liking the remaining part of l1
        temp->next=n2->next;
        return l1;
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
    List ll1;
    int n1,n2,no;
    cin>>n1;
    for(int i=0;i<n1;i++){
        cin>>no;
        ll1.append(no);
    }
    List ll2;
    cin>>n2;
    for(int i=0;i<n2;i++){
        cin>>no;
        ll2.append(no);
    }
    int start;
    int end;
    cin>>start>>end;
    List mergedList;
    Node* head=mergedList.mergeBetweenNodes(ll1.hptr,ll2.hptr,start,end);
    mergedList.hptr=head;
    mergedList.display();
}