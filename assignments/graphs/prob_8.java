/*
. Given a binary tree, implement a function to find the maximum path sum, where a path is defined as any sequence
of nodes from some starting node to any node in the tree along the parent-child connections.
Example:
Input:
root = [-10,9,20,null,null,15,7]
Output:
42
*/
import java.util.*;
class prob_8{
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int value){
            val=value;
            left=null;
            right=null;
        }
    }
    public static Node Tree(String[] nodes){
        Queue<Node> q=new LinkedList<>();
        //level order traversal
        Node root=new Node(Integer.parseInt(nodes[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<nodes.length){
            Node curr=q.poll();
            if(!nodes[i].equals("null")){
                curr.left=new Node(Integer.parseInt(nodes[i]));
                q.add(curr.left);
            }
            i++;
            if(i<nodes.length && !nodes[i].equals("null")){
                curr.right=new Node(Integer.parseInt(nodes[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    int result = Integer.MIN_VALUE;
    public int maxPathSum(Node root){
        helper(root);
        return result;
    }
    public int helper(Node root){
        if(root == null){
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        int max_st = Math.max(Math.max(left,right)+root.val,root.val);
        int max_case_root = Math.max(max_st,left+right+root.val);
        result= Math.max(result,max_case_root);
        return max_st; 
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String in=sc.nextLine();
        String[] nodes=in.split(" ");
        Node root=Tree(nodes);
        prob_8 obj=new prob_8();
        int res=obj.maxPathSum(root);
        System.out.println(res);
    }
}