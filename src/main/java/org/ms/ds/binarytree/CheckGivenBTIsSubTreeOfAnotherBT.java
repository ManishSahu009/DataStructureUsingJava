package org.ms.ds.binarytree;


import java.util.ArrayList;
import java.util.List;

/* Construct below tree
				  1
			   /	 \
			  2	   3
			 / \	 / \
			4   5   6   7
*/
public class CheckGivenBTIsSubTreeOfAnotherBT {


    private static void inorder(TreeNode<Integer> root, List<TreeNode<Integer>> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }

    private static void postorder(TreeNode<Integer> root, List<TreeNode<Integer>> list){
        if(root==null){
            return;
        }
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root);
    }

    public static boolean checkSubtreeUsingTraversal(TreeNode<Integer> tree, TreeNode<Integer> subtree){
        if(tree == subtree){
            return true;
        }
        if(tree == null){
            return false;
        }
        List<TreeNode<Integer>> first = new ArrayList<>();
        List<TreeNode<Integer>> second = new ArrayList<>();
        inorder(tree, first);
        inorder(subtree, second);
        if(!first.toString().substring(1,first.size()-1).contains(second.toString().substring(1,first.size()-1))){
             return false;
        }
        first.clear();
        second.clear();

        postorder(tree, first);
        postorder(subtree, second);
        if(!first.toString().substring(1,first.size()-1).contains(second.toString().substring(1,first.size()-1))){
            return false;
        }
        return true;

    }

    private static boolean checkIfTwoTreeAreIdentical(TreeNode<Integer> tree1, TreeNode<Integer> tree2){
        if(tree1==null && tree2==null){
            return true;
        }
        if(tree1==null || tree2==null){
            return false;
        }
        return tree1.data==tree2.data
                && checkIfTwoTreeAreIdentical(tree1.left,tree2.left)
                && checkIfTwoTreeAreIdentical(tree1.right,tree2.right);

    }

    public static boolean checkSubtreeUsingRecussion(TreeNode<Integer> tree, TreeNode<Integer> subtree) {

        if(subtree==null){
            return true;
        }
        if(tree ==null){
            return false;
        }
        if(checkIfTwoTreeAreIdentical(tree,subtree)){
           return true;
        }
        return checkSubtreeUsingRecussion(tree.left,subtree)
                || checkSubtreeUsingRecussion(tree.right,subtree);

    }

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        if (checkSubtreeUsingTraversal(root, root.right)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }

        if (checkSubtreeUsingRecussion(root, root.right)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }

}
