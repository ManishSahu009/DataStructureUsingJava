package org.ms.ds.tree;

/*
https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
1. The two Nodes should be on the same level in the binary tree.
2. The two Nodes should not be siblings (means that they should not have the same parent Node).

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


 */

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfTwoNodesAreCousins {

    private static boolean isSiblings(Node<Integer> root, Node<Integer> a, Node<Integer> b) {
        if(root ==null){
            return false;
        }
        if((root.left == a && root.right ==b) || root.left == b && root.right ==a){
            return true;
        }
        return isSiblings(root.left,a,b) || isSiblings(root.right,a,b);
    }

    public static int getLevel(Node<Integer> root, Node a) {
               return getLevel(root, a, 1);
            }

    private static int getLevel(Node root, Node a, int currLevel) {
               if (root == null) {
                   return 0;
               }
              if (root == a) {
                  return currLevel;
              }
                int level = getLevel(root.left, a, currLevel + 1);
                if (level != 0) {
                        return level;
                   } else {
                    return getLevel(root.right, a, currLevel + 1);
                }
    }

    private static boolean isCousins1(Node<Integer> root, Node<Integer> a, Node<Integer> b) {
        if (a == b) {
                       return false;
                   }
               return (!isSiblings(root,a, b) && getLevel(root,a) == getLevel(root,b));
    }

    private static boolean isCousins2(Node<Integer> root, Node<Integer> x, Node<Integer> y) {
        // Use queue to get nodes at the same level
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int found = 0;
        while (!queue.isEmpty())
        {

            Node<Integer> current = queue.poll();
            if (current == null)
            {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                found=0;
                continue;
            }

            if (current.left!=null && (current.left.data == x.data || current.left.data == y.data)) {
                found++;
            }
            else if (current.right!=null && (current.right.data == x.data || current.right.data == y.data)) {
                found++;
            }
            if (found == 2) {
                return true;
            }

            if (current.left!=null) {
                queue.add(current.left);
            }
            if (current.right!=null) {
                queue.add(current.right);
            }
        }
        return false;
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


        if(isCousins1(root, root.right.left.left,root.right.right.right)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        if(isCousins2(root, root.right.left.left,root.right.right.right)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }

}
