package magicbinary.lc;

public class Leet2LinkedList {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum  = ((l1 == null)? 0 : l1.val) + ((l2 == null)? 0 : l2.val);
        ListNode ln = new ListNode(sum%10);
        l1  = (l1 != null)? l1.next : l1;
        l2  = (l2 != null)? l2.next : l2;
        getNodeAddition(l1,l2,ln, sum/10);
        return ln;
        
    }

    void getNodeAddition(ListNode l1, ListNode l2, ListNode ans, int carry){
        if(l1== null && l2 == null) {
            if(carry == 1)
            ans.next = new ListNode(1);
            return;
        }
        int sum  = ((l1 == null)? 0 : l1.val) + ((l2 == null)? 0 : l2.val) + carry;
        ListNode newNode  = new ListNode(sum%10);
        ans.next = newNode;
        l1  = (l1 != null)? l1.next : l1;
        l2  = (l2 != null)? l2.next : l2;
        getNodeAddition(l1,l2,ans.next, sum/10);
    }
}


 class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
