package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {
    public static void main(String[] args) {
        int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(node);
        printLevelOrder(root);
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int item) {
            data = item;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int[] node) {
            idx++;
            if (idx > node.length || node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }
    }

    static void printLevelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                if (queue.isEmpty()) {
                    return;
                } else {
                    queue.add(null);
                    System.out.println();
                    continue;
                }
            }
            System.out.println(current.data);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
