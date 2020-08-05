package org.ms.ds.tree;

public class CheckIfTwoTreesAreIsomorphic {

    private static boolean areIsomorphic(Node<Integer> a, Node<Integer> b) {
        if(a == null && b == null ){
            return true;
        }
        if(a == null || b == null ){
            return false;
        }
        if(a.data!=b.data){
            return false;
        }
        return areIsomorphic(a.left,b.left) && areIsomorphic(a.right , b.right)
                || areIsomorphic(a.left,b.right) && areIsomorphic(a.right , b.left);
    }
    public static void main(String[] args) {
        Node<Integer> a = new Node<>(1);
        a.left = new Node<>(2);
        a.right = new Node<>(3);
        a.left.left = new Node<>(4);
        a.left.right = new Node<>(5);

        Node<Integer> b = new Node<>(1);
        b.left = new Node<>(3);
        b.right = new Node<>(2);
        b.right.left = new Node<>(5);
        b.right.right = new Node<>(4);

        if (areIsomorphic(a, b) == true)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
