package org.ms.ds.tree;

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

    public static Node<Integer> getLCARecursion1(Node<Integer> root, Node<Integer> p1, Node<Integer> p2){
       if(p1.data < root.data && p2.data < root.data){
         return getLCARecursion1(root.left,p1,p2);
       }else if((p1.data > root.data && p2.data > root.data)){
         return getLCARecursion1(root.right,p1,p2);
       }else{
           return root;
       }
    }

    public static Node<Integer> getLCARecursion2(Node<Integer> root, Node<Integer> p1, Node<Integer> p2){
      if(root == null){
          return null;
      }
      if(root == p1 || root == p2){
          return root;
      }
      Node<Integer> left=getLCARecursion2(root.left,p1,p2);
      Node<Integer> right=getLCARecursion2(root.right,p1,p2);
      if(left!=null && right !=null){
          return root;
      }
      else{
          return left!=null?left:right;
      }
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.left.right.left=new Node<>(11);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        System.out.println(getLCARecursion1(root,new Node<>(8),new Node<>(11)).data);
        System.out.println(getLCARecursion2(root,root.left.left,root.left.right.left).data);


    }
}
