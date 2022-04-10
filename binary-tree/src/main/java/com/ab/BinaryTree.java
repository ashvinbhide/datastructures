package com.ab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    public void addNodeLevelOrder(int data) {

        Queue<Node> q = new LinkedList<Node>();
        if (null == root) {
            root = new Node(data);
            return ;
        }
        q.add(root);
        while(!q.isEmpty()) {
            Node cNode = q.remove();
            if(null ==cNode.getLeft()) {
                cNode.setLeft(new Node(data));
                return;
            }
            else {
                q.add(cNode.getLeft());
            }
            if(null == cNode.getRight()) {
                cNode.setRight(new Node(data));
                return;
            }
            else {
                q.add(cNode.getRight());
            }
        }
    }

    public void preorderRecursive(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.getData()+" ");
        preorderRecursive(root.getLeft());
        preorderRecursive(root.getRight());
    }

    public List<Integer> preorderTraversal(Node root) {

        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.add(root.getData());
        if(null != root.getLeft()) {
            result.addAll(preorderTraversal(root.getLeft()));
        }
        if(null != root.getRight()) {
            result.addAll(preorderTraversal(root.getRight()));
        }
        return result;
    }
    public void inorderRecursive(Node root) {
        if(root == null) {
            return;
        }

        inorderRecursive(root.getLeft());
        System.out.print(root.getData()+" ");
        inorderRecursive(root.getRight());
    }

    public void postorderRecursive(Node root) {
        if(root == null) {
            return;
        }

        postorderRecursive(root.getLeft());
        postorderRecursive(root.getRight());
        System.out.print(root.getData()+" ");
    }

    public void levelOrder(Node root) {
        if(null ==root) {
            System.out.println("Empty tree!!!!");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cNode = q.remove();
            System.out.print(cNode.getData()+"  ");
            if (null != cNode.getLeft()) {
                q.add(cNode.getLeft());
            }
            if (null != cNode.getRight()) {
                q.add(cNode.getRight());
            }
        }
    }

    public boolean isSymmetric() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.setLeft(new Node(2));
        tree.root.setRight( new Node(2));
        tree.root.getLeft().setLeft(new Node(3));
        tree.root.getLeft().setRight( new Node(4));
        tree.root.getRight().setLeft(new Node(4));
        tree.root.getRight().setRight( new Node(3));

        return isMirror(tree.root,tree.root);
    }

    private boolean isMirror(Node left, Node right){
        if(left == null && right == null) {
            return true ;
        }

       /*
       For two trees to be mirror images, the following three conditions must be true
        1 - Their root node's key must be same
        2 - left subtree of left tree and right subtree of right tree have to be mirror images
        3 - right subtree of left tree and left subtree of right tree have to be mirror images
        */

        if( (null != left && null != right) && (left.getData() == right.getData()) ) {

            return isMirror(left.getLeft(),right.getRight()) && isMirror(left.getRight(),right.getLeft());

        }
        return false;

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        for (int  i=1;i<11;i++) {
            binaryTree.addNodeLevelOrder(i);
        }
        System.out.println("\n===================preorder========================");
        binaryTree.preorderRecursive(binaryTree.root);
        System.out.println("\n===================pre order return list========================");
        List<Integer> list = binaryTree.preorderTraversal(binaryTree.root);
        System.out.println(list.toString());
        System.out.println("\n===================inorder========================");
        binaryTree.inorderRecursive(binaryTree.root);
        System.out.println("\n===================postorder========================");
        binaryTree.postorderRecursive(binaryTree.root);
        System.out.println("\n===================level order========================");
        binaryTree.levelOrder(binaryTree.root);
        System.out.println("\n===================is Symmetric========================");
        System.out.println(binaryTree.isSymmetric());
    }
}
