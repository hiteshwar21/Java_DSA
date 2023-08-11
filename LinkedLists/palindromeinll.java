package LinkedLists;

public class palindromeinll {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node head, curr;
    static void pushInList(int data){
        Node newNode = new Node(data);
        if(head== null){
            head = newNode;
            curr = head;
        } else {
            curr.next = newNode;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        pushInList(1);
        pushInList(2);
        pushInList(1);
        printLinkedList();
        System.out.println(checkPalindrome(head));
    }

    static void printLinkedList(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    static Boolean checkPalindrome(Node node){
        Node slowPointer = node, fastPointer = node;
        if(node==null || node.next==null){
            System.out.println("Not possible");
            return false;
        }
        while (fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        Node secondPointer = slowPointer.next;
        if(fastPointer==null){
            secondPointer = slowPointer;
        }

        reverseLinkedList(secondPointer);
        return checkLinkedListForEquality(secondPointer);
     }

     static void reverseLinkedList(Node node){
        if(node==null){
            return;
        }
        Node prev = null, next = null, current = node;
        while (current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        prev.next = null;
     }

     static boolean checkLinkedListForEquality(Node secondPointer){
        Node temp = head;
        while (secondPointer!=null){
            if(temp.data != secondPointer.data){
                return false;
            }
            temp = temp.next;
            secondPointer = secondPointer.next;
        }
        return true;
     }

}
