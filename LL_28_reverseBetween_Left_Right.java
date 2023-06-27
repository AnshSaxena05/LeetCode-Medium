import java.util.LinkedList;
import java.util.Scanner;

public class LL_28_reverseBetween_Left_Right
{
    public class ListNode
    {
        public int val;
        public ListNode next;

        public ListNode(int val) 
        {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        if (head == null || left == right) 
        {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node before the start node
        for (int i = 1; i < left; i++) 
        {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode curr = start.next;

        // Reverse the sublist
        for (int i = left; i < right; i++) {
            start.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = start.next;
        }
        
        return dummy.next;
    }
    public static void main(String[] args)
    {
        LL_28_reverseBetween_Left_Right obj = new LL_28_reverseBetween_Left_Right();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();// create a new linked list
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements in sorted order:");
        for (int i = 0; i < n; i++) // input values for linked list
        {
            int element = scanner.nextInt();
            linkedList.add(element);
        }
        System.out.print("Enter the left limit ");
        int left = scanner.nextInt();
        System.out.print("Enter the right limit ");
        int right = scanner.nextInt();

        scanner.close();
        
         // Convert LinkedList to ListNode
        ListNode head = null;
        for (int i = linkedList.size() - 1; i >= 0; i--) 
        {
        ListNode newNode = obj.new ListNode(linkedList.get(i));
        newNode.next = head;
        head = newNode;
        }

        head = obj.reverseBetween(head, left, right);

        // Convert ListNode back to LinkedList for printing
        linkedList.clear();
        ListNode temp = head;
        while (temp != null) {
        linkedList.addFirst(temp.val);
        temp = temp.next;
        }

        for(int i=linkedList.size()-1; i >= 0; i--)
        {
            System.out.print(linkedList.get(i)+ " -> ");
        }
        System.out.println("null");
    }

}
