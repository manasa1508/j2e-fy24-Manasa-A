/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4]
Example 2:
Input: list1 = [], list2 = [] Output: []
Example 3:
Input: list1 = [], list2 = [0] Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

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
    Node* mergeTwoSortedLists(Node* head1, Node* head2){
        //if any one of the list is null, we return the other list
        if(head1==NULL) return head2;
        if(head2==NULL) return head1;
        /*when head pointer value of first list is less than head pointer value of
        second head pointer, we recursively call the whole first list values and check
        the same for all values followed, and repeat the same for second list.
        */
        if(head1->data<=head2->data){
            head1->next=mergeTwoSortedLists(head1->next,head2);
            return head1;
        }
        else{
            head2->next=mergeTwoSortedLists(head1,head2->next);
            return head2;
        }
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
    //create a new list that will merge the two lists values in a sorted manner
    List mergedList;
    Node* head=mergedList.mergeTwoSortedLists(ll1.hptr,ll2.hptr);
    mergedList.hptr=head;
    mergedList.display();
}