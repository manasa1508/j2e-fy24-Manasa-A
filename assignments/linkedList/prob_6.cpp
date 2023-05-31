/*Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value
pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]Output
[null, null, null, 1, null, -1, null, -1, 3, 4]
Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
Constraints:
1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105
calls will be made to get and put
*/

#include <bits/stdc++.h>
using namespace std;
class LRUcache{
    public:
    class Node{
        public:
        int key; 
        int val;
        Node* next;
        Node* prev;
        Node(int Key, int Val){
            key=Key;
            val=Val;
            next=NULL;
            prev=NULL;
        }
    };
    int n;
    unordered_map<int,Node*> m;
    Node* head=new Node(0,0);
    Node* tail=new Node(0,0);

    void remove(Node* root){
        m.erase(root->key);
        Node* r1=root->next;
        Node* r2=root->prev;
        r2->next=r1;
        r1->prev=r2;
    }

    void insert(Node* root){
        m[root->key]=root;
        Node* temp=head->next;
        head->next = root;
        root->next = temp;
        temp->prev = root;
        root->prev = head;  
    }

    LRUcache(int capacity){
        n=capacity;
        head->next=tail;
        tail->prev=head;
    }

    int get(int key){
        if(m.count(key)==0) return -1;
        Node* temp=m[key];
        remove(temp);
        insert(temp);
        return temp->val;
    }

    void put(int key,int value){
        Node* temp=new Node(key,value);
        if(m.count(key)!=0){
            remove(m[key]);
        }
        if(m.size()==n){
            remove(tail->prev);
        }
        insert(temp);
    }
};
int main(){
    int capacity;
    cout<<"Enter the capacity of the LRUcache"<<endl;
    cin>>capacity;
    LRUcache* cache=new LRUcache(capacity);
    int n;
    cout<<"Enter number of queries:"<<endl;
    cin>>n;
    for(int i=0;i<n;i++){
        int choice;
        cout<<"Enter your choice: (1=get, 2=put)"<<endl;
        cin>>choice;
        if(choice==1){
            int key;
            cout<<"Enter key"<<endl;
            cin>>key;
            int value=cache->get(key);
            cout<<"Value: "<<value<<endl;
        }
        else if(choice==2){
            int key,value;
            cout<<"Enter key and value to put"<<endl;
            cin>>key>>value;
            cache->put(key,value);
            cout<<"Key value added to cache"<<endl;
        }
        else{
            cout<<"Invalid input";
        }
    }
}