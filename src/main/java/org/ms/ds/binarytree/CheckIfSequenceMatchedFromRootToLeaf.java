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
https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/
 */

public class CheckIfSequenceMatchedFromRootToLeaf {

    static  boolean checkIfSequenceMatchedFromRootToLeaf(TreeNode<Integer> root, int []sequence, int index){

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

        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.right.left = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        root.right.left.left = new TreeNode<>(7);
        root.right.left.right = new TreeNode<>(8);
        root.right.left.right.left = new TreeNode<>(9);
        root.right.left.right.right = new TreeNode<>(10);

        int[] sequence = { 1,3,6 };
        int index=0;

        if(checkIfSequenceMatchedFromRootToLeaf(root,sequence,index)){
            System.out.println("Path exist");
        }else{
            System.out.println("Path does not exist");
        }

    }


}
