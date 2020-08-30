package org.ms.ds.binarytree;

public class BinarySearchTree {


    public void searchRecursoin(TreeNode<Integer> root, int key, TreeNode<Integer> parent) {
        if (root == null) {
            System.out.println("Key not found..");
        }
        if (root.data == key) {
            if (parent == null) {
                System.out.print("The node with key " + key + " is root node");
            } else if (key < parent.data) {
                System.out.print("Given key is left node of node with key "
                        + parent.data);
            } else {
                System.out.print("Given key is right node of node with key "
                        + parent.data);
            }

            return;
        }
        if (key < root.data) {
            searchRecursoin(root.left, key, root);
        } else {
            searchRecursoin(root.right, key, root);
        }
    }

    public void searchIterative(TreeNode<Integer> root, int key) {
        TreeNode<Integer> current = root;
        TreeNode<Integer> parent = null;
        while (current != null && current.data != key) {
            parent = current;
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            System.out.println("Key not found..");
            return;
        }
        if (parent == null) {
            System.out.println("Node with key" + key + " is root node");
        } else if (key < parent.data) {
            System.out.print("Given key is left node of node with key "
                    + parent.data);
        } else {
            System.out.print("Given key is right node of node with key "
                    + parent.data);
        }

    }

    public TreeNode<Integer> insertRecursion(TreeNode<Integer> root, int key) {
        if (root == null) {
            return new TreeNode<>(key);
        }
        if (root.data > key) {
            root.left = insertRecursion(root.left, key);
        } else {
            root.right = insertRecursion(root.right, key);
        }
        return root;
    }

    public TreeNode<Integer> insertIterative(TreeNode<Integer> root, int key) {
        TreeNode<Integer> current = root;
        TreeNode<Integer> parent = root;
        if (root == null) {
            return new TreeNode<>(key);
        }
        while (current != null) {
            parent = current;
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (key < parent.data) {
            parent.left = new TreeNode<>(key);
        } else {
            parent.right = new TreeNode<>(key);
        }
        return root;
    }

    public TreeNode<Integer> deleteRecursion(TreeNode<Integer> root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = deleteRecursion(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRecursion(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right != null) { // either inorder predecessor or successor
                TreeNode<Integer> predecessor = maximumKey(root.left);
                root.data = predecessor.data;
                root.left = deleteRecursion(root.left, predecessor.data);
            } else {
                TreeNode<Integer> child = (root.left != null) ? root.left : root.right;
                root = child;
            }
        }
        return root;
    }

    public TreeNode<Integer> deleteIterative(TreeNode<Integer> root, int key) {
        TreeNode<Integer> parent = null;
        TreeNode<Integer> current = root;

        while (current != null && current.data != key) {
            parent = current;
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return root;
            }
            //node with no child
            if (current.left == null && current.right == null) {
                if (current != root) {
                    if (parent.left == current) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else {
                    root = null;
                }
            } else if (current.left != null && current.right != null) { // node have 2 child
                TreeNode<Integer> successor = minimumKey(current.right);
                int val = successor.data;
                deleteIterative(root, successor.data);
                current.data = val;

            } else {
                TreeNode<Integer> child = (current.left != null) ? current.left : current.right;
                if (current != root) {
                    if (current == parent.left) {
                        parent.left = child;
                    } else {
                        parent.right = child;
                    }
                }

                // if node to be deleted is root node, then set the root to child
                else {
                    root = child;
                }
            }
        }

        return root;

    }

    public TreeNode<Integer> maximumKey(TreeNode<Integer> temp) {
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public TreeNode<Integer> minimumKey(TreeNode<Integer> temp) {
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public void inorderTraversalRecusion(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inorderTraversalRecusion(root.left);
        System.out.print(root.data + " ");
        inorderTraversalRecusion(root.right);
    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode<Integer> root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 18, 25};

        for (int key : keys) {
            root = binarySearchTree.insertIterative(root, key);
        }
        binarySearchTree.inorderTraversalRecusion(root);
        binarySearchTree.deleteRecursion(root, 18);
        System.out.println();
        binarySearchTree.inorderTraversalRecusion(root);
        root = binarySearchTree.insertRecursion(root, 19);
        System.out.println();
        binarySearchTree.inorderTraversalRecusion(root);
        //binarySearchTree.deleteIterative(root,19);
        binarySearchTree.searchRecursoin(root, 10, null);
        System.out.println();
        binarySearchTree.inorderTraversalRecusion(root);
    }

}
