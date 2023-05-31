/*
 * Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have
Node.val == 0.
Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
A full binary tree is a binary tree where each node has exactly 0 or 2 children.
Example 1:
Input: n = 3
Output: [[0,0,0]]
Example 2:
Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],
 */

import java.util.*;
public class prob_5{
    public static List<List<Integer>> allPossibleFullBinaryTrees(int n){
        List<List<Integer>> trees=new ArrayList<>();
        if(n==1){
            trees.add(new ArrayList<>(List.of(0)));
        } 
        else{
            for(int x=0;x<n-1;x++){
                //for each pair of trees, it creates a new tree with the first tree as its left child and the second tree as its right child
                List<List<Integer>> leftTrees=allPossibleFullBinaryTrees(x);
                List<List<Integer>> rightTrees=allPossibleFullBinaryTrees(n-1-x);
                for (List<Integer> leftTree:leftTrees){
                    for (List<Integer> rightTree:rightTrees){
                        List<Integer> tree=new ArrayList<>();
                        tree.add(0);
                        tree.addAll(leftTree);
                        tree.addAll(rightTree);
                        trees.add(tree);
                    }
                }
            }
        }
        return trees;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<List<Integer>> trees=allPossibleFullBinaryTrees(n);
        System.out.println(trees);
    }
}