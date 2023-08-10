package LinkedLists;

public class LLImpl {
    static class Node{
        String data;
        Node next;

        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    public static void main(String[] args) {
        addFirst("is");
        addLast("a");
        addFirst("This");
        addLast("LinkedList");

        printList();

        deleteFirst();
        deleteLast();

        printList();
    }

    static void addFirst(String data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    static void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else{
            Node lastNode = head;
            while (lastNode.next!=null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }

    static void printList(){
        if(head == null){
            return;
        } else {
            Node currNode = head;
            while (currNode!=null){
                System.out.print(currNode.data + "->");
                currNode = currNode.next;
            }
            System.out.println("null");
        }
    }

    static void deleteFirst(){
        if(head == null){
            System.out.println("Nothing To Delete");
        }
        head = head.next;
    }

    static void deleteLast(){
        if(head == null){
            System.out.println("Nothing To Delete");
        }
        Node prev = head;
        Node curr = prev.next;
        while (curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
    }
}
