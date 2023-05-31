/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
EXAMPLE 1
Input: p = [1,2,3], q = [1,2,3]Output: true
Example 2
Input: p = [1,2,1], q = [1,1,2]Output: false
Example 3
Input: p = [1,2], q = [1,null,2]Output: false
 */

import java.util.*;
class prob_1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        System.out.println("Enter the first binary tree");
        String inp=sc.nextLine();
        String[] strp=inp.split(",");
        Node p=binaryTree.Tree(strp);
        System.out.println("Enter the second binary tree");
        String inq=sc.nextLine();
        String[] strq=inq.split(",");
        Node q=binaryTree.Tree(strq);
        boolean result=binaryTree.isSameTree(p,q);
        System.out.println(result);
    }
}
class Node{
    int val;
    Node left;
    Node right;
    Node(int value){
        val=value;
        left=null;
        right=null;
    }
}
class BinaryTree {
    public Node Tree(String[] nodes){
        if(nodes.length==0){
            return null;
        }
        Node root=AddChild(nodes,0);
        return root;
    }
    public Node AddChild(String[] nodes,int i){
        if(i>=nodes.length || nodes[i].equals("null")){
            return null;
        }
        Node node=new Node(Integer.parseInt(nodes[i]));
        node.left=AddChild(nodes,2*i+1);
        node.right=AddChild(nodes,2*i+2);
        return node;
    }
    public boolean isSameTree(Node p, Node q){
        if (p==null && q==null) return true;
        if(p==null || q==null) return false; //if either node at the same position is null, the trees are not same
        if(p.val!=q.val) return false; //if the nodes value is not same, the trees are naturally not smae
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); //recursively check for the children nodes
    }
}

