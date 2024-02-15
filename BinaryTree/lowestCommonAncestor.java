package BinaryTree;

public class lowestCommonAncestor {

    static boolean visited1 = false, visited2 = false;

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

    public static void main(String[] args) {
        int[] node = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(node);
        Node lca = getLowestCommonAncestor(root, 4,5);
        if(visited1 & visited2){
            System.out.println(lca.data);
        } else {
            System.out.println("Not Found");
        }
    }

    static Node getLowestCommonAncestor(Node node, int num1, int num2) {
        //Base Case
        if(node == null){
            return null;
        }

        // Store result in temp, in case of key match so
        // that we can search for other key also.
        Node temp = null;

        // If either n1 or n2 matches with root's key,
        // report the presence by setting v1 or v2 as true
        // and return root (Note that if a key is ancestor
        // of other, then the ancestor key becomes LCA)
        if (node.data == num1) {
            visited1 = true;
            temp = node;
        }
        if (node.data == num2) {
            visited2 = true;
            temp = node;
        }

        // Look for keys in left and right subtrees
        Node left_lca = getLowestCommonAncestor(node.left, num1, num2);
        Node right_lca = getLowestCommonAncestor(node.right, num1, num2);

        if (temp != null)
            return temp;

        // If both of the above calls return Non-NULL, then
        // one key is present in once subtree and other is
        // present in other, So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;

        // Otherwise check if left subtree or right subtree
        // is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
}
