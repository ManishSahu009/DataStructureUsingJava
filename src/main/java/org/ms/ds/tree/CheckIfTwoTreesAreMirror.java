package org.ms.ds.tree;

public class CheckIfTwoTreesAreMirror {

    private static boolean areMirror(Node<Integer> a, Node<Integer> b) {
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

        if (areMirror(a, b) == true)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

}
