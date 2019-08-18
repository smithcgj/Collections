/**
 * 
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class DeleteRepet {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		if(head.next == null) return head; 
		ListNode l1 = head,l2 = head.next;
		while(l2.next != null) {
			if(l1.val != l2.val) {
				l1.next = l2;
				l1 = l2;
			}
			l2 = l2.next;
		}
		if(l1.val == l2.val)
			l1.next = null;
		else 
			l1.next = l2;
		return head;
	}
}
