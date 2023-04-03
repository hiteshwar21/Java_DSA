package LinkedLists;

public class findIntersectionInLL {

    static class Node {
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }

    public static void main(String[] args) {
        findIntersectionInLL findIntersectionInLL = new findIntersectionInLL();
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = head1.next;

        System.out.println(findIntersection(head1, head2));
    }

    static Integer findIntersection(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == null){
                temp1 = head2;
            }

            if(temp2 == null){
                temp2 = head1;
            }

            if(temp1 == temp2){
                return temp1.data;
            }
        }
        return temp1.data;
    }

}
