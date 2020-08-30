package org.ms.ds.binarytree;

/* Construct below tree
		          44 (4+5+9) + (6+7+13)
		        /    \
		       /      \
	   (4+5)  9       13 (6+7)
		     / \      /  \
		    4  5     6    7


https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
*/

public class ConvertBinaryTreeToSumTree {

    public static void preorder(TreeNode root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static int convertToSumTree(TreeNode<Integer> root)
    {
        if (root == null) {
            return 0;
        }
        int left = convertToSumTree(root.left);
        int right = convertToSumTree(root.right);
        int old = root.data;
        root.data = left + right;
        return root.data + old;
    }


    public static void main(String[] args)
    {

        TreeNode<Integer> root = new TreeNode<>(44);
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        preorder(root);
        System.out.println();
        convertToSumTree(root);
        preorder(root);
    }



}
