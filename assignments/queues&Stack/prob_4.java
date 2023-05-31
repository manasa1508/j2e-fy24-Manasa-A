/*PROBLEM 4. DESIGN A DATA STRUCTURE THAT WORKS LIKE A LRU CACHE. HERE CAP DENOTES THE CAPACITY OF
THE CACHE AND Q DENOTES THE NUMBER OF QUERIES. QUERY CAN BE OF TWO TYPES:
1.
2.
SET x y: sets the value of the key x with value y
GET x: gets the key of x if present else returns -1.
The LRUCache class has two methods get() and set() which are defined as follows.
1.
2.
3.
get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
set(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the
cache reaches its capacity it should invalidate the least recently used item before inserting the new item.
In the constructor of the class the capacity of the cache should be initialized.
Example 1:
Input:cap = 2
Q = 2
Queries = SET 1 2 GET 1Output: 2
Explanation: Cache Size = 2
SET 1 2 GET 1
SET 1 2 : 1 -> 2
GET 1 : Print the value corresponding
to Key 1, ie 2.
*/
import java.util.*;
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class LRUCache{
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
        this.capacity=capacity;
        this.cache=new HashMap<>();
        this.head=new Node(0, 0);
        this.tail=new Node(0, 0);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    public int get(int key){
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }
    public void set(int key, int value) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            node.value=value;
            moveToHead(node);
        } 
        else{
            Node newNode=new Node(key, value);
            cache.put(key,newNode);
            addToHead(newNode);
            if(cache.size() > capacity) {
                Node tailNode=removeTail();
                cache.remove(tailNode.key);
            }
        }
    }
    private void addToHead(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }
    private Node removeTail(){
        Node tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
    }
}
public class prob_4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int capacity=sc.nextInt();
        int queries=sc.nextInt();
        LRUCache cache=new LRUCache(capacity);
        for(int i=0;i<queries;i++){
            String query=sc.next();
            if (query.equals("SET")) {
                int key=sc.nextInt();
                int value=sc.nextInt();
                cache.set(key,value);
            } 
            else if (query.equals("GET")) {
                int key=sc.nextInt();
                int value=cache.get(key);
                System.out.println(value);
            }
        }

        sc.close();
    }
}
