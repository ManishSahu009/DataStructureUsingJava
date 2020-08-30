package org.ms.ds.binarytree;


import java.util.ArrayDeque;
import java.util.Deque;

public class IdenticalTreesWithIterative {

    static boolean  isIdentical(TreeNode tree1, TreeNode tree2){
        if(tree1 == null && tree2==null){
            return true;
        }
        if((tree1 == null && tree2 !=null) || (tree2 == null && tree1 !=null)){
            return false;
        }
        Deque<Pair<TreeNode, TreeNode>> stack= new ArrayDeque<>();
        stack.add(Pair.of(tree1,tree2));
        while(!stack.isEmpty()){
           tree1=stack.peekLast().first;
           tree2=stack.peekLast().second;
           stack.pollLast();

           if(tree1.data!=tree2.data){
               return false;
           }
           if(tree1.left !=null && tree2.left!=null){
               stack.add(Pair.of(tree1.left,tree2.left));
           }else if(tree1.left !=null || tree2.left!=null){
               return false;
           }
            if(tree1.right !=null && tree2.right!=null){
                stack.add(Pair.of(tree1.right,tree2.right));
            }else if(tree1.right !=null || tree2.right!=null){
                return false;
            }

        }
        return true;
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


