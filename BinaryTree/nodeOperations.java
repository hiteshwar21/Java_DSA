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
        public Node buildTree(int[] node){
            idx++;
            if(idx>= node.length || node[idx] == -1){
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }
    }

    public static void main(String[] args) {
        int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(node);
        System.out.println("Count of Nodes: " + getNodeCount(root));
        System.out.println("Sum of Nodes: " + getNodeSum(root));
        System.out.println("Height of Nodes: " + getNodeHeight(root));
        System.out.println("Diameter of Nodes: " + getNodeDiameter(root));
        System.out.println("Max of Node: ");
        System.out.println("Min of Node: ");
        System.out.println("Search in Node: ");
        System.out.println("Insert in Node: ");
        System.out.println("Delete in Node: ");
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

    static int getNodeDiameter(Node node){
        int diameter = 0;
        if(node == null){
            return diameter;
        }
        int lHeight = getNodeHeight(node.left);
        int rHeight = getNodeHeight(node.right);
        int lDiameter = getNodeDiameter(node.left);
        int rDiameter = getNodeDiameter(node.right);
        return Math.max(lHeight + rHeight + 1,
                Math.max(lDiameter, rDiameter));
    }

}
