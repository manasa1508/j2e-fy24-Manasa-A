/*
Design your implementation of the circular double-ended queue (deque).
Implement the MyCircularDeque class:
MyCircularDeque(int k) Initializes the deque with a maximum size of k.
boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false
otherwise.
boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false
otherwise.
boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or
falseotherwise.
boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or
falseotherwise.
int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
boolean isEmpty() Returns true if the deque is empty, or false otherwise.
boolean isFull() Returns true if the deque is full, or false otherwise.
Example 1:
Input
["MyCircularDeque", "insertLast", "insertLast", "insertFront",
"insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 2, true, true, true, 4]

Explanation
MyCircularDeque myCircularDeque = new MyCircularDeque(3);
myCircularDeque.insertLast(1);  // return True
myCircularDeque.insertLast(2);  // return True
myCircularDeque.insertFront(3); // return True
myCircularDeque.insertFront(4); // return False, the queue is full.
myCircularDeque.getRear();      // return 2
myCircularDeque.isFull();       // return True
myCircularDeque.deleteLast();   // return True
myCircularDeque.insertFront(4); // return True
myCircularDeque.getFront();     // return 4
Constraints:
1 <= k <= 1000
0 <= value <= 1000
At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront,
getRear, isEmpty, isFull.*/


#include <iostream>
using namespace std;
class Node{
public:
    int val;
    Node *next;
    Node *prev;
    Node(int Val){
        val=Val;
        next=NULL;
        prev=NULL;
    }
};

class circularDeque{
public:
    Node *front,*rear;
    int len,curr=0;
    circularDeque(int l){
        front=new Node(-1);
        rear=new Node(-1);
        front->next=rear;
        rear->prev=front;
        len=l;
    }
    bool insertFront(int value){
        if(isFull()) return false;
        curr++;
        Node *newNode=new Node(value);
        newNode->next=front->next;
        newNode->prev=front;
        newNode->next->prev=newNode;
        front->next=newNode;
        return true;
    }
    bool insertLast(int value){
        if(isFull()) return false;
        curr++;
        Node *node=new Node(value);
        node->prev=rear->prev;
        rear->prev->next=node;
        node->next=rear;
        rear->prev=node;
        return true;
    }
    bool deleteFront(){
        if(isEmpty()) return false;
        curr--;
        Node *temp=front->next;
        front->next=temp->next;
        temp->next->prev=front;
        delete temp;
        return true;
    }
    bool deleteLast(){
        if(isEmpty()) return false;
        curr--;
        Node *temp=rear->prev;
        rear->prev=temp->prev;
        temp->prev->next=rear;
        delete temp;
        return true;
    }
    int getFront(){
        if(isEmpty()) return -1;
        else return front->next->val;
    }
    int getRear(){
        if(isEmpty()) return -1;
        else return rear->prev->val;
    }
    bool isEmpty(){
        return curr==0;
    }
    bool isFull(){
        return curr==len;
    }
};
int main(){
    int len;
    cout<<"Enter the length of the circular deque"<<endl;
    cin>>len;
    circularDeque* deque=new circularDeque(len);
    int n;
    cout<<"Enter the number of operations"<<endl;
    cin>>n;
    for(int i=0;i<n;i++){
        int choice;
        cout<<"Enter number of operations:"<<endl;
        cin>>choice;
        if(choice==1){
            int value;
            cout<<"Enter the value to insert at the front: ";
            cin>>value;
            if(deque->insertFront(value)){
                cout<<"Value inserted at the front of the deque"<<endl;
            } 
            else{
                cout<<"Failed to insert value"<<endl;
            }
        }
        else if(choice==2){
            int value;
            cout<<"Enter the value to insert at the last: ";
            cin>>value;
            if(deque->insertLast(value)) {
                cout<<"Value inserted at the last of the deque"<<endl;
            } 
            else{
                cout<<"Failed to insert value"<<endl;
            }
        }
        else if(choice==3){
            if(deque->deleteFront()){
                cout<<"Value deleted from the front of the deque."<<endl;
            }
            else{
                cout<<"Failed to delete value"<<endl;
            }
        }
        else if(choice==4){
            if(deque->deleteLast()){
                cout<<"Value deleted from the last of the deque"<<endl;
            }
            else{
                cout<<"Failed to delete value"<<endl;
            }
        }
        else{
            cout<<"Invalid deque operation"<<endl;
        }
    }
    cout<<"Front value: "<<deque->getFront()<<endl;
    cout<<"Rear value: "<<deque->getRear()<<endl;
}