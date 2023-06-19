import java.util.*;
public class oddEvenList_LL_20 
{
    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int val)
        {
            this.val= val;
            this.next= null;
        } 
    }
    public ListNode oddEvenList(ListNode head)
    {
        if (head == null || head.next == null) 
        {
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while (even != null && even.next != null) 
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        System.gc();
        return head;
    }    
    public static void main(String[] args)
    {
        oddEvenList_LL_20  obj = new oddEvenList_LL_20 ();
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
        scanner.close();
        
         // Convert LinkedList to ListNode
        ListNode head = null;
        for (int i = linkedList.size() - 1; i >= 0; i--) 
        {
        ListNode newNode = obj.new ListNode(linkedList.get(i));
        newNode.next = head;
        head = newNode;
        }

        head = obj.oddEvenList(head);

        // Convert ListNode back to LinkedList for printing
        linkedList.clear();
        ListNode temp = head;
        while (temp != null) {
        linkedList.addFirst(temp.val);
        temp = temp.next;
        }

        for(int i=0; i < linkedList.size(); i++)
        {
            System.out.print(linkedList.get(i)+ " -> ");
        }
        System.out.println("null");
    }
}
