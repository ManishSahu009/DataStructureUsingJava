package org.ms.ds.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class CheckIfAllLeafatSameLevel {

    private static boolean checkAllLevelAtSameLevel(Node<Integer> root, AtomicInteger levelOfLeaf, int level) {
        if(root == null)
            return true;

        if(root.left==null && root.right==null){
            //set first leaf node level
            if(levelOfLeaf.get() == 0){
                levelOfLeaf.set(level);
                return true;
            }
            //comparing first leave node with all leaf;
             return levelOfLeaf.get() == level;
        }

        return checkAllLevelAtSameLevel(root.left,levelOfLeaf,level+1)
                || checkAllLevelAtSameLevel(root.right,levelOfLeaf,level+1);
    }

    public static void main(String[] args) {
        AtomicInteger levelOfLeaf=new AtomicInteger(0);
        int level=1;
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        System.out.println("CheckIfAllLeafatSameLevel : " + checkAllLevelAtSameLevel(root,levelOfLeaf,level));
    }


}
