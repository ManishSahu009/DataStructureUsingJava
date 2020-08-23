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

public class SumTree {

    private static int isSumTree(Node<Integer> root) {
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

        Node<Integer> root = new Node<>(44);
        root.left = new Node<>(9);
        root.right = new Node<>(13);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);

        if (isSumTree(root) != Integer.MIN_VALUE) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }

    }



}
