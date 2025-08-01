package EPAMCoding;

//Given a dictionary and an array.
// Filter items of dictionary based on array to create a menu for restuarant.

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
    Double price = null;
}

class TrieClass {
    private final TrieNode root = new TrieNode();

    public void insert(String word, double price) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isEndOfWord = true;
        node.price = price;
    }

    public Double search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return null;
        }
        return node.isEndOfWord ? node.price : null;
    }
}

public class FetchAndFilter {
    public static void main(String[] args) {
        // Step 1: Build the Trie from all available items
        TrieClass menuTrieClass = new TrieClass();
        menuTrieClass.insert("Burger", 5.99);
        menuTrieClass.insert("Pizza", 8.99);
        menuTrieClass.insert("Pasta", 7.49);
        menuTrieClass.insert("Salad", 4.99);
        menuTrieClass.insert("Sushi", 12.50);

        // Step 2: Desired menu items
        List<String> desiredItems = Arrays.asList("Pizza", "Pasta", "Sushi", "Ramen");

        // Step 3: Filtered menu
        Map<String, Double> filteredMenu = new LinkedHashMap<>();
        for (String item : desiredItems) {
            Double price = menuTrieClass.search(item);
            if (price != null) {
                filteredMenu.put(item, price);
            }
        }

        // Step 4: Display final filtered menu
        System.out.println("Filtered Restaurant Menu:");
        for (Map.Entry<String, Double> entry : filteredMenu.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }
}

