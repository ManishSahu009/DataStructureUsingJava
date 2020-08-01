package org.ms.ds.tree;

public class CountNoOfNodes {


    public static int getNumberOfNodes(Node<Integer> root) {

        if(root == null){
            return 0;
        }
        int lv=getNumberOfNodes(root.left);
        int rv=getNumberOfNodes(root.right);
        return 1 + (lv+rv);
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        System.out.println(getNumberOfNodes(root));

    }
}
