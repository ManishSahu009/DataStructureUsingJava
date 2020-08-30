package org.ms.ds.binarytree;

/*
https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
1. The two Nodes should be on the same level in the binary tree.
2. The two Nodes should not be siblings (means that they should not have the same parent Node).

		          1
		        /   \
		       /     \
		      2       3
		            /   \
		           /     \
		          5       6
		        /   \       \
		       /     \       \
		      7       8      11
		            /   \
		           /     \
		          9      10


 */

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfTwoNodesAreCousins {

    private static boolean isSiblings(TreeNode<Integer> root, TreeNode<Integer> a, TreeNode<Integer> b) {
        if(root ==null){
            return false;
        }
        if((root.left == a && root.right ==b) || root.left == b && root.right ==a){
            return true;
        }
        return isSiblings(root.left,a,b) || isSiblings(root.right,a,b);
    }

    public static int getLevel(TreeNode<Integer> root, TreeNode a) {
               return getLevel(root, a, 1);
            }

    private static int getLevel(TreeNode root, TreeNode a, int currLevel) {
               if (root == null) {
                   return 0;
               }
              if (root == a) {
                  return currLevel;
              }
                int level = getLevel(root.left, a, currLevel + 1);
                if (level != 0) {
                        return level;
                   } else {
                    return getLevel(root.right, a, currLevel + 1);
                }
    }

    private static boolean isCousins1(TreeNode<Integer> root, TreeNode<Integer> a, TreeNode<Integer> b) {
        if (a == b) {
                       return false;
                   }
               return (!isSiblings(root,a, b) && getLevel(root,a) == getLevel(root,b));
    }

    private static boolean isCousins2(TreeNode<Integer> root, TreeNode<Integer> x, TreeNode<Integer> y) {
        // Use queue to get nodes at the same level
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int found = 0;
        while (!queue.isEmpty())
        {

            TreeNode<Integer> current = queue.poll();
            if (current == null)
            {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                found=0;
                continue;
            }

            if (current.left!=null && (current.left.data == x.data || current.left.data == y.data)) {
                found++;
            }
            else if (current.right!=null && (current.right.data == x.data || current.right.data == y.data)) {
                found++;
            }
            if (found == 2) {
                return true;
            }

            if (current.left!=null) {
                queue.add(current.left);
            }
            if (current.right!=null) {
                queue.add(current.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.left.left = new TreeNode<>(7);
        root.right.left.right = new TreeNode<>(8);
        root.right.left.right.left = new TreeNode<>(9);
        root.right.left.right.right = new TreeNode<>(10);
        root.right.right.right=new TreeNode<>(11);


        if(isCousins1(root, root.right.left.left,root.right.right.right)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        if(isCousins2(root, root.right.left.left,root.right.right.right)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

}
