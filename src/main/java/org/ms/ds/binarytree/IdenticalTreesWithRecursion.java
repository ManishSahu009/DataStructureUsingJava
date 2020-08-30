package org.ms.ds.binarytree;

public class IdenticalTreesWithRecursion {

    static boolean  isIdentical(TreeNode tree1, TreeNode tree2){
        if(tree1 == null && tree2==null){
            return true;
        }
        if((tree1 == null && tree2 !=null) || (tree2 == null && tree1 !=null)){
            return false;
        }
        boolean ltree=isIdentical(tree1.left , tree2.left);
        boolean rtree=isIdentical(tree1.right , tree2.right);
        return tree1.data==tree2.data && ltree && rtree ;
    }

    public static void main(String[] args) {
        TreeNode<Integer> x = new TreeNode<>(15);
        x.left = new TreeNode(10);
        x.right = new TreeNode(20);
        x.left.left = new TreeNode(8);
        x.left.right = new TreeNode(12);
        x.right.left = new TreeNode(16);
        x.right.right = new TreeNode(25);


        TreeNode y = new TreeNode(15);
        y.left = new TreeNode(10);
        y.right = new TreeNode(20);
        y.left.left = new TreeNode(8);
        y.left.right = new TreeNode(12);
        y.right.left = new TreeNode(16);
        y.right.right = new TreeNode(25);

        System.out.println("===> "+ isIdentical(x,y));
    }
}
