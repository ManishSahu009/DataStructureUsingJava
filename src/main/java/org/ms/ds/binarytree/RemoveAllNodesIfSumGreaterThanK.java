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

public class RemoveAllNodesIfSumGreaterThanK {

    static TreeNode<Integer> removeNodeLessThanK(TreeNode<Integer> root, int sum, int nodeSum){

        if(root == null){
            return null;
        }
        root.left=removeNodeLessThanK(root.left,sum,nodeSum+root.data);
        root.right=removeNodeLessThanK(root.right,sum,nodeSum+root.data);

        if(root.left == null && root.right == null && (nodeSum + root.data) <= sum){
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
        printPreorder(removeNodeLessThanK(root,7,0));

    }


}

