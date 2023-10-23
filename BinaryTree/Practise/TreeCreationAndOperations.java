package BinaryTree.Practise;

public class TreeCreationAndOperations {

    static class Node{
        int data;
        Node left, right;
        public Node(int item){
            this.data = item;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public Node buildTree(int[] node){
            idx++;
            if(idx> node.length || node[idx] == -1){
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }

        public void PrintPreOrder(Node node){
            if(node ==null){
                return;
            }
            System.out.print(node.data);
            PrintPreOrder(node.left);
            PrintPreOrder(node.right);
        }

        public void PrintInOrder(Node node){
            if(node == null){
                return;
            }
            PrintInOrder(node.left);
            System.out.print(node.data);
            PrintInOrder(node.right);
        }

        public void PrintPostOrder(Node node) {
            if(node == null){
                return;
            }
            PrintPostOrder(node.left);
            PrintPostOrder(node.right);
            System.out.print(node.data);
        }
    }

    public static void main(String[] args) {
        int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(node);
        System.out.println("PreOrder : ");
        binaryTree.PrintPreOrder(root);
        System.out.println("In Order : ");
        binaryTree.PrintInOrder(root);
        System.out.println("Post Order : ");
        binaryTree.PrintPostOrder(root);
    }
}
