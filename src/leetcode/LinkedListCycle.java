package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		Set<ListNode> visited = new HashSet<ListNode>();
		ListNode current = head;
		while(head !=null) {
			if(visited.contains(current)) {
				return true;
			}
			visited.add(current);
			current = current.next;
		}
		return false;
	}
	public boolean hasCycle2(ListNode head) {
		if(head == null || head.next == null) return false;
		ListNode slow = head;
		ListNode fast = head;
		while(fast !=null && fast.next !=null) {
//			check
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}

}
