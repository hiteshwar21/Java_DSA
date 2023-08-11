package LinkedLists;

public class palindromeLL extends util{

    public static void main(String[] args) {
        palindromeLL linkedList = new palindromeLL();
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(1);
        isPalindrome(head);
    }

    static void isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        Node secondPointer = null;

        if(head== null || head.next == null){
            System.out.println("Not possible to have a Palindrome");
            return;
        }

        while (fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null){
            secondPointer = slow;
        } else if(fast.next == null){
            secondPointer = slow.next;
        }

        reverseFromSecondPointer(secondPointer);
        compareTwoLinkedLists(head, secondPointer);
    }

    static void reverseFromSecondPointer(Node head){
        Node prev = null;
        Node next;

        while (head.next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
    }

    static void compareTwoLinkedLists(Node head1, Node head2){
        while(head2!=null){
            if(head1.data != head2.data){
                System.out.println("Not a Palindrome");
                return;
            } else {
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println("It is a palindrome");
    }
}
