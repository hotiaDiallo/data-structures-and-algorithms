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


}
