package LinkedLists;

public class detectAndRemoveLoopInLL extends util {

    public static void main(String[] args) {
        detectAndRemoveLoopInLL detectAndRemoveLoopinLL = new detectAndRemoveLoopInLL();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        System.out.println(removeLoop(head));
    }

    static Node removeLoop(Node head){
        Node slow = head;
        Node fast = head;

        slow = slow.next;
        fast = fast.next.next;
        while(fast!=null && fast.next!=null){
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            slow = head;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
            } else {
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
        return head;
    }
}
