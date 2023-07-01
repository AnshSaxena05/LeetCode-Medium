import java.util.LinkedList;
import java.util.Scanner;

public class removeNthFromEnd_LL_32 
{
    class ListNode
    {
        public int val;
        public ListNode next;

        public ListNode(int val) 
        {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Approach: Using Two Pointers Algorithm, T.C: O(n)
        //base case
        if (head == null || head.next == null) return null;
        //we need a dummy node for helping to return the ans
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //initialize our two pointers
        ListNode left = dummy;
        ListNode right = head;

        //first loop to move the right pointer from left to right
        while(n>0 && right!=null){
            right = right.next;
            n-=1;
        }
        //now shift both our pointers
        while(right!=null){
            right = right.next;
            left = left.next;
        }
        //so, left pointer will be the nth node which we have to remove
        left.next = left.next.next;

        //return the output
        return dummy.next;
    }    
    public static void main(String[] args)
    {
        removeNthFromEnd_LL_32 obj = new removeNthFromEnd_LL_32();
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
        System.out.print("Enter the Kth node from end to remove ");
        int k = scanner.nextInt();

        scanner.close();
        
         // Convert LinkedList to ListNode
        ListNode head = null;
        for (int i = linkedList.size() - 1; i >= 0; i--) 
        {
        ListNode newNode = obj.new ListNode(linkedList.get(i));
        newNode.next = head;
        head = newNode;
        }

        head = obj.removeNthFromEnd(head, k);

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
