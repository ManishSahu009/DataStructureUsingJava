package org.ms.ds.binarysearchtree;

/*
Input:
     Tree 1            Tree 2
       2                 3
      / \               / \
     1   4             6   1
    /                   \   \
   5                     2   7

Output: Merged tree:
         5
        / \
       7   5
      / \   \
     5   2   7

 */

import com.sun.source.tree.Tree;
import org.ms.ds.binarytree.TreeNode;

public class MergeTwoBinaryTreeToSum {

    private static  void inorder(TreeNode<Integer> root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);

    }

    private static TreeNode<Integer> mergeTrees(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if(root1 == null  && root2==null){
            return null;
        }
        if(root1!=null && root2==null){
            return  root1;
        }
        if(root1==null && root2!=null){
            return  root2;
        }
        TreeNode<Integer> sumNode=new TreeNode<>(root1.data + root2.data);
        sumNode.left=mergeTrees(root1.left,root2.left);
        sumNode.right=mergeTrees(root1.right,root2.right);
        return sumNode;
    }

    public static void main(String[] args) {
         /* Let us construct the first Binary Tree
                 1
               /   \
              2     3
             / \     \
            4   5     6
         */

        TreeNode<Integer> root1 = new TreeNode<>(1);
        root1.left = new TreeNode<>(2);
        root1.right = new TreeNode<>(3);
        root1.left.left = new TreeNode<>(4);
        root1.left.right = new TreeNode<>(5);
        root1.right.right = new TreeNode<>(6);

         /* Let us construct the second Binary Tree
                4
              /   \
             1     7
            /     /  \
           3     2    6   */
        TreeNode<Integer> root2 = new TreeNode<>(4);
        root2.left = new TreeNode<>(1);
        root2.right = new TreeNode<>(7);
        root2.left.left = new TreeNode<>(3);
        root2.right.left = new TreeNode<>(2);
        root2.right.right = new TreeNode<>(6);

        TreeNode<Integer> root3 = mergeTrees(root1, root2);
        inorder(root3);
    }


}
