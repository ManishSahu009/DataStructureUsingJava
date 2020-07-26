package org.ms.ds.tree;

public class IdenticalTreesWithRecursion {

    static boolean  isIdentical(Node tree1,Node tree2){
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
        Node<Integer> x = new Node<>(15);
        x.left = new Node(10);
        x.right = new Node(20);
        x.left.left = new Node(8);
        x.left.right = new Node(12);
        x.right.left = new Node(16);
        x.right.right = new Node(25);


        Node y = new Node(15);
        y.left = new Node(10);
        y.right = new Node(20);
        y.left.left = new Node(8);
        y.left.right = new Node(12);
        y.right.left = new Node(16);
        y.right.right = new Node(25);

        System.out.println("===> "+ isIdentical(x,y));
    }
}
