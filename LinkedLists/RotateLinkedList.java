package LinkedLists;

import java.util.LinkedList;

/*Given a singly linked list, The task is to rotate the linked list counter-clockwise by k nodes.

        Examples:

        Input: linked list = 10->20->30->40->50->60, k = 4
        Output: 50->60->10->20->30->40.
        Explanation: k is smaller than the count of nodes in a linked list so (k+1 )th node i.e. 50 becomes the head node and 60’s next points to 10

        Input: linked list = 30->40->50->60, k = 2
        Output: 50->60->30->40.*/
public class RotateLinkedList {

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
        for(int i=0;i<8;i++){
            pushNodeAtStart(i);
        }
        rotateByIndex(4);
        printLinkedList();
    }

    static void rotateByIndex(int index){
        int count = 0;
        Node curr = head;
        while (count<index){
            curr = curr.next;
            count++;
        }
        Node strIdx = curr;
        while (curr.next!=null){
            curr = curr.next;
        }
        curr.next = head;
        head = strIdx.next;
        strIdx.next = null;
    }
}
