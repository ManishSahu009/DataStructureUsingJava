package org.ms.ds.tree;

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

    private static void parentMapBuilder(Node<Integer> root, Node<Integer> parent, Map<Node<Integer>,Node<Integer>> nodeToParentMap){
        if(root == null){
            return;
        }
        nodeToParentMap.put(root,parent);
        parentMapBuilder(root.left,root,nodeToParentMap);
        parentMapBuilder(root.right,root,nodeToParentMap);

    }


    private static List<Integer> distanceK(Node<Integer> root, Node<Integer> startNode, int dist){
        Map<Node<Integer>,Node<Integer>> nodeToParentMap=new HashMap<>();
        parentMapBuilder(root,null,nodeToParentMap);
        //to maintain child by level
        Queue<Node<Integer>> queue =new LinkedList<>();
        queue.add(startNode);
        //to maintain if seen
        Set<Node<Integer>> seen=new HashSet<>();
        seen.add(startNode);
        int currentLayer=0;

        while(!queue.isEmpty()) {

            if(currentLayer == dist){
                return extractLayerFromQueue(queue);
            }

            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {

                Node<Integer> currentNode = queue.poll();

                if (currentNode.left != null && !seen.contains(currentNode.left)) {
                    seen.add(currentNode.left);
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null && !seen.contains(currentNode.right)) {
                    seen.add(currentNode.right);
                    queue.offer(currentNode.right);
                }

                Node<Integer> parentOfCuurentNOde = nodeToParentMap.get(currentNode);
                if (parentOfCuurentNOde != null && !seen.contains(parentOfCuurentNOde)) {
                    seen.add(parentOfCuurentNOde);
                    queue.offer(parentOfCuurentNOde);
                }


            }
            currentLayer++;
        }
        return new ArrayList<>();

    }

    private static List<Integer> extractLayerFromQueue(Queue<Node<Integer>> queue) {
        List<Integer> extractedList = new ArrayList<>();
        for (Node<Integer> node: queue) {
            extractedList.add(node.data);
        }
        return extractedList;
    }

    public static void main(String[] args)
    {

        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);
        root.right.left.left = new Node<>(18);

        int dist = 2;
        distanceK(root, root.left,dist).forEach(System.out::println);
    }
}
