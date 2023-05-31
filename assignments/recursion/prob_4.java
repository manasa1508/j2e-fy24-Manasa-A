/*
 * 
 * Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can
slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on
top of an even larger one).
You have the following constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto another tower.
(3) A disk cannot be placed on top of a smaller disk.
Write a program to move the disks from the first tower to the last and print the moves.
Example 1:
Input: N = 3
Output:
Move disk from rod 1 to rod 3
Move disk from rod 1 to rod 2
Move disk from rod 3 to rod 2
Move disk from rod 1 to rod 3
Move disk from rod 2 to rod 1
Move disk from rod 2 to rod 3
Move disk from rod 1 to rod 3
 */

import java.util.*;
public class prob_4{
    public static void moveDisks(int n, int source, int auxiliary, int destination){
        if(n>0){
            //move n-1 disks from source to auxiliary tower
            moveDisks(n-1,source,destination,auxiliary);
            //move the nth disk from source to destination tower
            System.out.println("Move disk from rod " + source + " to rod " + destination);
            //move the n-1 disks from auxiliary tower to destination tower
            moveDisks(n-1,auxiliary,source,destination);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sourceRod=1;//source tower (rod)
        int auxiliaryRod=2; //auxiliary tower (rod)
        int destinationRod=3; // destination tower (rod) 
        moveDisks(n,sourceRod,auxiliaryRod,destinationRod);
    }
} 