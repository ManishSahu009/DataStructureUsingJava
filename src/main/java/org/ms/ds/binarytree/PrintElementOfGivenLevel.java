package org.ms.ds.binarytree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
 */

public class PrintElementOfGivenLevel {

   public static void pegl(TreeNode root , int level){
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
        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        System.out.println();
        pegl(root,3);

    }
}
