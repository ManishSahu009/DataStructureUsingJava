package org.ms.ds.binarytree;

/* Construct below tree
		          15
		        /    \
		       /      \
		      10       20
		     / \      /  \
		    8   12   16  25
		            /
		           18
		*/


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    private static final String NULL_SYMBOL = "X";
    private static final String DELIMITER = ",";

    private static String serialize(TreeNode<Integer> root) {
        if(root == null){
            return NULL_SYMBOL+DELIMITER;
        }
        String leftSer=serialize(root.left);
        String rightSer=serialize(root.right);
        return root.data + DELIMITER + leftSer+rightSer;
    }

    private static TreeNode<Integer> deserialize(String serTree) {
        Queue<String> nodesToMaterialize=new LinkedList<>();
        nodesToMaterialize.addAll(Arrays.asList(serTree.split(DELIMITER)));
        return deserializeHelper(nodesToMaterialize);
    }

    private static TreeNode<Integer> deserializeHelper(Queue<String> nodesToMaterialize){
        String valueForNode=nodesToMaterialize.poll();
        if(valueForNode.equals(NULL_SYMBOL)){
           return null;
        }
        TreeNode<Integer> treeNode =new TreeNode<>(Integer.valueOf(valueForNode));
        treeNode.left=deserializeHelper(nodesToMaterialize);
        treeNode.right=deserializeHelper(nodesToMaterialize);
        return treeNode;

    }

    public static void main(String[] args)
    {

        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        root.right.left.left = new TreeNode<>(18);

        String serTree=serialize(root);
        System.out.println(serTree);
        System.out.println(deserialize(serTree));
    }


}
