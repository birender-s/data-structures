package com.example.java_lib.misc;

/*
https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
Binary Search Tree, is a node-based binary tree data structure which has the following properties:
The left subtree of a node contains only nodes with keys lesser than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
The left and right subtree each must also be a binary search tree.
There must be no duplicate nodes.
 */
public class BinarySearchTree {
    class Node{
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data){
            this.data=data;
            leftChild = rightChild = null;
        }
    }

    private Node root;
    BinarySearchTree(){ root = null;}

    public Node search(int data){
        return search(root, data);
    }

    private Node search(Node node, int data){
        if (null == node || node.data == data)
            return node;

        if (node.data > data)
            return search(node.leftChild, data);
        else
            return search(node.rightChild, data);
    }

    public void insert(int data){
        root = insert(root, data);
    }

    private Node insert(Node node, int data){
        if (node == null){
            node = new Node(data);
            return node;
        }

        if (node.data == data)
            return node;

        if (node.data > data)
            node.leftChild = insert(node.leftChild, data);
        else
            node.rightChild = insert(node.rightChild, data);

        return node;
    }

    public void inorder(){
        inorder(root);
    }

    private void inorder(Node root){
        if (null == root)
            return;

        inorder(root.leftChild);
        System.out.print(" " + root.data);
        inorder(root.rightChild);
    }


    public static void main (String [] args){

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inorder();
    }

}
