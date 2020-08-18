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
 */

public class CheckIfTwoNodesAreSiblings {


    private static boolean isSiblings(Node<Integer> root, Node<Integer> a, Node<Integer> b) {
        if(root ==null){
            return false;
        }
        if((root.left == a && root.right ==b) || root.left == b && root.right ==a){
            return true;
        }
        return isSiblings(root.left,a,b) || isSiblings(root.right,a,b);
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


        if(isSiblings(root, root.right.left,root.right.right)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }


}
