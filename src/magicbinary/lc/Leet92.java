package magicbinary.lc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leet92 {

    //wrong answer code as left and right is used here as values
    //but in question, left and right are 1st index position 
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode originalhead = head, beforeLeftNode;
        while (head != null && head.next != null) {
            if (head.next.val == left)
                break;
            head = head.next;
        }
        if (head == null || head.next == null)
            return originalhead;
        beforeLeftNode = head;
        head = head.next;

        while (head != null) {
            stack.offerLast(head);
            head = head.next;
            if (head.val == right) {
                stack.offerLast(head);
                head = head.next;
                break;
            }
        }

        // reversed
        while (!stack.isEmpty()) {
            beforeLeftNode.next = stack.peekLast();
            beforeLeftNode = stack.removeLast();
        }
        beforeLeftNode.next = head;

        return originalhead;

    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}