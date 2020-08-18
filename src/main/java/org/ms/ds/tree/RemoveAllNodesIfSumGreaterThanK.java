package org.ms.ds.tree;

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

    static Node<Integer> removeNodeLessThanK(Node<Integer> root, int sum, int nodeSum){

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

    static void  printPreorder(Node<Integer> root){
        if(root ==null){
            return;
        }
        System.out.print(root.data+" ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {

        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(6);
        root.right.left.left = new Node<>(7);
        root.right.left.right = new Node<>(8);
        root.right.left.right.left = new Node<>(9);
        root.right.left.right.right = new Node<>(10);
        printPreorder(root);
        System.out.println();
        printPreorder(removeNodeLessThanK(root,7,0));

    }


}

