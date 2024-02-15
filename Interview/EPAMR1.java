/*
package Interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EPAMR1 {

*/
/*               1
                       2            3
                       4      5.     6.     7
                       8.       9.  10.     11.    12

    output - 1 3 2 4 5 6 7 12 11 10 9 8*//*


// Online Java Compiler
// Use this editor to write, compile and run your Java code online

//Zig zag traversal in BInary Tree

//                    1
//             2            3
            //       4      5.     6.     7
            // 8.       9.  10.     11.    12
//output - 1 3 2 4 5 6 7 12 11 10 9 8


// boolean leftToRight
// arraylist -[2,3] if false,
    class HelloWorld {
        public static class Node {
            int data;
            Node left, right;

            public Node (int data) {
                this.data = data;
                left = null;
                right = null;
            }
        }

        static Node newNode(int data) {
            Node node = new Node(data);
            return node;
        }

        //   1
        // 2   3
//.   4 5 6 7
        public static void main(String[] args) {
            Node root = newNode(1);
            root.right = newNode(3);
            root.left = newNode(2);

            root.right.right = newNode(7);
            root.right.left = newNode(6);
            root.left.right = newNode(5);
            root.left.left = newNode(4);

            List<Integer> result = getZigZag(root);
            result.forEach(n-> System.out.println(n));
        }

        static List<Integer> getZigZag(Node root) {
            List<Integer> result = new ArrayList<>();
            if(root == null){
                return result;
            }

            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            boolean leftToRight = true;
            //verify
            while(queue.size() > 0) {
                List<Integer> temp = new ArrayList<>();
                for(int i=0; i<queue.size(); i++) {
                    Node curr = queue.poll();
                    if(curr.left != null) {
                        queue.add(curr.left);
                    }
                    if(curr.right != null) {
                        queue.add(curr.right);
                    }
                    temp.add(curr.data);
                }
                if(!leftToRight) {
                    Collections.reverse(temp);
                }
                for(int i=0; i<temp.size(); i++) {
                    result.add(temp.get(i));
                }
                leftToRight = !leftToRight;
            }
            return result;
        }
    }
    */
/*Given an array of strings, group the anagrams together
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]*//*



    class HelloWorld {
        public static void main(String[] args) {
            String[] input = {"eat","tea","tan","ate","nat","bat"};
            List<List<String>> result = getGroupedAnagrams(input);

            System.out.println(result);
        }
        //O(N*KLogK)
        static List<List<String>> getGroupedAnagrams(String[] input) {
            Map<String, List<String>> resultMap = new HashMap<>();
            for(String str: input) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String orderedStr = new String(chars);
                if(!resultMap.containsKey(orderedStr)){
                    resultMap.put(orderedStr, new ArrayList<>());
                }
                resultMap.get(orderedStr).add(str);
            }
            return new ArrayList(resultMap.values());
        }
    }

    class HelloWorld {
        public static void main(String[] args) {
            String input = "java";
            getCharFreq(input);
        }

        static Map<Character, Integer> getCharFreq(String input) {
            Map<Character, Integer> charFreqMap = input.chars()
                    .mapToObj(c -> (char)c)
                    .collect(Collections.groupingBy(Function.identity(), Collectors.counting()));

            charFreqMap.forEach((character, freq) -> System.out.println(character + " " + freq));
        }
    }




    class HelloWorldTest {
        @Test
        public void testCharFreq() {
            String input = "java";
            Map<Character, Integer> charFreqMap = getCharFreq(input);

            assertEquals(2, charFreqMap.get('a'));
            assertEquals(1, charFreqMap.get('j'));
            assertEquals(1, charFreqMap.get('v'));
        }
    }
}
}
*/
