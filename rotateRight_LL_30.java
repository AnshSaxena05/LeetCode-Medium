import java.util.LinkedList;
import java.util.Scanner;

public class rotateRight_LL_30 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public static ListNode rotateRight(ListNode head, int k) {
            ListNode temp = head;
            if (head == null || head.next == null || k == 0)
                return head;

            int count = 1;
            while (temp.next != null) {
                temp = temp.next; // traverse the nodes
                count++; // count number of nodes
            }
            temp.next = head; // purpose- make the linked list cyclic
            k = k % count;
            k = count - k;

            while (k-- > 0) {
                temp = temp.next;
            }
            head = temp.next;
            temp.next = null;
            return head;
        }
    }

    public static void main(String[] args) {
        rotateRight_LL_30 obj = new rotateRight_LL_30();
        LinkedList<Integer> linkedList = new LinkedList<Integer>(); // create a new linked list
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements in sorted order:");
        for (int i = 0; i < n; i++) // input values for linked list
        {
            int element = scanner.nextInt();
            linkedList.add(element);
        }
        System.out.print("Enter the number of rotations: ");
        int k = scanner.nextInt();

        scanner.close();

        // Convert LinkedList to ListNode
        ListNode head = null;
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            ListNode newNode = obj.new ListNode(linkedList.get(i));
            newNode.next = head;
            head = newNode;
        }

        head = Solution.rotateRight(head, k);

        // Convert ListNode back to LinkedList for printing
        linkedList.clear();
        ListNode temp = head;
        while (temp != null) {
            linkedList.addFirst(temp.val);
            temp = temp.next;
        }

        for (int i = linkedList.size() -1; i >=0; i--) {
            System.out.print(linkedList.get(i) + " -> ");
        }
        System.out.println("null");
    }
}
