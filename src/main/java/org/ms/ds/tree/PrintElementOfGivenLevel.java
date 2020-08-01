package org.ms.ds.tree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */

public class PrintElementOfGivenLevel {

   public static void pegl(Node root , int level){
       if(root == null){
           return;
       }
       if(level == 1){
           System.out.print(root.data+" ");
           return;
       }
       pegl(root.left,level-1);
       pegl(root.right,level-1);
   }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        System.out.println();
        pegl(root,3);

    }
}
