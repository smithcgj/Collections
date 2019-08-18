class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { 
    	 val = x;
     }
     @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.val+ "";
    }
}
public class Pairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null) return head;
		ListNode l1 = head,l2 = null,prev = null;
		if(head.next != null)
		head = head.next;
		while(l1 != null && l1.next != null) {
			l2 = l1.next;
			l1.next = l2.next;
			l2.next = l1;
			if(prev != null)
				prev.next = l2;
			prev = l1;
			l1 = l1.next;
		}
		return head;
	}
	public static void printListNode(ListNode l1) {
		while(l1.next != null) {
			System.out.print(l1.val+"->");
			l1 = l1.next;
		}
		System.out.println(l1.val);
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		//l1.next = new ListNode(2);
		//l1.next.next = new ListNode(4);
		//l1.next.next.next = new ListNode(3);
				printListNode(swapPairs(l1));
	}
}
