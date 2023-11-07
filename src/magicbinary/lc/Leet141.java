package magicbinary.lc;

public class Leet141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        if(secondNode == firstNode) return true;
        while(secondNode!=null && firstNode!=null && firstNode != secondNode){
            firstNode = firstNode.next;
            if(secondNode.next == null) return false;
            secondNode = secondNode.next.next;
            if(firstNode == secondNode) return true;
        }
        return false;
    }
}
