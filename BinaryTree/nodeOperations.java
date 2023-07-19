package BinaryTree;

//CountNode, SumOfNode, HeightOfNode, DiameterOfNode, MaxOfNode, MinOfNode, SearchNode, InsertNode, DeleteNode
public class nodeOperations {

    static class Node{
        int data;
        Node left, right;
        public Node(int item){
            data = item;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public Node BuildTree(int[] node){
            idx++;
            if(idx>= node.length || node[idx] == -1){
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = BuildTree(node);
            newNode.right = BuildTree(node);
            return newNode;
        }
    }

    public static void main(String[] args) {
        int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.BuildTree(node);
        System.out.println("Count of Nodes: " + getNodeCount(root));
        System.out.println("Sum of Nodes: " + getNodeSum(root));
        System.out.println("Height of Nodes: " + getNodeHeight(root));
        //System.out.println("Diameter of Nodes: " + getNodeDiameter());

    }

    static int getNodeCount(Node node){
        if(node == null){
            return 0;
        }
        int leftNode = getNodeCount(node.left);
        int rightNode = getNodeCount(node.right);
        return leftNode + rightNode + 1;
    }

    static int getNodeSum(Node node){
        if(node == null){
            return 0;
        }
        int leftSum = getNodeSum(node.left);
        int rightSum = getNodeSum(node.right);
        return leftSum + rightSum + node.data;
    }

    static int getNodeHeight(Node node){
        if(node == null){
            return 0;
        }
        int leftHeight = getNodeHeight(node.left);
        int rightHeight = getNodeHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /*static int getNodeDiameter(Node node){
        
    }*/

}
