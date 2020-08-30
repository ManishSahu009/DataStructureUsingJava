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

public class SumTree {

    private static int isSumTree(TreeNode<Integer> root) {
        if(root ==null)
            return 0;
        if(root.left==null && root.right==null){
            return root.data;
        }
        if(root.data == isSumTree(root.left) + isSumTree(root.right)){
            return 2*root.data;
        }
        return Integer.MIN_VALUE;

    }

    public static void main(String[] args)
    {

        TreeNode<Integer> root = new TreeNode<>(44);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(13);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);

        if (isSumTree(root) != Integer.MIN_VALUE) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }

    }



}
