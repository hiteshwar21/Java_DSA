package BinaryTree;

public class dfsBinaryTreeTraversals {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int item) {
            data = item;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node createTree(int[] nodes) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = createTree(nodes);
            newNode.right = createTree(nodes);
            return newNode;
        }

        public void printPreOrder(Node node){
            if(node == null){
                return;
            }
            System.out.println(node.data + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }

        public void printPostOrder(Node node){
            if(node == null){
                return;
            }
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.println(node.data + " ");
        }

        public void printInOrder(Node node){
            if(node == null){
                return;
            }
            printInOrder(node.left);
            System.out.println(node.data + " ");
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createTree(node);
        //Simply printing root after creating a Binary Tree
        System.out.println("Printing Root : " + root.data);

        //PreOrder Traversal
        binaryTree.printPreOrder(root);
        //PostOrder Traversal
        binaryTree.printPostOrder(root);
        //InOrder Traversal
        binaryTree.printInOrder(root);
    }
}
