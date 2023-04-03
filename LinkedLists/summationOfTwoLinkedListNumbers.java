package LinkedLists;

import java.util.Stack;

public class summationOfTwoLinkedListNumbers {

    static class Node {
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }

    public static void main(String[] args) {
      summationOfTwoLinkedListNumbers summationOfTwoLinkedListNumbers = new summationOfTwoLinkedListNumbers();
      Node head1 = new Node(1);
      head1.next = new Node(2);
      head1.next.next = new Node(3);

      Node head2 = new Node(1);
      head2.next = new Node(2);
      head2.next.next = new Node(3);
      System.out.println(getSum(head1, head2));
    }

    static Node getSum(Node first, Node second){
        Node result = null;
        int a,b,carry = 0,sum = 0;
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        while(first != null){
            s1.push(first.data);
            first = first.next;
        }
        while (second != null){
            s2.push(second.data);
            second = second.next;
        }

        while (!s1.empty() && !s2.empty()){
            a = (int) s1.pop();
            b = (int) s2.pop();

            carry = (a+b+carry)/10;
            sum = (a+b)%10;

            if(result != null){
                Node temp = new Node(sum);
                temp.next = result;
                result = temp;
            } else{
                result = new Node(sum);
            }
        }
        if(carry != 0){
            Node temp = new Node(carry);
            temp.next = result;
        }
        return result;
    }
}
