package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class rightViewBinaryTree {
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx =-1;
        static Node buildTree(int[] node){
            idx++;
            if(idx > node.length || node[idx] == -1){
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(arr);
        printLevelOrder(root);
        rightViewBinaryTree(root);
    }

    static void printLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.left != null) {
                    queue.add(curr.right);
                }
                System.out.print(curr.data + " ");
            }
        }
    }

    static void rightViewBinaryTree(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0 ; i<size; i++) {
                Node curr = queue.poll();
                if (i == size - 1) {
                    System.out.print(curr.data);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }
}
