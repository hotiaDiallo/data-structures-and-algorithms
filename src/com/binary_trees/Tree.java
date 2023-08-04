package com.binary_trees;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node: " + value;
        }
    }

    private Node root;

    public void insert(int value){
        Node node = new Node(value);
        if(root == null){
            root = node;
            return;
        }
        var current = root;
        while (true){
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }else{
                if(current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        var current =  root;
        while (current != null){
            if(value < current.value)
                current = current.leftChild;
            else if(value > current.value)
                current = current.rightChild;
            else return true;
        }
        return false;
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node root){
        if (root == null)
            return;
        System.out.println(root);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root){
        if (root == null)
            return;
        preOrderTraversal(root.leftChild);
        System.out.println(root);
        preOrderTraversal(root.rightChild);
    }

    private void postOrderTraversal(Node root){
        if(root == null)
            return;
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
        System.out.println(root);
    }
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null)
            return -1;
        if(isLeaf())
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min(){
        return min(root);
    }

    //If not BST
    private int min(Node root){
        if (root == null)
            return Integer.MAX_VALUE;
        if(isLeaf())
            return root.value;
        var minLeft = min(root.leftChild);
        var minRight = min(root.rightChild);
        return Math.min(
                root.value,
                Math.min(minLeft, minRight)
        );
    }

    public Node minBST(){
        if(root == null)
            return null;
        var curr = root;
        while (curr.leftChild != null){
            curr = curr.leftChild;
        }
        return curr;
    }

    public boolean equal(Tree other){
        if (other == null)
            return false;

        return equal(root, other.root);
    }

    private boolean equal(Node first, Node second){
        if (first == null && second == null)
            return true;

        if(first != null && second != null)
            return first.value == second.value &&
                    equal(first.leftChild, second.leftChild) &&
                    equal(first.rightChild, second.rightChild);

        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null)
            return true;

        if(root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public void swap(){
        var tmp = root.rightChild;
        root.rightChild = root.leftChild;
        root.leftChild = tmp;
    }
    private boolean isLeaf(){
        return root.leftChild == null && root.rightChild == null;
    }


}
