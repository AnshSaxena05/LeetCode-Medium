import java.util.LinkedList;
import java.util.Scanner;

public class detectCycleStartPoint_LL_24 {
    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if (fast == null || fast.next == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        detectCycleStartPoint_LL_24 obj = new detectCycleStartPoint_LL_24();
        LinkedList<Integer> linkedList = new LinkedList<Integer>(); // create a new linked list
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            linkedList.add(element);
        }

        // Convert LinkedList to ListNode
        ListNode head = null;
        ListNode tail = null;
        int cycleIndex = 0;

        if (n > 0) {
            System.out.print("Enter the index (0-based) of the node to connect the last node to (or -1 for no cycle): ");
            cycleIndex = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                ListNode newNode = obj.new ListNode(linkedList.get(i));

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
        }

        if (cycleIndex >= 0 && cycleIndex < n) {
            ListNode cycleNode = head;
            for (int i = 0; i < cycleIndex; i++) {
                cycleNode = cycleNode.next;
            }
            tail.next = cycleNode; // Connect the last node to the specified node
        }

        scanner.close();

        ListNode cycleStart = obj.detectCycle(head);

        if (cycleStart != null) {
            System.out.println("The cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("The linked list is not cyclic.");
        }
    }
}
