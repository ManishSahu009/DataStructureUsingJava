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
https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/
 */

public class CheckIfSequenceMatchedFromRootToLeaf {

    static  boolean checkIfSequenceMatchedFromRootToLeaf(Node<Integer> root, int []sequence, int index){

        if(root == null){
            return false;
        }
       if(index >= sequence.length || root.data != sequence[index]){
           return false;
       }
       if(root.left==null && root.right==null && index==sequence.length-1){
           return true;
       }
       return checkIfSequenceMatchedFromRootToLeaf(root.left,sequence,index+1)
               || checkIfSequenceMatchedFromRootToLeaf(root.right,sequence,index+1);
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

        int[] sequence = { 1,3,6 };
        int index=0;

        if(checkIfSequenceMatchedFromRootToLeaf(root,sequence,index)){
            System.out.println("Path exist");
        }else{
            System.out.println("Path does not exist");
        }

    }


}
