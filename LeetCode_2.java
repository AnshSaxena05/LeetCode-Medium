class ListNode5 {
    int val;
    ListNode5 next;
    ListNode5(int val) {
        this.val = val;
    }
    ListNode5(int val, ListNode5 next) {
        this.val = val;
        this.next = next;
    }
}
class LeetCode_2 {
    public ListNode5 addTwoNumbers(ListNode5 l1, ListNode5 l2) {
        ListNode5 dummy = new ListNode5(0);
        ListNode5 curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) { // adding l1 to our sum & moving l1
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) { // adding l2 to our sum & moving l2
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            ListNode5 newNode = new ListNode5(sum % 10);
            curr.next = newNode;
            curr = curr.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        // Example usage

        // Create two linked lists
        ListNode5 l1 = new ListNode5(2, new ListNode5(4, new ListNode5(3)));
        ListNode5 l2 = new ListNode5(5, new ListNode5(6, new ListNode5(4)));

        // Print the initial linked lists
        System.out.println("Initial Linked List 1:");
        printLinkedList(l1);
        System.out.println("\nInitial Linked List 2:");
        printLinkedList(l2);

        // Create an instance of the LeetCode_2 class
        LeetCode_2 solution = new LeetCode_2();

        // Call the addTwoNumbers method to get the result
        ListNode5 result = solution.addTwoNumbers(l1, l2);

        // Print the result linked list
        System.out.println("\nResult Linked List:");
        printLinkedList(result);
    }

    // Helper method to print the linked list
    private static void printLinkedList(ListNode5 head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        
    }

}