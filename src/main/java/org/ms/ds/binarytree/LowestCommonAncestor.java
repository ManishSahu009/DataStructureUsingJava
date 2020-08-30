package org.ms.ds.binarytree;

/*
                        15
                      /    \
                    10      20
                  /   \    /  \
                8     12  16  25
                     /
                    11
 */

public class LowestCommonAncestor {

    public static TreeNode<Integer> getLCARecursion1(TreeNode<Integer> root, TreeNode<Integer> p1, TreeNode<Integer> p2){
       if(p1.data < root.data && p2.data < root.data){
         return getLCARecursion1(root.left,p1,p2);
       }else if((p1.data > root.data && p2.data > root.data)){
         return getLCARecursion1(root.right,p1,p2);
       }else{
           return root;
       }
    }

    public static TreeNode<Integer> getLCARecursion2(TreeNode<Integer> root, TreeNode<Integer> p1, TreeNode<Integer> p2){
      if(root == null){
          return null;
      }
      if(root == p1 || root == p2){
          return root;
      }
      TreeNode<Integer> left=getLCARecursion2(root.left,p1,p2);
      TreeNode<Integer> right=getLCARecursion2(root.right,p1,p2);
      if(left!=null && right !=null){
          return root;
      }
      else{
          return left!=null?left:right;
      }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.left.right.left=new TreeNode<>(11);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        System.out.println(getLCARecursion1(root,new TreeNode<>(8),new TreeNode<>(11)).data);
        System.out.println(getLCARecursion2(root,root.left.left,root.left.right.left).data);


    }
}
