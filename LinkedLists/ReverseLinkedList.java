package LinkedLists;

import java.util.Stack;

public class ReverseLinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static void pushNodeAtStart(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    static void printLinkedList(){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.print("null");
    }


    public static void main(String[] args) {
        for(int i=0;i<8;i++){
            pushNodeAtStart(i);
        }
        printLinkedList();


        reverseLinkedListPushingAtStart(); // Time - O(N), Space - O(1)
        System.out.println();
        printLinkedList();


        reverseLinkedListIterate();
        System.out.println();
        printLinkedList();

        Node node = revereLinkedListRecursive(head);
        head = node;
        System.out.println();
        printLinkedList();
    }

    static void reverseLinkedListPushingAtStart(){
        Node curr = head;
        head = null;
        while (curr!=null){
            pushNodeAtStart(curr.data);
            curr = curr.next;
        }
    }

    static void reverseLinkedListIterate(){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    static Node revereLinkedListRecursive(Node node){
        if (node == null || node.next == null){
            return node;
        }
        Node rest = revereLinkedListRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }

}
