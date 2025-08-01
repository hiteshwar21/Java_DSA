package EPAMCoding;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class VerticalTraversal {

    static class NodePosition {
        TreeNode node;
        int horizontalDistance;
        int level;

        NodePosition(TreeNode node, int hd, int level) {
            this.node = node;
            this.horizontalDistance = hd;
            this.level = level;
        }
    }

    public static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<NodePosition> queue = new LinkedList<>();

        queue.add(new NodePosition(root, 0, 0));

        while (!queue.isEmpty()) {
            NodePosition current = queue.poll();
            map.putIfAbsent(current.horizontalDistance, new TreeMap<>());
            TreeMap<Integer, List<Integer>> levelMap = map.get(current.horizontalDistance);
            levelMap.putIfAbsent(current.level, new ArrayList<>());
            levelMap.get(current.level).add(current.node.val);

            if (current.node.left != null)
                queue.add(new NodePosition(current.node.left, current.horizontalDistance - 1, current.level + 1));
            if (current.node.right != null)
                queue.add(new NodePosition(current.node.right, current.horizontalDistance + 1, current.level + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> levelMap : map.values()) {
            List<Integer> vertical = new ArrayList<>();
            for (List<Integer> nodes : levelMap.values()) {
                vertical.addAll(nodes);
            }
            result.add(vertical);
        }

        return result;
    }
}
