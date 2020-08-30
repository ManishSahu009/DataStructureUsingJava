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
https://www.techiedelight.com/construct-binary-tree-from-inorder-postorder-traversals/
*/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBTUsingPostorderInorder {

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }


    public static TreeNode<Integer> construct(int start, int end,
                                              int[] postorder, AtomicInteger pIndex,
                                              Map<Integer, Integer> map) {
        if(start>end){
            return null;
        }
        TreeNode root=new TreeNode(postorder[pIndex.getAndDecrement()]);

        int index=map.get(root.data);

        root.right=construct(index+1,end,postorder,pIndex,map);
        root.left=construct(start,index-1,postorder,pIndex,map);

        return root;

    }


    public static TreeNode<Integer> construct(int[] inorder, int[] postorder)
    {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i< inorder.length;i++){
            map.put(inorder[i],i);
        }
        // pIndex stores index of next unprocessed node in preorder sequence
        // start with root node (present at 0'th index)
        AtomicInteger postIndex=new AtomicInteger(postorder.length-1);
        return construct(0,inorder.length-1,postorder,postIndex,map);
    }


    public static void main(String[] args) {
        int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
        int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1 };


        TreeNode root = construct(inorder, postorder);

        // traverse the constructed tree
        System.out.print("Inorder  : ");
        inorderTraversal(root);

        System.out.print("\nPostorder : ");
        postorderTraversal(root);
    }
}
