class ListNode {
     int val;
    ListNode next;
    ListNode(int x) { val = x; } 
}
public class MergeTwo {
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {
		ListNode indexl1 = l1, indexl2 = l2,head,tar;
		if(l1 ==null && l2 == null) return null;
		if(l1 ==null) return l2;
		if(l2 == null) return l1;
		if(l1.val > l2.val) {
			head = new ListNode(l2.val);
			indexl2 = l2.next;
		}else {
			head = new ListNode(l1.val);
			indexl1 = l1.next;
		}
		tar = head;
		 while(true) {
			 if(indexl1 != null && indexl2 != null) {
				 if(indexl1.val > indexl2.val) {
						tar.next = new ListNode(indexl2.val);
						tar = tar.next;
						indexl2 = indexl2.next;
					}else {
						tar.next = new ListNode(indexl1.val);
						tar = tar.next;
						indexl1 = indexl1.next;
					}
			 }else if(indexl1 == null && indexl2 != null) {
				 tar.next = indexl2;
				 break;
			 }else if(indexl1 != null && indexl2 == null) {
				 tar.next = indexl1;
				 break;
			 }else {
				 break;
			 }
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
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		printListNode(mergeTwoLists(l1, l2));
	}
}
