package org.ms.ds.binarytree;

/*
https://www.techiedelight.com/clone-a-binary-tree-with-random-pointers/

 */

import java.util.HashMap;
import java.util.Map;

public class CloneBinaryTreeWithRandomPointer {

    public static void preorder(TreeNodeWRP<Integer> root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " -> (");
        System.out.print((root.left != null ? root.left.data : "X") + ", ");
        System.out.print((root.right != null ? root.right.data : "X") + ", ");
        System.out.println((root.random != null ? root.random.data : "X") + ")");
        preorder(root.left);
        preorder(root.right);
    }

    private static TreeNodeWRP<Integer> cloneSpecialBinaryTree(TreeNodeWRP<Integer> root) {
        Map<TreeNodeWRP<Integer>,TreeNodeWRP<Integer>> map = new HashMap<>();
        cloneLeftRightPointer(root,map);
        updateRandomPointers(root,map);
        return map.get(root);

    }

    private static void updateRandomPointers(TreeNodeWRP<Integer> root, Map<TreeNodeWRP<Integer>, TreeNodeWRP<Integer>> map) {
        if(map.get(root)==null){
            return;
        }
        map.get(root).random=map.get(root.random);
        updateRandomPointers(root.left,map);
        updateRandomPointers(root.right,map);

    }

    private static TreeNodeWRP<Integer> cloneLeftRightPointer(TreeNodeWRP<Integer> root, Map<TreeNodeWRP<Integer>, TreeNodeWRP<Integer>> map) {
        if(root ==null){
            return null;
        }
        map.put(root,new TreeNodeWRP<>(root.data));
        map.get(root).left=cloneLeftRightPointer(root.left,map);
        map.get(root).right=cloneLeftRightPointer(root.right,map);
        return map.get(root);
    }


    public static void main(String[] args)
    {
        TreeNodeWRP<Integer> root = new TreeNodeWRP<>(1);
        root.left = new TreeNodeWRP<>(2);
        root.right = new TreeNodeWRP<>(3);
        root.left.left = new TreeNodeWRP<>(4);
        root.left.right = new TreeNodeWRP<>(5);
        root.right.left = new TreeNodeWRP<>(6);
        root.right.right = new TreeNodeWRP<>(7);

        root.random = root.right.left.random;
        root.left.left.random = root.right;
        root.left.right.random = root;
        root.right.left.random = root.left.left;
        root.random = root.left;

        System.out.println("Preorder traversal of the original tree:");
        preorder(root);

        TreeNodeWRP<Integer> clone = cloneSpecialBinaryTree(root);

        System.out.println("\nPreorder traversal of the cloned tree:");
        preorder(clone);
    }

}

class TreeNodeWRP<T>
{
    T data;
    TreeNodeWRP<T> left, right;
    TreeNodeWRP<T> random;

    // Constructor
    TreeNodeWRP(T data) {
        this.data = data;
    }
}
