package com.avl_trees;

public class AVLTree {
    private class AVLNode{
        private final int value;
        private int height;
        private AVLNode left;
        private AVLNode right;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private AVLNode root;

    public void insert(int value){
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value){
        if (root == null)
            return new AVLNode(value);
        if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        setHight(root);

        return balance(root);
    }

    private AVLNode rotateLeft(AVLNode node){
        var newRoot = node.right;
        root.right = newRoot.left;
        newRoot.left = root;
        setHight(newRoot);
        setHight(root);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode node){
        var newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        setHight(newRoot);
        setHight(root);

        return newRoot;
    }

    private void setHight(AVLNode node){
        node.height = Math.max(height(root.left), height(root.right)) + 1;
    }

    private AVLNode balance(AVLNode node){
        if(isLeftHeavy(node)){
            if(balanceFactor(node.left) < 0)
                root.left = rotateLeft(node.left);
            return rotateRight(node);
        } else if(isRigthHeavy(node)){
            if(balanceFactor(node.right) > 0)
               root.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    private int balanceFactor(AVLNode root) {
        return (root == null) ? 0 : height(root.left) - height(root.right);
    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }

    private boolean isRigthHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int height(AVLNode node){
        return (node == null) ? -1 : node.height;
    }
}
