
public class MergeTwoSortedLinkLists {
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	     
		 if(l1==null) {
			 return l2;
		 }
		 if(l2==null) {
			 return l1;
		 }
		 ListNode newList = null;
		 ListNode newListEnd = null;
		 
		 while(l1!=null&&l2!=null) {
			 if(l1.val<=l2.val) {
				 if(newList==null) {
					 newList = new ListNode(l1.val);
					 newListEnd = newList;
				
				 }
				 else {

					 ListNode newNode  = new ListNode(l1.val);
					 newListEnd.next = newNode;
					 newListEnd = newNode;
				 }
				 
				 l1 = l1.next;
			 }
			 else {
				 if(newList==null) {
					 newList = new ListNode(l2.val);
					 newListEnd = newList;
				
				 }
				 else {

					 ListNode newNode  = new ListNode(l2.val);
					 newListEnd.next = newNode;
					 newListEnd = newNode;
				 }
				 
				 l2 = l2.next;
			 }
		 }
		 if(l1!=null) {			 
				 if(newList==null) {
					 newList = l1;
					 newListEnd = newList;
				 }
				 else {
					 newListEnd.next = l1;
				 }
			 }
		 if(l2!=null) {			 
			 if(newList==null) {
				 newList = l2;
				 newListEnd = newList;
			 }
			 else {
				 newListEnd.next = l2;
			 }
		 }
		 		 return newList;
	    }
	 
}
