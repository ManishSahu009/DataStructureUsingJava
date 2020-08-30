package org.ms.ds.binarytree;

public class CheckIfTwoTreesAreMirror {

    private static boolean areMirror(TreeNode<Integer> a, TreeNode<Integer> b) {
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null){
           return false;
        }

        return a.data==b.data
                && areMirror(a.left,b.right)
                && areMirror(a.right,b.left);
    }

    public static void main(String[] args) {
        TreeNode<Integer> a = new TreeNode<>(1);
        a.left = new TreeNode<>(2);
        a.right = new TreeNode<>(3);
        a.left.left = new TreeNode<>(4);
        a.left.right = new TreeNode<>(5);

        TreeNode<Integer> b = new TreeNode<>(1);
        b.left = new TreeNode<>(3);
        b.right = new TreeNode<>(2);
        b.right.left = new TreeNode<>(5);
        b.right.right = new TreeNode<>(4);

        if (areMirror(a, b) == true)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

}
