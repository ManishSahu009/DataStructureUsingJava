package org.ms.ds.tree;

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

    private static String serialize(Node<Integer> root) {
        if(root == null){
            return NULL_SYMBOL+DELIMITER;
        }
        String leftSer=serialize(root.left);
        String rightSer=serialize(root.right);
        return root.data + DELIMITER + leftSer+rightSer;
    }

    private static Node<Integer> deserialize(String serTree) {
        Queue<String> nodesToMaterialize=new LinkedList<>();
        nodesToMaterialize.addAll(Arrays.asList(serTree.split(DELIMITER)));
        return deserializeHelper(nodesToMaterialize);
    }

    private static  Node<Integer> deserializeHelper(Queue<String> nodesToMaterialize){
        String valueForNode=nodesToMaterialize.poll();
        if(valueForNode.equals(NULL_SYMBOL)){
           return null;
        }
        Node<Integer> node=new Node<>(Integer.valueOf(valueForNode));
        node.left=deserializeHelper(nodesToMaterialize);
        node.right=deserializeHelper(nodesToMaterialize);
        return node;

    }

    public static void main(String[] args)
    {

        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        root.right.left.left = new Node<>(18);

        String serTree=serialize(root);
        System.out.println(serTree);
        System.out.println(deserialize(serTree));
    }


}
