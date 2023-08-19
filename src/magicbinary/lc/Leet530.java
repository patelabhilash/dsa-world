package magicbinary.lc;

import java.util.ArrayDeque;
import java.util.Deque;


public class Leet530 {
    TreeNode root;
    public int getMinimumDifference(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
         int[] arr = {Integer.MAX_VALUE, Integer.MAX_VALUE};
         printNode(root, arr);
         return arr[1];
    }
 
    void printNode(TreeNode root, int[] arr){
         if(root.left != null) printNode(root.left);
         int diff = Math.abs(arr[0] - root.val);
         arr[1] = Math.min(diff, arr[1]); // global minima
         arr[0] = diff;
         if(root.right != null) printNode(root.right);
     }

    private void printNode(TreeNode right) {
    }   
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
}