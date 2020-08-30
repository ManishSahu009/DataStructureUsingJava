package org.ms.ds.binarytree;

/* Consider below tree
				  1
				/   \
			   /	 \
			  2	   3
			 /	   / \
			/	   /   \
		   4	   5	 6
				  / \
				 /   \
				7	 8
https://www.techiedelight.com/construct-binary-tree-from-inorder-preorder-traversal/
*/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBTUsingPreorderInorder {

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


    public static TreeNode<Integer> construct(int start, int end,
                                              int[] preorder, AtomicInteger pIndex,
                                              Map<Integer, Integer> map) {
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(preorder[pIndex.getAndIncrement()]);

        int index=map.get(root.data);

        root.left=construct(start,index-1,preorder,pIndex,map);
        root.right=construct(index+1,end,preorder,pIndex,map);
        return root;

    }


    public static TreeNode<Integer> construct(int[] inorder, int[] preorder)
    {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i< inorder.length;i++){
            map.put(inorder[i],i);
        }
        // pIndex stores index of next unprocessed node in preorder sequence
        // start with root node (present at 0'th index)
        AtomicInteger preIndex=new AtomicInteger(0);
        return construct(0,inorder.length-1,preorder,preIndex,map);
    }


    public static void main(String[] args) {
        int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
        int[] preorder = { 1, 2, 4, 3, 5, 7, 8, 6 };

        TreeNode root = construct(inorder, preorder);

        // traverse the constructed tree
        System.out.print("Inorder  : ");
        inorderTraversal(root);

        System.out.print("\nPreorder : ");
        preorderTraversal(root);
    }
}
