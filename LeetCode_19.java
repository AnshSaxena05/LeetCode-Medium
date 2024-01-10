class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3(int x) {
        this.val = x;
        next = null;
    }
}
public class LeetCode_19 {
    public ListNode3 removeNthFromEnd(ListNode3 head, int n) {
        ListNode3 fast = head, slow = head;//initialize fast & slow pointer to head
        for (int i = 0; i < n; i++) fast = fast.next;//move the fast pointer n times(n is the
                                                     //nth last node to be achieved from the end)
        if (fast == null) return head.next;//handel the case where value of n is >= to length of list
        while (fast.next != null) {// move both slow and fast pointer until fast.next !=null
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;//move the slow pointer
        return head;//return the new / old head
    }
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode3 head = new ListNode3(1);
        head.next = new ListNode3(2);
        head.next.next = new ListNode3(3);
        head.next.next.next = new ListNode3(4);
        head.next.next.next.next = new ListNode3(5);

        // Print the original linked list
        System.out.println("Original Linked List:");
        printList(head);

        // Remove the 2nd node from the end (n = 2)
        LeetCode_19 solution = new LeetCode_19();
        head = solution.removeNthFromEnd(head, 2);

        // Print the modified linked list
        System.out.println("\nLinked List after removing 2nd node from the end:");
        printList(head);
    }

    // Helper method to print the linked list
    private static void printList(ListNode3 head) {
        ListNode3 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
