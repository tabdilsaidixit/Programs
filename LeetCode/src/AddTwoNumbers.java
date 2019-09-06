import java.awt.List;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode ans = null;
		ListNode finalans = ans;
		int total = 0;
		int carry = 0;
		ListNode temp_l1 = l1;
		ListNode temp_l2 = l2;

		while (temp_l1 != null || temp_l2 != null) {
			total = carry;
			if (temp_l1 != null) {
				total += temp_l1.val;
				temp_l1 = temp_l1.next;
			}
			if (temp_l2 != null) {
				total += temp_l2.val;
				temp_l2 = temp_l2.next;
			}
			if (total > 9) {
				carry = 1;
				total = total % 10;
			}
			ListNode node = new ListNode(total);
			if (ans == null) {
				ans = node;
			} else {
				ans.next = node;
				ans = ans.next;
			}

		}

		return finalans;

	}

}
