package Interview;

import java.util.*;

public class CheckPolygon {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", Arrays.asList("B"));
        map.put("B", Arrays.asList("C","A"));
        map.put("C", Arrays.asList("D"));
        map.put("D", Arrays.asList("B"));
        map.put("E", Arrays.asList("A"));

        int n = 5;
        try {
            System.out.println(checkIfPolygon(map, n));
        } catch (InvalidInputException e) {
            System.out.println("Exception: " + e.toString());
        }
    }

    static boolean checkIfPolygon(Map<String, List<String>> map, int polygonSides) throws InvalidInputException {
        validateInput(map, polygonSides);
        return checkIfPolygonPossible(map, polygonSides, new ArrayList<>(),0, map.keySet().toArray()[0].toString());
    }

    static void validateInput(Map<String, List<String>> map, int polygonSides) throws InvalidInputException {
        //Invalid Input Handling
        if(map.size() != polygonSides) {
            throw new InvalidInputException("Number of Polygon side not matching input map count");
        }
        //Base Condition
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            if(entry.getValue().isEmpty()) {
                throw new InvalidInputException("No vertex connection for the map entry : " + entry);
            }
            for(String value: entry.getValue()) {
                if(!map.containsKey(value)) {
                    throw new InvalidInputException("No vertex found for map containing value" + value);
                }
            }
        }
    }

    static boolean checkIfPolygonPossible(Map<String, List<String>> map, int polygonSides, List<String> visitedNodes, int currentNodeCount, String currentNode) {
        //Base Condition
        if(currentNodeCount == polygonSides) {
            if(currentNode.equals(visitedNodes.get(0))) {
                return true;
            } else {
                return false;
            }
        }
        currentNodeCount++;

        for(String value: map.get(currentNode)) {
            if(!visitedNodes.contains(currentNode)) {
                visitedNodes.add(currentNode);
                return checkIfPolygonPossible(map, polygonSides, visitedNodes, currentNodeCount, value);
            }
        }
        return false;
    }

}