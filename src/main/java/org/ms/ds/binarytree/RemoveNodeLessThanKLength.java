package org.ms.ds.binarytree;

/*
		          1
		        /   \
		       /     \
		      2       3
		            /   \
		           /     \
		          5       6
		        /   \
		       /     \
		      7       8
		            /   \
		           /     \
		          9      10
https://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/
 */

public class RemoveNodeLessThanKLength {

    static TreeNode<Integer> removeNodeLessThanK(TreeNode<Integer> root, int k, int level){

        if(root == null){
           return null;
        }
        root.left=removeNodeLessThanK(root.left,k,level+1);
        root.right=removeNodeLessThanK(root.right,k,level+1);

        if(root.left == null && root.right == null && level < k){
            return null;
        }
        return root;
    }

    static void  printPreorder(TreeNode<Integer> root){
        if(root ==null){
            return;
        }
        System.out.print(root.data+" ");
        printPreorder(root.left);
        printPreorder(root.right);
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
        printPreorder(root);
        System.out.println();
        printPreorder(removeNodeLessThanK(root,4,1));

    }


}
