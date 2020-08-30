package org.ms.ds.binarytree;

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


import java.util.*;

public class PrintElementsAtKDistanceFromGivenNode {

    private static void parentMapBuilder(TreeNode<Integer> root, TreeNode<Integer> parent, Map<TreeNode<Integer>, TreeNode<Integer>> nodeToParentMap){
        if(root == null){
            return;
        }
        nodeToParentMap.put(root,parent);
        parentMapBuilder(root.left,root,nodeToParentMap);
        parentMapBuilder(root.right,root,nodeToParentMap);

    }


    private static List<Integer> distanceK(TreeNode<Integer> root, TreeNode<Integer> startTreeNode, int dist){
        Map<TreeNode<Integer>, TreeNode<Integer>> nodeToParentMap=new HashMap<>();
        parentMapBuilder(root,null,nodeToParentMap);
        //to maintain child by level
        Queue<TreeNode<Integer>> queue =new LinkedList<>();
        queue.add(startTreeNode);
        //to maintain if seen
        Set<TreeNode<Integer>> seen=new HashSet<>();
        seen.add(startTreeNode);
        int currentLayer=0;

        while(!queue.isEmpty()) {

            if(currentLayer == dist){
                return extractLayerFromQueue(queue);
            }

            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {

                TreeNode<Integer> currentTreeNode = queue.poll();

                if (currentTreeNode.left != null && !seen.contains(currentTreeNode.left)) {
                    seen.add(currentTreeNode.left);
                    queue.offer(currentTreeNode.left);
                }

                if (currentTreeNode.right != null && !seen.contains(currentTreeNode.right)) {
                    seen.add(currentTreeNode.right);
                    queue.offer(currentTreeNode.right);
                }

                TreeNode<Integer> parentOfCuurentNOde = nodeToParentMap.get(currentTreeNode);
                if (parentOfCuurentNOde != null && !seen.contains(parentOfCuurentNOde)) {
                    seen.add(parentOfCuurentNOde);
                    queue.offer(parentOfCuurentNOde);
                }


            }
            currentLayer++;
        }
        return new ArrayList<>();

    }

    private static List<Integer> extractLayerFromQueue(Queue<TreeNode<Integer>> queue) {
        List<Integer> extractedList = new ArrayList<>();
        for (TreeNode<Integer> treeNode : queue) {
            extractedList.add(treeNode.data);
        }
        return extractedList;
    }

    public static void main(String[] args)
    {

        TreeNode<Integer> root = new TreeNode<>(15);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(8);
        root.left.right = new TreeNode<>(12);
        root.right.left = new TreeNode<>(16);
        root.right.right = new TreeNode<>(25);
        root.right.left.left = new TreeNode<>(18);

        int dist = 2;
        distanceK(root, root.left,dist).forEach(System.out::println);
    }
}
