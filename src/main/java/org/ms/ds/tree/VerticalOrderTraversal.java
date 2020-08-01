package org.ms.ds.tree;

/* Construct below tree
		          1
		        /   \
		       /     \
		      2       3
		            /   \
		           /     \
		          5       6
		        /   \
		       /     \
		      7       8
		            /   \
		           /     \
		          9      10

root =0
left=root-1
right=root+1

Horizontal distance :
-1 : [2,7]
0 : [1,5,9]
1 : [3,8]
2 : [10,6]

node with same HD will be counted in same vertical
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    public static void insertIntoMultiMap(Map<Integer,List<Integer>> map,
                                          Integer key, Integer value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    private static void printVertical(Node<Integer> root, int hdist, Map<Integer, List<Integer>> map) {

        if(root==null){
            return;
        }
        insertIntoMultiMap(map,hdist,root.data);
        printVertical(root.left,hdist-1,map);
        printVertical(root.right,hdist+1,map);

    }

    private static void printVertical(Node<Integer>  root) {
        Map<Integer,List<Integer>> map=new TreeMap<>();
        printVertical(root,0,map);
        map.forEach((k,v) -> System.out.println(k+"-->"+ v.toString()));

    }

    public static void main(String[] args)
    {

        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(6);
        root.right.left.left = new Node<>(7);
        root.right.left.right = new Node<>(8);
        root.right.left.right.left = new Node<>(9);
        root.right.left.right.right = new Node<>(10);
        printVertical(root);
    }


}
