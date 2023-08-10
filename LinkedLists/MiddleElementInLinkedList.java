package LinkedLists;

public class MiddleElementInLinkedList {

    static util.Node head;

    public static void main(String[] args) {
        for (int i = 6; i > 0; --i) {
            push(i);
        }
        printMiddle();
    }

    public static void push(int data)
    {
        util.Node newNode = new util.Node(data);
        newNode.next = head;
        head = newNode;
    }

    static void printMiddle(){
        if(head == null){;
            System.out.println("Ain't no Middle here");
        }
        util.Node slowNode = head;
        util.Node fastNode = head;
        while (fastNode.next != null && fastNode.next.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        System.out.println("Middle Element is  - " +  slowNode.data);
    }
}
