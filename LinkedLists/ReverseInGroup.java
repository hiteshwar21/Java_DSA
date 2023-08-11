package LinkedLists;

/*Given a linked list, write a function to reverse every k nodes (where k is an input to the function).*/
public class ReverseInGroup {

    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    static Node head;

    static void printLinkedList(){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.print("null");
    }

    static void pushNodeAtStart(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public static void main(String[] args) {
        for(int i=9;i>0;i--){
            pushNodeAtStart(i);
        }
        printLinkedList();
        System.out.println();
        head = reverseInGroupRecursive(head,3);
        printLinkedList();

        head = reverseInGroupIterative(head,3);
        printLinkedList();
    }

    static Node reverseInGroupRecursive(Node node, int size){
        if(node == null){
            return null;
        }
        Node prev = null;
        Node next = null;
        Node curr = node;
        int count = 0;
        while (count<size && curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next!=null){
            node.next = reverseInGroupRecursive(next, size);
        }
        return prev;
    }

    static Node reverseInGroupIterative(Node node, int size){
        if(head == null || head.next == null){
            return node;
        }
        return node;
    }
}
