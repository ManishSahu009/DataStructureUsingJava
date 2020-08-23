package org.ms.ds.tree;

/*
https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
		          1
		        /   \
		       /     \
		      2       3
		            /   \
		           /     \
		          5       6
		        /   \       \
		       /     \       \
		      7       8      11
		            /   \
		           /     \
		          9      10

1. find the LCA of given node
2. Find level for both node from LCA as root
3. sum the level and return

 */

public class DistanceBetweenTwoNodes {

    private static Node<Integer> findLCA(Node<Integer> root, Node<Integer> p1, Node<Integer> p2){
        if(root == null){
            return null;
        }
        if(root == p1 || root == p2){
            return root;
        }
        Node<Integer> left=findLCA(root.left,p1,p2);
        Node<Integer> right=findLCA(root.right,p1,p2);
        if(left!=null && right !=null){
            return root;
        }
        else{
            return left!=null?left:right;
        }
    }

    private static int findLevel(Node<Integer> root, Node<Integer> nodeTofindLevel, int level){
        if(root == null){
            return -1;
        }
        if(root == nodeTofindLevel){
            return level;
        }
        int left=findLevel(root.left,nodeTofindLevel,level+1);
        if(left == -1){
            return findLevel(root.right,nodeTofindLevel,level+1);
        }
        return left;
    }

    private static int findDistanceBetweenTwoNodes(Node<Integer> root, Node<Integer> p1, Node<Integer> p2) {
      Node<Integer> lca=findLCA(root,p1,p2);
      int dis1=findLevel(lca,p1,0);
      int dis2=findLevel(lca,p2,0);
      return dis1+dis2;

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
        root.right.right.right=new Node<>(11);
        System.out.println("DistanceBetweenTwoNodes : " + findDistanceBetweenTwoNodes(root,root.left,root.right.right.right));
    }



}
