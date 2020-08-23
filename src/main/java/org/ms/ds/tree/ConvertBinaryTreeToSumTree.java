package org.ms.ds.tree;

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

    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static int convertToSumTree(Node<Integer> root)
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

        Node<Integer> root = new Node<>(44);
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        preorder(root);
        System.out.println();
        convertToSumTree(root);
        preorder(root);
    }



}
