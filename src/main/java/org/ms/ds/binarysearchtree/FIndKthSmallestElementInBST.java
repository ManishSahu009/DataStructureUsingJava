package org.ms.ds.binarysearchtree;


import org.ms.ds.binarytree.TreeNode;

/* Consider below tree
				  3
			   /	 \
			  1	      4
			   \
			    2

*/
public class FIndKthSmallestElementInBST {

   public static int kthsmallest(TreeNode<Integer> rooot, int k){
       int []nums=new int[2];
       inorder(rooot,k,nums);
       return nums[1];
   }

   public static void inorder(TreeNode<Integer> rooot, int k, int []nums){
       if(rooot==null){
           return;
       }
       inorder(rooot.left,k,nums);
        if(++nums[0] == k){
            nums[1]=rooot.data;
            return;
        }
       inorder(rooot.right,k,nums);

   }

    public static void main(String[] args)
    {

        TreeNode<Integer> root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);


        System.out.println("Kth smallest element"+kthsmallest(root,3));
    }


}
